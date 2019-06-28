package neu.his.temp;

import neu.his.bean.MedicalRecord;
import neu.his.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("metest")
public class metest {

    @Autowired
    MedicalRecordService medicalRecordService;

    @RequestMapping("tem")
    public void m1(){
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedicalRecordNo("001");
        medicalRecord.setId(1213);
        medicalRecordService.temporaryStorage(medicalRecord);
    }

    @RequestMapping("read")
    public void m2(){
        System.out.println(medicalRecordService.readTemporaryStorage("001"));
    }

    @RequestMapping("reads")
    public void m3(){
        List<MedicalRecord> list = /*medicalRecordService.referenceTemplateAll();
        for(MedicalRecord medicalRecord : list){
            System.out.println(medicalRecord);
        }
        list =*/ medicalRecordService.referenceTemplateDep(2);
        for(MedicalRecord medicalRecord : list){
            System.out.println(medicalRecord);
        }
/*        list = medicalRecordService.referenceTemplateDoc(2);
        for(MedicalRecord medicalRecord : list){
            System.out.println(medicalRecord);
        }*/
    }


    @RequestMapping("find")
    public void m4(){
        List<MedicalRecord> list = medicalRecordService.findAllTem(3);
        for(MedicalRecord medicalRecord : list){
            System.out.println(medicalRecord);
        }
    }

    @RequestMapping("query")
    public void m5(){
        List<MedicalRecord> list = medicalRecordService.query("category","全院",2);
        for(MedicalRecord medicalRecord : list){
            System.out.println(medicalRecord);
        }
    }
    @RequestMapping("update")
    public void m6(){
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setId(1);
        medicalRecord.setDoctorId(3);
        System.out.println(medicalRecordService.updateTemplate(medicalRecord,2));
        System.out.println(medicalRecordService.updateTemplate(medicalRecord,3));
    }

    @RequestMapping("a")
    public void m7(){
        MedicalRecord medicalRecord =medicalRecordService.findByMedicalNo("1231");
        System.out.println(medicalRecord);
    }

}
