import neu.his.bean.Diagnose;
import neu.his.bean.MedicalRecord;
import neu.his.service.impl.MedicalRecordServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/resources")
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MedicalRecordServiceImplTest {

    @Autowired
    MedicalRecordServiceImpl medicalRecordService;
    @Test
    public void temporaryStorage() {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedicalRecordNo("2019062000001");
        medicalRecord.setAllergyHistory("123123123");
        medicalRecordService.temporaryStorage(medicalRecord);
        System.out.println(medicalRecordService.readTemporaryStorage("2019062000001"));
    }
    @Test
    public void saveAsTemplate() {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedicalRecordNo("2019062000001");
        medicalRecord.setAllergyHistory("123123123");
        medicalRecordService.saveAsTemplate(medicalRecord);
    }

    @Test
    public void updateTemplate() {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setId(1);
        medicalRecord.setAllergyHistory("hhhhhhhh");
        System.out.println(medicalRecordService.updateTemplate(medicalRecord,2));
    }

    @Test
    public void deleteTemplate() {
        System.out.println(medicalRecordService.deleteTemplate(2,2));
    }

    @Test
    public void query() {
        List<MedicalRecord> list = medicalRecordService.query("category","个人",2);
        for(MedicalRecord medicalRecord : list){
            System.out.println(medicalRecord);
        }
    }

    @Test
    public void findAllTem() {
        List<MedicalRecord> list = medicalRecordService.findAllTem(2);
        for(MedicalRecord medicalRecord : list){
            System.out.println(medicalRecord);
        }
    }

    @Test
    public void referenceTemplateAll() {
        List<MedicalRecord> list = medicalRecordService.referenceTemplateAll();
        for(MedicalRecord medicalRecord : list){
            System.out.println(medicalRecord);
        }
    }

    @Test
    public void referenceTemplateDep() {
        List<MedicalRecord> list = medicalRecordService.referenceTemplateDep(2);
        for(MedicalRecord medicalRecord : list){
            System.out.println(medicalRecord);
        }
    }

    @Test
    public void referenceTemplateDoc() {
        List<MedicalRecord> list = medicalRecordService.referenceTemplateDoc(2);
        for(MedicalRecord medicalRecord : list){
            System.out.println(medicalRecord);
        }
    }

    @Test
    public void historyMed() {
        List<MedicalRecord> list = medicalRecordService.historyMed("2019062000001");
        for(MedicalRecord medicalRecord : list){
            System.out.println(medicalRecord);
        }
    }

    @Test
    public void submission() {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedicalRecordNo("2019062000001");
        medicalRecord.setAllergyHistory("123123123");
        List<Diagnose> list = new ArrayList<>();
        Diagnose diagnose = new Diagnose();
        diagnose.setDiseaseName("阿米巴病");
        list.add(diagnose);
        medicalRecordService.Submission(medicalRecord,list);
    }

    @Test
    public void findByMedNo() {
        List<Diagnose> list = medicalRecordService.findByMedNo("2019062000001");
        for(Diagnose diagnose : list){
            System.out.println(diagnose);
        }
    }

    @Test
    public void submissionDiagnose() {
        Diagnose diagnose = new Diagnose();
        diagnose.setDiseaseName("阿米巴病");
        medicalRecordService.SubmissionDiagnose(diagnose);
    }

    @Test
    public void findCommonDiagnose() {
        List<Diagnose> list = medicalRecordService.findCommonDiagnose(2);
        for(Diagnose diagnose : list){
            System.out.println(diagnose);
        }
    }

    @Test
    public void commonDiagnose() {
        Diagnose diagnose = new Diagnose();
        diagnose.setDiseaseName("阿米巴病");
        medicalRecordService.CommonDiagnose(diagnose);
    }

    @Test
    public void deleteDiagnose() {
        medicalRecordService.deleteDiagnose(2);
    }

    @Test
    public void findByMedicalNo() {
        MedicalRecord medicalRecord = medicalRecordService.findByMedicalNo("2019062000001");
        System.out.println(medicalRecord);
    }
}