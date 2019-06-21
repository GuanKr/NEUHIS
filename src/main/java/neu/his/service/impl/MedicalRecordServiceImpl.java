package neu.his.service.impl;

import neu.his.bean.*;
import neu.his.dao.*;
import neu.his.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Autowired
    MedicalRecordMapper medicalRecordMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    DiagnoseMapper diagnoseMapper;

    @Autowired
    DiseaseMapper diseaseMapper;

    @Autowired
    RegistrationInfoMapper registrationInfoMapper;

    private static List<MedicalRecord> temMedicalRecords = new ArrayList<>();

    @Override
    public void temporaryStorage(MedicalRecord medicalRecord) {
        temMedicalRecords.add(medicalRecord);
    }

    @Override
    public MedicalRecord readTemporaryStorage(String medical_record_no) {
        MedicalRecord medicalRecord = null;
        for(MedicalRecord mr : temMedicalRecords){
            if(mr.getMedicalRecordNo().equals(medical_record_no)){
                medicalRecord = mr;
            }
        }
        return medicalRecord;
    }

    @Override
    public void saveAsTemplate(MedicalRecord medicalRecord) {
        medicalRecord.setIsCommon("1");
        medicalRecordMapper.insertSelective(medicalRecord);
    }

    @Override
    public String updateTemplate(MedicalRecord medicalRecord, Integer doctorId) {
        if (medicalRecord.getDoctorId() == doctorId){
            medicalRecordMapper.updateByPrimaryKeySelective(medicalRecord);
            return "成功";
        }else {
            return "您没有权限";
        }
    }

    @Override
    public String deleteTemplate(Integer temId, Integer doctorId) {
        Integer createId = medicalRecordMapper.selectByPrimaryKey(temId).getDoctorId();
        if (createId == doctorId){
            medicalRecordMapper.deleteByPrimaryKey(temId);
            return "成功";
        }else {
            return "您没有权限";
        }
    }

    @Override
    public List<MedicalRecord> query(String attribute_name, String attribute, Integer doctorId) {
        if(attribute_name.equals("category")){
            attribute = new InspectionSetServiceImpl().translate(attribute);
        }
        List<MedicalRecord> list = medicalRecordMapper.query(new SetQuery(attribute_name,attribute,doctorId));
        for(MedicalRecord medicalRecord : list){
            medicalRecord.setCategory(new InspectionSetServiceImpl().translate(medicalRecord.getCategory()));
        }
        return list;
    }

    @Override
    public List<MedicalRecord> findAllTem(Integer doctorId) {
        return medicalRecordMapper.selectWithName(doctorId);
    }

    @Override
    public List<MedicalRecord> referenceTemplateAll() {
        MedicalRecordExample medicalRecordExample = new MedicalRecordExample();
        MedicalRecordExample.Criteria criteria = medicalRecordExample.createCriteria();
        criteria.andIsCommonEqualTo("1");
        criteria.andCategoryEqualTo("1");
        medicalRecordExample.or(criteria);
        return medicalRecordMapper.selectByExample(medicalRecordExample);
    }

    @Override
    public List<MedicalRecord> referenceTemplateDep(Integer id) {
        List<MedicalRecord> list = findAllTem(id);
        for(MedicalRecord medicalRecord : list){
            if(medicalRecord.getCategory().equals("1")||medicalRecord.getCategory().equals("3")){
                list.remove(medicalRecord);
            }
        }
        return list;
    }

    @Override
    public List<MedicalRecord> referenceTemplateDoc(Integer id) {
        MedicalRecordExample medicalRecordExample = new MedicalRecordExample();
        MedicalRecordExample.Criteria criteria = medicalRecordExample.createCriteria();
        criteria.andIsCommonEqualTo("1");
        criteria.andCategoryEqualTo("3");
        criteria.andDoctorIdEqualTo(id);
        medicalRecordExample.or(criteria);
        return medicalRecordMapper.selectByExample(medicalRecordExample);
    }

    @Override
    public List<MedicalRecord> historyMed(String idCard) {
        MedicalRecordExample medicalRecordExample = new MedicalRecordExample();

        RegistrationInfoExample registrationInfoExample = new RegistrationInfoExample();
        RegistrationInfoExample.Criteria criteria = registrationInfoExample.createCriteria();
        criteria.andPatientIdentityNumberEqualTo(idCard);
        criteria.andRegistrationStateEqualTo("1");
        registrationInfoExample.or(criteria);
        List<RegistrationInfo> registrationInfos = registrationInfoMapper.selectByExample(registrationInfoExample);
        for(RegistrationInfo registrationInfo : registrationInfos){
            medicalRecordExample.or().andMedicalRecordNoEqualTo(registrationInfo.getMedicalRecordNo());
        }
        List<MedicalRecord> list = medicalRecordMapper.selectByExample(medicalRecordExample);
        for(MedicalRecord medicalRecord : list){
            if(medicalRecord.getIsCommon().equals("1")){
                list.remove(medicalRecord);
            }
        }
        return list;
    }

    @Override
    public String Submission(MedicalRecord medicalRecord, List<Diagnose> diagnoses) {
        if(medicalRecord.getAllergyHistory().isEmpty()||medicalRecord.getAllergyHistory() == null){
            return "请输入过敏史";
        }else if(medicalRecord.getChiefComplaint().isEmpty() ||medicalRecord.getChiefComplaint() == null){
            return "请输入主诉";
        }else if(medicalRecord.getHistoryOfPresentIllness().isEmpty()||medicalRecord.getHistoryOfPresentIllness() == null){
            return "请输入现病史";
        }else if(medicalRecord.getPastHistory().isEmpty()||medicalRecord.getPastHistory() == null){
            return "请输入既往史";
        }else if(medicalRecord.getPhysicalExamination().isEmpty()||medicalRecord.getPhysicalExamination() == null){
            return "请输入体格检查";
        }else if(medicalRecord.getTreatmentOfCurrentIllness().isEmpty()||medicalRecord.getTreatmentOfCurrentIllness() == null){
            return "请输入现病治疗情况";
        }else{
            medicalRecord.setIsCommon("0");
            medicalRecord.setSeeTime(new Date());
            medicalRecordMapper.insertSelective(medicalRecord);
        }
        for(Diagnose diagnose : diagnoses){
            diagnose.setIsCommon("0");
            diagnose.setDiseaseType(new DiagnoseDirectoryServiceImpl().de_translate(diagnose.getDiseaseType()));
            diagnoseMapper.insertSelective(diagnose);
        }
        for(MedicalRecord mr : temMedicalRecords){
            if(mr.getMedicalRecordNo().equals(medicalRecord.getMedicalRecordNo())){
                temMedicalRecords.remove(mr);
            }
        }
        RegistrationInfoExample registrationInfoExample = new RegistrationInfoExample();
        registrationInfoExample.or().andMedicalRecordNoEqualTo(medicalRecord.getMedicalRecordNo());
        List<RegistrationInfo> registrationInfos = registrationInfoMapper.selectByExample(registrationInfoExample);
        for(RegistrationInfo registrationInfo : registrationInfos){
            registrationInfo.setIsSeenDoctor("1");
            registrationInfoMapper.updateByPrimaryKeySelective(registrationInfo);
        }
            return "成功";
    }

    @Override
    public List<Diagnose> findByMedNo(String medicalNo) {
            List<Diagnose> diagnoses = diagnoseMapper.selectWithName(medicalNo);
            for (Diagnose diagnose : diagnoses) {
                diagnose.setDiseaseType(new DiagnoseDirectoryServiceImpl().translate(diagnose.getDiseaseType()));
            }
            return diagnoses;
    }

    @Override
    public void SubmissionDiagnose(Diagnose diagnose) {
        DiseaseExample diseaseExample = new DiseaseExample();
        diseaseExample.or().andDiseaseNameEqualTo(diagnose.getDiseaseName());
        List<Disease> diseases = diseaseMapper.selectByExample(diseaseExample);
        for(Disease disease : diseases){
            diagnose.setDiseaseId(disease.getId());
        }
        diagnose.setIsCommon("0");
        diagnose.setDiseaseType(new DiagnoseDirectoryServiceImpl().de_translate(diagnose.getDiseaseType()));
        diagnoseMapper.insertSelective(diagnose);
    }

    @Override
    public List<Diagnose> findCommonDiagnose(Integer id) {
        DiagnoseExample diagnoseExample = new DiagnoseExample();
        DiagnoseExample.Criteria criteria = diagnoseExample.createCriteria();
        criteria.andDoctorIdEqualTo(id);
        criteria.andIsCommonEqualTo("1");
        diagnoseExample.or(criteria);
        List<Diagnose> list = diagnoseMapper.selectByExample(diagnoseExample);
        for(Diagnose diagnose : list){
            Disease disease = diseaseMapper.selectByPrimaryKey(diagnose.getDiseaseId());
            diagnose.setMajorDiagnoseSign(disease.getDiseaseName());
            diagnose.setSuspectedSign(disease.getInternationalIcdCode());
        }
        return list;
    }

    @Override
    public void CommonDiagnose(Diagnose diagnose) {
        diagnose.setIsCommon("1");
        diagnoseMapper.insertSelective(diagnose);
    }

    @Override
    public void deleteDiagnose(Integer id) {
        diagnoseMapper.deleteByPrimaryKey(id);
    }
}
