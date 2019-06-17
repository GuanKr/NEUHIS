package neu.his.service.impl;

import neu.his.bean.MedicalRecord;
import neu.his.bean.MedicalRecordExample;
import neu.his.dao.MedicalRecordMapper;
import neu.his.dao.UserMapper;
import neu.his.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Autowired
    MedicalRecordMapper medicalRecordMapper;

    @Autowired
    UserMapper userMapper;

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
    public List<MedicalRecord> referenceTemplateAll() {
        MedicalRecordExample medicalRecordExample = new MedicalRecordExample();
        medicalRecordExample.or().andIsCommonEqualTo("1");
        return medicalRecordMapper.selectByExample(medicalRecordExample);
    }

    @Override
    public List<MedicalRecord> referenceTemplatDep(Integer id) {
        return null;
    }

    @Override
    public List<MedicalRecord> referenceTemplatDoc() {
        return null;
    }


}
