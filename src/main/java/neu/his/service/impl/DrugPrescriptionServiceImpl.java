package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.dao.DrugCommonMapper;
import neu.his.dao.DrugMapper;
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

    @Autowired
    DrugMapper drugMapper;

    private static List<DrugPrescription> temDrugPre = new ArrayList<>();
    private static int temPreId = 1;


    public String translate(String type) {
        switch (type) {
            case "0":
                return "未发";
            case "1":
                return "已退";
            case "2":
                return "已发";
            case "未发":
                return "0";
            case "已退":
                return "1";
            case "已发":
                return "2";
            default:
                return null;
        }
    }

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
/*        Drug drug = new Drug();
        drug.setDrugName(drugPrescription.getDrugName());
        List<Drug> list = new DrugServiceImpl().query(drug);*/
        DrugExample drugExample = new DrugExample();
        drugExample.or().andDrugNameEqualTo(drugPrescription.getDrugName());
        List<Drug> list = drugMapper.selectByExample(drugExample);
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
    public String deletePrescription(Integer id) {
        DrugPrescription drugPrescription = drugPrescriptionMapper.selectByPrimaryKey(id);
        if(drugPrescription.getPaymentState().equals("1")){
            return "已缴费，不可作废";
        }else{
            drugPrescription.setStatus("0");
            drugPrescriptionMapper.updateByPrimaryKeySelective(drugPrescription);
            return "成功";
        }
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

    @Override
    public List<DrugPrescription> findByMedNo(String medicalNo, String state) {
        DrugPrescriptionExample drugPrescriptionExample = new DrugPrescriptionExample();
        DrugPrescriptionExample.Criteria criteria = drugPrescriptionExample.createCriteria();
        criteria.andMedicalRecordNoEqualTo(medicalNo);
        criteria.andStatusEqualTo("1");
        criteria.andTakeMedicineStateEqualTo(state);
        drugPrescriptionExample.or(criteria);
        List<DrugPrescription> list = drugPrescriptionMapper.selectByExample(drugPrescriptionExample);
        for(DrugPrescription drugPrescription : list){
            drugPrescription.setDrugName(drugMapper.selectByPrimaryKey(drugPrescription.getDrugId()).getDrugName());
        }
        return list;
    }

    @Override
    public List<DrugPrescription> findDispense(String medicalNo) {
        DrugPrescriptionExample drugPrescriptionExample = new DrugPrescriptionExample();
        DrugPrescriptionExample.Criteria criteria = drugPrescriptionExample.createCriteria();
        criteria.andMedicalRecordNoEqualTo(medicalNo);
        criteria.andStatusEqualTo("1");
        criteria.andTakeMedicineStateEqualTo("0");
        criteria.andPaymentStateEqualTo("1");
        drugPrescriptionExample.or(criteria);
        List<DrugPrescription> list = drugPrescriptionMapper.selectByExample(drugPrescriptionExample);
        for(DrugPrescription drugPrescription : list){
            drugPrescription.setDrugName(drugMapper.selectByPrimaryKey(drugPrescription.getDrugId()).getDrugName());
        }
        return list;
    }

    @Override
    public void dispense(DrugPrescription drugPrescription) {
        drugPrescription.setTakeMedicineState("2");
        drugPrescriptionMapper.updateByPrimaryKeySelective(drugPrescription);
    }

    @Override
    public String drugReturn(DrugPrescription drugPrescription, Integer returnQuantity) {
        DrugPrescription returnDrugPrescription = drugPrescription;
        if (drugPrescription.getQuantity() > returnQuantity) {
            drugPrescription.setQuantity(drugPrescription.getQuantity() - returnQuantity);
            drugPrescription.setCost(drugPrescription.getDrugPrice().multiply(new BigDecimal(drugPrescription.getQuantity())));
            drugPrescriptionMapper.updateByPrimaryKeySelective(drugPrescription);
            returnDrugPrescription.setTakeMedicineState("1");
            returnDrugPrescription.setQuantity(returnQuantity);
            returnDrugPrescription.setCost(drugPrescription.getDrugPrice().multiply(new BigDecimal(drugPrescription.getQuantity())));
            returnDrugPrescription.setId(null);
            drugPrescriptionMapper.insertSelective(returnDrugPrescription);
            return "成功";
        } else if (drugPrescription.getQuantity() == returnQuantity) {
            drugPrescriptionMapper.deleteByPrimaryKey(drugPrescription.getId());
            returnDrugPrescription.setTakeMedicineState("1");
            returnDrugPrescription.setQuantity(returnQuantity);
            returnDrugPrescription.setCost(drugPrescription.getDrugPrice().multiply(new BigDecimal(drugPrescription.getQuantity())));
            returnDrugPrescription.setId(null);
            drugPrescriptionMapper.insertSelective(returnDrugPrescription);
            return "成功";
        } else {
            return "退药数量超过可退数量";
        }
    }

    @Override
    public List<Integer> returnAll(List<DrugPrescription> list) {
        List<Integer> quantities = new ArrayList<>();
        for(DrugPrescription drugPrescription : list){
            quantities.add(drugPrescription.getQuantity());
        }
        return quantities;
    }

    @Override
    public List<DrugPrescription> findPrescription(String medicalNo) {
        DrugPrescriptionExample drugPrescriptionExample = new DrugPrescriptionExample();
        DrugPrescriptionExample.Criteria criteria = drugPrescriptionExample.createCriteria();
        criteria.andStatusEqualTo("1");
        criteria.andMedicalRecordNoEqualTo(medicalNo);
        drugPrescriptionExample.or(criteria);
        List<DrugPrescription> list = drugPrescriptionMapper.selectByExample(drugPrescriptionExample);
        for(DrugPrescription drugPrescription : list){
            drugPrescription.setDrugName(drugMapper.selectByPrimaryKey(drugPrescription.getDrugId()).getDrugName());
        }
        return list;
    }
}
