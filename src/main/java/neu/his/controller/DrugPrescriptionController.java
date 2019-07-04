package neu.his.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import neu.his.bean.*;
import neu.his.dto.DrugPrescriptionDTO;
import neu.his.dto.PrescriptionSetDetailDTO;
import neu.his.dto.ResultDTO;
import neu.his.service.DrugPrescriptionService;
import neu.his.service.DrugService;
import neu.his.service.PrescriptionSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("drugPrescription")
public class DrugPrescriptionController {
    @Autowired
    DrugPrescriptionService drugPrescriptionService;
    @Autowired
    DrugService drugService;
    @Autowired
    PrescriptionSetService prescriptionSetService;

    /**
     * 通过助记码查找药品
     * @param drugMnemonicCode 药品助记码
     * @return 药品列表
     */
    @RequestMapping("findDrugsByMnemonicCode")
    public @ResponseBody List<Drug> findDrugsByMnemonicCode(String drugMnemonicCode){

//        PageHelper.startPage(1,30);
//        List<Disease> diseaseList = diseaseService.findAllByAttribute_name(attribute_name,attribute);
//        PageInfo<Disease> pageInfo = new PageInfo(diseaseList);
//        diseaseList = pageInfo.getList();
//        return diseaseList;

        Drug drug = new Drug();
        drug.setMnemonicCode(drugMnemonicCode);
        PageHelper.startPage(1,30);
        List<Drug> drugList = drugService.query(drug);
        PageInfo<Drug> pageInfo = new PageInfo<>(drugList);
        drugList = pageInfo.getList();
        return drugList;
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
    public @ResponseBody ResultDTO submitDrugPrescription(int doctorId, String medicalRecordNo, DrugPrescriptionDTO drugPrescriptionDTO){
        List<DrugPrescription> drugPrescriptionList = drugPrescriptionDTO.getDrugPrescription();
        String info = "";
        for (DrugPrescription drugPrescription : drugPrescriptionList) {
            drugPrescription.setDoctorId(doctorId);
            drugPrescription.setMedicalRecordNo(medicalRecordNo);
            info = drugPrescriptionService.sendPrescription(drugPrescription);
        }
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(info);
        return resultDTO;
    }

    /**
     * 获取已开立的处方
     * @param medicalRecordNo 病历号
     * @return 开立的处方列表
     */
    @RequestMapping("getOpenedDrugPrescription")
    public @ResponseBody ResultDTO getOpenedDrugPrescription(String medicalRecordNo){
        ResultDTO resultDTO = new ResultDTO();
        List<DrugPrescription> drugPrescriptionList = drugPrescriptionService.findPrescription(medicalRecordNo);
        if (!drugPrescriptionList.isEmpty()){
            resultDTO.setData(drugPrescriptionList);
        }
        return resultDTO;
    }

    /**
     * 作废处方
     * @param drugPrescriptionId 处方id
     * @return 成功或失败原因
     */
    @RequestMapping("invalidDrugPrescription")
    public @ResponseBody ResultDTO invalidDrugPrescription(int drugPrescriptionId){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(drugPrescriptionService.deletePrescription(drugPrescriptionId));
        return resultDTO;
    }

    /**
     * 查找所有处方组套
     * @param doctorId 医生ID
     * @return 处方组套
     */
    @RequestMapping("getDrugPrescriptionSets")
    public @ResponseBody List<PrescriptionSet> getDrugPrescriptionSets(int doctorId){
        return prescriptionSetService.findAllSet(doctorId);
    }

    /**
     * 查找某一组套的明细
     * @param setId 组套id
     * @return 处方组套的组套明细
     */
    @RequestMapping("findDetailBySetId")
    public @ResponseBody List<PrescriptionSetDetail> findDetailBySetId(int setId){
        return prescriptionSetService.findDetailBySet(setId);
    }

    /**
     * 存为处方组套
     * @param prescriptionSet 处方组套
     * @param drugPrescriptionDTO 处方组套药品列表
     */
    @RequestMapping("saveDrugSet")
    public @ResponseBody void saveDrugSet(PrescriptionSet prescriptionSet, DrugPrescriptionDTO drugPrescriptionDTO){
        List<DrugPrescription> drugPrescriptionList = drugPrescriptionDTO.getDrugPrescription();
        prescriptionSetService.saveAsSet(prescriptionSet,drugPrescriptionList);
    }

    /**
     * 删除处方组套
     * @param setId 组套id
     * @param doctorId 医生id
     * @return 成功或失败原因
     */
    @RequestMapping("deleteSet")
    public @ResponseBody ResultDTO deleteSet(int setId, int doctorId){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(prescriptionSetService.deleteSet(setId,doctorId));
        return resultDTO;
    }

    /**
     * 更新处方组套
     * @param doctorId 医生id
     * @param prescriptionSet 处方组套
     * @return 成功或失败原因
     */
    @RequestMapping("updateSet")
    public @ResponseBody ResultDTO updateSet(int doctorId,PrescriptionSet prescriptionSet){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(prescriptionSetService.updateSet(prescriptionSet,doctorId));
        return resultDTO;
    }

    /**
     * 设为常用药
     * @param doctorId 医生id
     * @param drug 常用药
     */
    @RequestMapping("setCommon")
    public @ResponseBody void setCommon(int doctorId,Drug drug){
        drugPrescriptionService.insertCommon(drug,doctorId);
    }

    /**
     * 获取常用药
     * @param doctorId 医生id
     * @return 常用药列表
     */
    @RequestMapping("getCommons")
    public @ResponseBody List<DrugCommon> setCommon(int doctorId){
        return drugPrescriptionService.findCommon(doctorId);
    }

    /**
     * 删除常用药品
     * @param commonDrugId 常用药品id
     */
    @RequestMapping("deleteCommonDrug")
    public @ResponseBody void deleteCommonDrug(int commonDrugId){
        drugPrescriptionService.deleteCommon(commonDrugId);
    }
}
