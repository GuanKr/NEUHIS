package neu.his.controller;

import neu.his.bean.Diagnose;
import neu.his.bean.MedicalRecord;
import neu.his.dto.DiagnoseDTO;
import neu.his.dto.ResultDTO;
import neu.his.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("medicalRecord")
public class MedicalRecordController {
    @Autowired
    MedicalRecordService medicalRecordService;

    /**
     * 定向到病例首页
     * @return 病例首页JSP
     */
    @RequestMapping("medicalRecord")
    public String toMedicalRecord(){
        return "medicalRecord/medicalRecord";
    }
    /**
     *
     * @param doctorId 医生id
     * @param medicalRecord 病历首页
     * @param diagnoseDTO 诊断列表
     */
    @RequestMapping("submitMedicalRecord")
    public @ResponseBody ResultDTO submitMedicalRecord(int doctorId,String medicalRecordNo,MedicalRecord medicalRecord, DiagnoseDTO diagnoseDTO){
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
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(medicalRecordService.Submission(medicalRecord,diagnoses));
        return resultDTO;
    }
    /**
     * 保存病历首页模板
     * @param medicalRecord 病例首页
     */
    @RequestMapping("saveMedicalRecordTemplate")
    public @ResponseBody void saveMedicalRecordTemplate(MedicalRecord medicalRecord){
        medicalRecordService.saveAsTemplate(medicalRecord);
    }
    /**
     * 获取所有模板
     * @return 全院模板
     */
    @RequestMapping("getHospitalCommon")
    public @ResponseBody List<MedicalRecord> getHospitalCommon(){
        return medicalRecordService.referenceTemplateAll();
    }
    /**
     * 获取科室模板
     * @param doctorID 医生ID
     * @return 医生所在科室模板
     */
    @RequestMapping("getDepartmentCommon")
    public @ResponseBody List<MedicalRecord> getDepartmentCommon(int doctorID){
        return medicalRecordService.referenceTemplateDep(doctorID);
    }
    /**
     * 获取个人模板
     * @param doctorID 医生ID
     * @return 医生个人模板
     */
    @RequestMapping("getPersonalCommon")
    public @ResponseBody List<MedicalRecord> getPersonalCommon(int doctorID){
        return medicalRecordService.referenceTemplateDoc(doctorID);
    }
    /**
     * 修改模板
     * @param operatorDoctorId 操作医生ID
     * @param medicalRecord 病例模板
     * @return 是否成功
     */
    @RequestMapping("modifyMedicalRecordTemplate")
    public @ResponseBody ResultDTO modifyMedicalRecordTemplate(int operatorDoctorId,MedicalRecord medicalRecord){
        int doctorID = operatorDoctorId;
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(medicalRecordService.updateTemplate(medicalRecord,doctorID));
        return resultDTO;
    }

    /**
     * 删除模板
     * @param operatorDoctorId 操作医生ID
     * @param templateId 模板ID
     * @return 是否成功
     */
    @RequestMapping("deleteMedicalRecordTemplate")
    public @ResponseBody ResultDTO deleteMedicalRecordTemplate(int operatorDoctorId,int templateId){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(medicalRecordService.deleteTemplate(templateId,operatorDoctorId));
        return resultDTO;
    }
}
