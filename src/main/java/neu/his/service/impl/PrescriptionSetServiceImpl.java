package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.dao.DrugPrescriptionMapper;
import neu.his.dao.PrescriptionSetDetailMapper;
import neu.his.dao.PrescriptionSetMapper;
import neu.his.service.PrescriptionSetService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PrescriptionSetServiceImpl implements PrescriptionSetService {
    @Autowired
    DrugPrescriptionMapper drugPrescriptionMapper;

    @Autowired
    PrescriptionSetMapper prescriptionSetMapper;

    @Autowired
    PrescriptionSetDetailMapper prescriptionSetDetailMapper;

    @Override
    public List<PrescriptionSet> findAllSet(Integer doctorId) {
        List<PrescriptionSet> list = prescriptionSetMapper.selectWithName(doctorId);
        for(PrescriptionSet prescriptionSet : list){
            prescriptionSet.setCategory(new InspectionSetServiceImpl().translate(prescriptionSet.getCategory()));
        }
        return list;
    }

    @Override
    public List<PrescriptionSetDetail> findDetailBySet(Integer setId) {
        return prescriptionSetDetailMapper.selectBySet(setId);
    }

    @Override
    public void saveAsSet(PrescriptionSet prescriptionSet, List<DrugPrescription> list) {
        prescriptionSet.setCategory(new InspectionSetServiceImpl().translate(prescriptionSet.getCategory()));
        prescriptionSet.setCreateTime(new Date());
        prescriptionSetMapper.insertSelective(prescriptionSet);
        PrescriptionSetExample prescriptionSetExample = new PrescriptionSetExample();
        PrescriptionSetExample.Criteria criteria = prescriptionSetExample.createCriteria();
        criteria.andDoctorIdEqualTo(prescriptionSet.getDoctorId());
        criteria.andCreateTimeEqualTo(prescriptionSet.getCreateTime());
        prescriptionSetExample.or(criteria);
        Integer setId = prescriptionSetMapper.selectByExample(prescriptionSetExample).get(0).getId();
        PrescriptionSetDetail prescriptionSetDetail = new PrescriptionSetDetail();
        prescriptionSetDetail.setPrescriptionSetId(setId);
        for(DrugPrescription drugPrescription : list){
            prescriptionSetDetail.setDrugName(drugPrescription.getDrugName());
            prescriptionSetDetail.setDrugDosage(drugPrescription.getDrugDosage());
            prescriptionSetDetail.setDrugFormat(drugPrescription.getDrugFormat());
            prescriptionSetDetail.setDrugUsage(drugPrescription.getDrugUsage());
            prescriptionSetDetail.setFrequency(drugPrescription.getFrequency());
            prescriptionSetDetailMapper.insertDetail(prescriptionSetDetail);
        }
    }

    @Override
    public String deleteSet(Integer id, Integer doctorId) {
        PrescriptionSet prescriptionSet = prescriptionSetMapper.selectByPrimaryKey(id);
        if (prescriptionSet.getDoctorId() == doctorId) {
            prescriptionSetMapper.deleteByPrimaryKey(id);
            PrescriptionSetDetailExample prescriptionSetDetailExample = new PrescriptionSetDetailExample();
            prescriptionSetDetailExample.or().andPrescriptionSetIdEqualTo(id);
            prescriptionSetDetailMapper.deleteByExample(prescriptionSetDetailExample);
            return "成功";
        } else {
            return "您没有权限";
        }
    }

    @Override
    public String updateSet(PrescriptionSet prescriptionSet, Integer doctorId) {
        if(prescriptionSet.getDoctorId() == doctorId){
            prescriptionSet.setCategory(new InspectionSetServiceImpl().translate(prescriptionSet.getCategory()));
            prescriptionSetMapper.updateByPrimaryKeySelective(prescriptionSet);
            return "成功";
        }else{
            return "您没有权限";
        }
    }

    @Override
    public String deleteSetDetail(Integer id, Integer doctorId) {
        PrescriptionSetDetail prescriptionSetDetail = prescriptionSetDetailMapper.selectByPrimaryKey(id);
        PrescriptionSet prescriptionSet = prescriptionSetMapper.selectByPrimaryKey(prescriptionSetDetail.getPrescriptionSetId());
        if(prescriptionSet.getDoctorId() == doctorId){
            prescriptionSetDetailMapper.deleteByPrimaryKey(id);
            return "成功";
        }else {
            return "您没有权限";
        }
    }

    @Override
    public String insertSetDetail(PrescriptionSetDetail prescriptionSetDetail, Integer doctorId) {
        PrescriptionSet prescriptionSet = prescriptionSetMapper.selectByPrimaryKey(prescriptionSetDetail.getPrescriptionSetId());
        if(prescriptionSet.getDoctorId() == doctorId){
            prescriptionSetDetailMapper.insertDetail(prescriptionSetDetail);
            return "成功";
        }else {
            return "您没有权限";
        }
    }

    @Override
    public List<PrescriptionSet> query(String attribute_name, String attribute, Integer doctorId) {
        if(attribute_name.equals("category")){
            attribute = new InspectionSetServiceImpl().translate(attribute);
        }
        List<PrescriptionSet> list = prescriptionSetMapper.query(new SetQuery(attribute_name,attribute,doctorId));
        for(PrescriptionSet inspectionSet : list){
            inspectionSet.setCategory(new InspectionSetServiceImpl().translate(inspectionSet.getCategory()));
        }
        return list;
    }

}
