package neu.his.controller;

import neu.his.bean.Inspection;
import neu.his.bean.InspectionSet;
import neu.his.bean.InspectionSetDetail;
import neu.his.dto.InspectionDTO;
import neu.his.dto.ResultDTO;
import neu.his.service.InspectionService;
import neu.his.service.InspectionSetService;
import neu.his.service.NonDrugListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("inspection")
public class InspectionController {
    @Autowired
    InspectionService inspectionService;
    @Autowired
    NonDrugListService nonDrugListService;
    @Autowired
    InspectionSetService inspectionSetService;

    @RequestMapping("inspectionManagement")
    public String toInspectionManagment(){
        return "inspection/inspectionManagement";
    }

    /**
     *查找检查项目
     * @param type 类型
     * @param attribute_name 属性名
     * @param attribute 属性值
     * @return 符合条件的非药品
     */
    @RequestMapping("findByAttribute")
    public @ResponseBody List findByAttribute(String type,String attribute_name, String attribute){
        List inspectionList = nonDrugListService.findByType(type,attribute_name,attribute);
        return inspectionList;
    }

    /**
     * 查找未登记检查项目
     * @param attribute_name 属性名
     * @param attribute 属性值
     * @param doctorId 医生Id
     * @return 检验
     */
    @RequestMapping("findInspectionByAttribute")
    public @ResponseBody
    List findInspectionByAttribute(String attribute_name,String attribute,String doctorId){
        List<Inspection> inspectionList=inspectionService.selectByNameOrMedNo(attribute_name,attribute,Integer.parseInt(doctorId));
        return inspectionList;
    }


    /**
     * 开立项目
     * @param doctorId 医生id
     * @param medicalRecordNo 病历号
     * @param inspectionDTO 项目列表
     */
    @RequestMapping("submitInspections")
    public @ResponseBody void submitInspections(int doctorId, String medicalRecordNo, InspectionDTO inspectionDTO){
        List<Inspection> inspections = inspectionDTO.getInspections();
        for (Inspection inspection : inspections) {
            inspection.setDoctorId(doctorId);
            inspection.setMedicalRecordNo(medicalRecordNo);
            inspectionService.addInspection(inspection);
        }
    }

    /**
     * 作废开立项目
     * @param inspection 已开立项目
     * @return 作废成功或已登记无法作废
     */
    @RequestMapping("invalidInspection")
    public @ResponseBody ResultDTO invalidInspection(Inspection inspection){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(inspectionService.deleteInspection(inspection));
        return resultDTO;
    }

    /**
     * 获取已开立的项目
     * @param medicalRecordNo 病历号
     * @return 已开立的项目
     */
    @RequestMapping("getOpenedInspections")
    public @ResponseBody ResultDTO getOpenedInspections(String medicalRecordNo){
        ResultDTO resultDTO = new ResultDTO();
        List<Inspection> inspections = inspectionService.findByMedicalNo(medicalRecordNo);
        if (!inspections.isEmpty()){
            resultDTO.setData(inspections);
        }
        return resultDTO;
    }

    /**
     * 获取检查检验结果
     * @param id 检查检验id
     * @return 返回结果
     */
    @RequestMapping("getInspectionResult")
    public @ResponseBody ResultDTO getInspectionResult(int id){
        String result = inspectionService.findResult(id);
        ResultDTO resultDTO = new ResultDTO();
        if (result == null){
            resultDTO.setStatus("NG");
            resultDTO.setMsg("目前未出结果");
        }else {
            resultDTO.setStatus("OK");
            resultDTO.setMsg(result);
        }
        return resultDTO;
    }

    /**
     * 存为组套
     * @param inspectionSet 组套
     * @param itemName 组套中的项目
     */
    @RequestMapping("saveInspectionSet")
    public @ResponseBody void saveInspectionSet(InspectionSet inspectionSet,String[] itemName){
        List<String> itemNameList = new ArrayList();
        for (int i = 0; i < itemName.length; i++) {
            itemNameList.add(itemName[i]);
        }
        inspectionSetService.saveAsSet(inspectionSet,itemNameList);
    }

    /**
     * 获取所有组套
     * @param doctorId 医生id
     * @return 所有组套
     */
    @RequestMapping("getAllSets")
    public @ResponseBody List<InspectionSet> getAllSets(int doctorId){
        return inspectionSetService.findAllSet(doctorId);
    }

    /**
     * 获取检查组套
     * @param doctorId 医生id
     * @return 检查组套
     */
    @RequestMapping("getSetsOne")
    public @ResponseBody List<InspectionSet> getSetsOne(int doctorId){
        return inspectionSetService.findAllInsSet(doctorId);
    }

    /**
     * 获取检验组套
     * @param doctorId 医生id
     * @return 检验组套
     */
    @RequestMapping("getSetsTwo")
    public @ResponseBody List<InspectionSet> getSetsTwo(int doctorId){
        return inspectionSetService.findAllCheckSet(doctorId);
    }

    /**
     * 获取处置组套
     * @param doctorId 医生id
     * @return 处置组套
     */
    @RequestMapping("getSetsThree")
    public @ResponseBody List<InspectionSet> getSetsThree(int doctorId){
        return inspectionSetService.findAllHandleSet(doctorId);
    }

    /**
     * 查找组套项目
     * @param setId 组套id
     * @return 项目列表
     */
    @RequestMapping("findDetailBySetId")
    public @ResponseBody List<InspectionSetDetail> findDetailBySetId(int setId){
        return inspectionSetService.findDetailBySet(setId);
    }

    /**
     * 删除组套
     * @param setId 组套id
     * @param doctorId 医生id
     * @return 成功或没有权限
     */
    @RequestMapping("deleteSet")
    public @ResponseBody ResultDTO deleteSet(int setId,int doctorId){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(inspectionSetService.deleteSet(setId,doctorId));
        return resultDTO;
    }

    /**
     * 更新组套信息
     * @param doctorID 医生id
     * @param inspectionSet 检验组套
     * @return 成功或没有权限
     */
    @RequestMapping("updateSet")
    public @ResponseBody ResultDTO updateSet(int doctorID,InspectionSet inspectionSet){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(inspectionSetService.updateSet(inspectionSet,doctorID));
        return resultDTO;
    }

    /**
     * 设为常用
     * @param inspection 检查检验项目
     */
    @RequestMapping("setCommon")
    public @ResponseBody void setCommon(Inspection inspection){
        inspectionService.common(inspection);
    }

    /**
     * 获取常用项目列表
     * @param doctorId 医生id
     * @return 常用项目列表
     */
    @RequestMapping("getCommonInspectionList")
    public @ResponseBody List<Inspection> getCommonInspectionList(int doctorId){
        return inspectionService.findCommon(doctorId);
    }

    /**
     * 删除常用项目
     * @param commonInspectionId 常用项目id
     */
    @RequestMapping("deleteCommonInspection")
    public @ResponseBody void deleteCommonInspection(int commonInspectionId){
        inspectionService.deleteCommon(commonInspectionId);
    }

    /**
     * 登记
     * @param medicalNo
     * @param inspectionId
     * @param doctorId
     * @return
     */
    @RequestMapping("register")
    public @ResponseBody
    String register(String medicalNo,String inspectionId,String doctorId){
        String str="can't find";
        List<Inspection> inspectionList=inspectionService.findByMedicalNo(medicalNo);
        for(Inspection inspection:inspectionList){
            if(inspection.getId()==Integer.parseInt(inspectionId)){
                inspectionService.register(inspection,Integer.parseInt(doctorId));
                str="register success";
            }
        }
        return str;
    }

    /**
     * 查找需要录入结果的inspection
     * @param medicalNo
     * @return
     */
    @RequestMapping("findDoneRegister")
    public @ResponseBody
    List findDoneRegister(String medicalNo){
        List<Inspection> inspectionList=inspectionService.findByMedicalNo(medicalNo);
        List<Inspection> result = null;
        for(Inspection inspection:inspectionList){
            if(inspection.getInspectionResultAnalysis()==null){
                result.add(inspection);
            }
        }
        return result;
    }

    /**
     * 录入检查检验结果
     * @param inspectionId 检验Id
     * @param result 结果
     */
    @RequestMapping("saveResult")
    public @ResponseBody
    void saveResult(String inspectionId,String result){
        inspectionService.inputResult(Integer.parseInt(inspectionId),result);
    }
    /**
     *
     * @return
     */
    @RequestMapping("commonItems")
    public String toCommonItems(){
        return "inspection/commonItems";
    }
}
