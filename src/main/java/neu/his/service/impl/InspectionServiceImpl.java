package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.dao.InspectionMapper;
import neu.his.dao.InspectionRegisterMapper;
import neu.his.dao.RegistrationInfoMapper;
import neu.his.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InspectionServiceImpl implements InspectionService {

    @Autowired
    InspectionMapper inspectionMapper;

    @Autowired
    InspectionRegisterMapper inspectionRegisterMapper;

    @Autowired
    RegistrationInfoMapper registrationInfoMapper;

    private static List<Inspection> temList = new ArrayList<>();
    private static int temId = 1;

    @Override
    public List<Inspection> findByMedicalNo(String medicalNo) {
       return inspectionMapper.selectWithName(medicalNo);
    }

    @Override
    public void addInspection(Inspection inspection) {
        inspection.setIsCommon("0");
        inspection.setPayState("0");
        inspection.setRegisterState("0");
        inspection.setValidity("1");
        inspectionMapper.insertSelective(inspection);
    }

    @Override
    public void temporaryStorage(Inspection inspection) {
        inspection.setId(temId);
        temList.add(inspection);
        temId++;
    }

    @Override
    public List<Inspection> findTemStorage(Inspection inspection) {
        List<Inspection> list = new ArrayList<>();
        for(Inspection inspection1 : temList){
            if(inspection1.getMedicalRecordNo().equals(inspection.getMedicalRecordNo())&&inspection.getDoctorId().equals(inspection.getDoctorId())){
                list.add(inspection1);
            }
        }
        return list;
    }

    @Override
    public void updateTemStorage(Inspection inspection) {
        for (Inspection inspection1 : temList) {
            if (inspection1.getId().equals(inspection.getId())) {
                inspection1 = inspection;
            }
        }
    }

    @Override
    public void deleteTemStorage(Integer id) {
        for (Inspection inspection1 : temList) {
            if (inspection1.getId().equals(id)) {
                temList.remove(inspection1);
            }
        }
    }

    @Override
    public String deleteInspection(Inspection inspection) {
        if(inspection.getRegisterState().equals("1")){
            return "已开立，无法作废";
        }else{
            inspection.setValidity("0");
            inspectionMapper.updateByPrimaryKeySelective(inspection);
        }
        return "作废成功";
    }

    @Override
    public String findResult(Integer id) {
        Inspection inspection = inspectionMapper.selectByPrimaryKey(id);
        if(inspection.getInspectionResultAnalysis() == null||inspection.getInspectionResultAnalysis().isEmpty()){
            return null;
        }else{
            return inspection.getInspectionResultAnalysis();
        }
    }

    @Override
    public void common(Inspection inspection) {
        inspection.setIsCommon("1");
        inspectionMapper.insertSelective(inspection);
    }

    @Override
    public List<Inspection> findCommon(Integer id) {
        return inspectionMapper.selectCommon(id);
    }

    @Override
    public void deleteCommon(Integer id) {
        inspectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateCommon(Inspection inspection) {
        inspectionMapper.updateByPrimaryKeySelective(inspection);
    }

    @Override
    public String register(Inspection inspection,Integer doctorId) {
        if(inspection.getPayState().equals("0")){
            return "未缴费！";
        }else {
            inspection.setRegisterState("1");
            inspectionMapper.updateByPrimaryKeySelective(inspection);
            RegistrationInfoExample registrationInfoExample = new RegistrationInfoExample();
            registrationInfoExample.or().andMedicalRecordNoEqualTo(inspection.getMedicalRecordNo());
            List<RegistrationInfo> list = registrationInfoMapper.selectByExample(registrationInfoExample);
            InspectionRegister inspectionRegister = new InspectionRegister();
            inspectionRegister.setCost(inspection.getCost());
            inspectionRegister.setDoctorId(doctorId);
            inspectionRegister.setMedicalRecordNo(inspection.getMedicalRecordNo());
            inspectionRegister.setRegisterTime(new Date());
            for(RegistrationInfo registrationInfo : list){
                inspectionRegister.setPatientName(registrationInfo.getPatientName());
            }
            inspectionRegisterMapper.insertSelective(inspectionRegister);
            return "成功";
        }
    }

    @Override
    public List<Inspection> selectByNameOrMedNo(String attribute_name, String attribute, Integer doctorId) {
        return inspectionMapper.selectByNameOrMedNo(new SetQuery(attribute_name,attribute,doctorId));
    }

    @Override
    public void inputResult(Integer id,String result) {
        Inspection inspection = inspectionMapper.selectByPrimaryKey(id);
        inspection.setInspectionResultAnalysis(result);
        inspectionMapper.updateByPrimaryKeySelective(inspection);
    }

    @Override
    public List<InspectionRegister> workloadStatistics(Date startTime, Date endTime, Integer doctorId) {
        InspectionRegisterExample inspectionRegisterExample = new InspectionRegisterExample();
        InspectionRegisterExample.Criteria criteria = inspectionRegisterExample.createCriteria();
        criteria.andRegisterTimeBetween(startTime,endTime);
        criteria.andDoctorIdEqualTo(doctorId);
        inspectionRegisterExample.or(criteria);
        return inspectionRegisterMapper.selectByExample(inspectionRegisterExample);
    }

}
