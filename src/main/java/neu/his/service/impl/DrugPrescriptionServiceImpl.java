package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.dao.DrugCommonMapper;
import neu.his.dao.DrugPrescriptionMapper;
import neu.his.dao.DrugUsageDetailMapper;
import neu.his.service.DrugPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class DrugPrescriptionServiceImpl implements DrugPrescriptionService {
    @Autowired
    DrugUsageDetailMapper drugUsageDetailMapper;

    @Autowired
    DrugPrescriptionMapper drugPrescriptionMapper;

    @Autowired
    DrugCommonMapper drugCommonMapper;

    private static List<DrugPrescription> temDrugPre = new ArrayList<>();
    private static int temPreId = 1;

    @Override
    public List<DrugUsageDetail> findUsage() {
        return drugUsageDetailMapper.selectByExample(new DrugUsageDetailExample());
    }

    @Override
    public void temporaryStorage(DrugPrescription drugPrescription) {
        drugPrescription.setId(temPreId);
        temDrugPre.add(drugPrescription);
        temPreId++;
    }

    @Override
    public List<DrugPrescription> findTemStorage(DrugPrescription drugPrescription) {
        List<DrugPrescription> list = new ArrayList<>();
        for(DrugPrescription drugPrescription1 : temDrugPre){
            if(drugPrescription1.getMedicalRecordNo().equals(drugPrescription.getMedicalRecordNo())&&drugPrescription.getDoctorId().equals(drugPrescription.getDoctorId())){
                list.add(drugPrescription1);
            }
        }
        return list;
    }

    @Override
    public void updateTemStorage(DrugPrescription drugPrescription) {
        for (DrugPrescription drugPrescription1 : temDrugPre) {
            if (drugPrescription1.getId().equals(drugPrescription.getId())) {
                drugPrescription1 = drugPrescription;
            }
        }
    }

    @Override
    public void deleteTemStorage(Integer id) {
        for (DrugPrescription drugPrescription : temDrugPre) {
            if (drugPrescription.getId().equals(id)) {
                temDrugPre.remove(drugPrescription);
            }
        }
    }

    @Override
    public void sendPrescription(DrugPrescription drugPrescription) {
        drugPrescription.setPaymentState("0");
        drugPrescription.setTakeMedicineState("0");
        drugPrescription.setStatus("1");
        drugPrescription.setCost(drugPrescription.getDrugPrice().multiply(new BigDecimal(drugPrescription.getQuantity())));
        Drug drug = new Drug();
        drug.setDrugName(drugPrescription.getDrugName());
        List<Drug> list = new DrugServiceImpl().query(drug);
        for(Drug drug1 : list){
            if(drug1.getDrugType().equals("中草药")){
                drugPrescription.setDrugType("1");
            }else{
                drugPrescription.setDrugType("2");
            }
        }
        drugPrescriptionMapper.insertSelective(drugPrescription);
    }

    @Override
    public void deletePrescription(Integer id) {
        drugPrescriptionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<DrugCommon> findCommon(Integer doctorId) {
        DrugCommonExample drugCommonExample = new DrugCommonExample();
        drugCommonExample.or().andDoctorIdEqualTo(doctorId);
        return drugCommonMapper.selectByExample(drugCommonExample);
    }

    @Override
    public void insertCommon(Drug drug, Integer doctorId) {
        DrugCommon drugCommon = new DrugCommon();
        drugCommon.setDrugName(drug.getDrugName());
        drugCommon.setDrugFormat(drug.getDrugFormat());
        drugCommon.setDoctorId(doctorId);
        drugCommonMapper.insertSelective(drugCommon);
    }

    @Override
    public void deleteCommon(Integer id) {
        drugCommonMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Double costAll(List<DrugPrescription> list) {
        BigDecimal cost1 = new BigDecimal("0");
        for(DrugPrescription drugPrescription : list ){
            if(drugPrescription.getStatus().equals("1")){
                cost1 = cost1.add(drugPrescription.getDrugPrice().multiply(new BigDecimal(drugPrescription.getQuantity())));
            }
        }
        Double cost = cost1.doubleValue();
        return cost;
    }

}
