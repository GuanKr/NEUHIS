package neu.his.controller;

import neu.his.bean.Drug;
import neu.his.bean.DrugPrescription;
import neu.his.bean.DrugUsageDetail;
import neu.his.dto.DrugPrescriptionDTO;
import neu.his.service.DrugPrescriptionService;
import neu.his.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("drugPrescription")
public class DrugPrescriptionController {
    @Autowired
    DrugPrescriptionService drugPrescriptionService;
    @Autowired
    DrugService drugService;

    /**
     * 通过助记码查找药品
     * @param drugMnemonicCode 药品助记码
     * @return 药品列表
     */
    @RequestMapping("findDrugsByMnemonicCode")
    public @ResponseBody List<Drug> findDrugsByMnemonicCode(String drugMnemonicCode){
        Drug drug = new Drug();
        drug.setMnemonicCode(drugMnemonicCode);
        return drugService.query(drug);
    }

    /**
     * 通过名称查找药品
     * @param drugName 药品名称
     * @return 药品列表
     */
    @RequestMapping("findDrugsByName")
    public @ResponseBody List<Drug> findDrugsByName(String drugName){
        Drug drug = new Drug();
        drug.setDrugName(drugName);
        return drugService.query(drug);
    }

    /**
     * 获取药品使用方式
     * @return 药品使用方式
     */
    @RequestMapping("findUsage")
    public @ResponseBody List<DrugUsageDetail> findUsage(){
        return drugPrescriptionService.findUsage();
    }

    /**
     * 开立处方
     * @param doctorId 医生ID
     * @param medicalRecordNo 病历号
     * @param drugPrescriptionDTO 处方药品列表
     */
    @RequestMapping("submitDrugPrescription")
    public @ResponseBody void submitDrugPrescription(int doctorId, String medicalRecordNo, DrugPrescriptionDTO drugPrescriptionDTO){
        List<DrugPrescription> drugPrescriptionList = drugPrescriptionDTO.getDrugPrescriptionList();
        for (DrugPrescription drugPrescription : drugPrescriptionList) {
            drugPrescription.setDoctorId(doctorId);
            drugPrescription.setMedicalRecordNo(medicalRecordNo);
            drugPrescriptionService.sendPrescription(drugPrescription);
        }
    }
}
