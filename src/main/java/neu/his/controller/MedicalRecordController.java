package neu.his.controller;

import neu.his.bean.Diagnose;
import neu.his.bean.MedicalRecord;
import neu.his.dto.DiagnoseDTO;
import neu.his.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("medicalRecord")
public class MedicalRecordController {
    @Autowired
    MedicalRecordService medicalRecordService;

    /**
     *
     * @param doctorId 医生id
     * @param medicalRecord 病历首页
     * @param diagnoseDTO 诊断列表
     */
    @RequestMapping("submitMedicalRecord")
    public @ResponseBody String submitMedicalRecord(int doctorId,String medicalRecordNo,MedicalRecord medicalRecord, DiagnoseDTO diagnoseDTO){
        List<Diagnose> diagnoses = diagnoseDTO.getDiagnoses();
        for (Diagnose diagnose : diagnoses) {
            diagnose.setMedicalRecordNo(medicalRecordNo);
            diagnose.setDoctorId(doctorId);
            if (diagnose.getMajorDiagnoseSign().equals("0")){
                diagnose.setSuspectedSign("1");
            }else {
                diagnose.setSuspectedSign("0");
            }
        }
        return medicalRecordService.Submission(medicalRecord,diagnoses);
    }
}
