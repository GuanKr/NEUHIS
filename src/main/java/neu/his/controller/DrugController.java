package neu.his.controller;

import neu.his.bean.Drug;
import neu.his.bean.DrugPrescription;
import neu.his.bean.RegistrationInfo;
import neu.his.service.DrugPrescriptionService;
import neu.his.service.DrugService;
import neu.his.service.RegistrationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("pharmacy")
public class DrugController {
    @Autowired
    DrugService drugService;
    @Autowired
    DrugPrescriptionService drugPrescriptionService;
    @Autowired
    RegistrationInfoService registrationInfoService;

    /**
     *
     * @return 药品维护页面
     */
    @RequestMapping("drugManagement")
    public String toDrugManagement(){
        return "pharmacy/drugManagement";
    }
    @RequestMapping("deliverDrug")
    public String toDeliverDrug(){
        return "pharmacy/deliverDrug";
    }

    /**
     * 寻找全部药品
     * @return 全部的药品列表
     */
    @RequestMapping("findAll")
    public @ResponseBody
    List findAll(){
        return drugService.findAll();
    }
    /**
     * 寻找药品
     * @param code 药品编码
     * @param name 药品名称
     * @param dosage 药品剂型
     * @param mnemonic 助记码
     * @return 药品列表
     */

    @RequestMapping("searchBy")
    public @ResponseBody
    List searchBy( String code,  String name, String dosage, String mnemonic){
        Drug drug =new Drug(null,code,name,"","","",dosage,"",null,mnemonic);
        return drugService.query(drug);
    }

    /**
     *
     * @return 全部药品
     */
    @RequestMapping("list")
    public @ResponseBody
    List list(){
        return drugService.findAll();
    }

    /**
     * 删除药品
     * @param deleteId 删除药品id
     */
    @RequestMapping("deleteDrugListsByID")
    public @ResponseBody
    void deleteDrugListsByID(String deleteId){
        drugService.deleteDrug(Integer.parseInt(deleteId));
    }

    /**
     *
     * @param code 编码
     * @param name 名称
     * @param format 规格
     * @param unit 单位
     * @param manufacturer 生产厂家
     * @param dosage 剂型
     * @param type 类型
     * @param price 价格
     * @param mnemonic 助记码
     */
    @RequestMapping("insertDrug")
    public @ResponseBody
    void insertDrug(String code,String name,String format,String unit,String manufacturer,String dosage,String type,String price,String mnemonic){
        String typeString;
        switch (Integer.parseInt(type)){
            case 1:
                typeString="西药";
                break;
            case 2:
                typeString="中草药";
                break;
            case 3:
                typeString="中成药";
                break;
                default:
                    typeString="?";
        }
        BigDecimal bdPrice = new BigDecimal(price);
        bdPrice.setScale(2);
        Drug drug =  new Drug(null,code,name,format,unit,manufacturer,dosage,typeString,bdPrice ,mnemonic);
        drugService.addDrug(drug);
    }

    /**
     *
     * @param medicalNo 病历号
     * @param state 状态
     * @return 返回DrugPrescription列表
     */
    @RequestMapping("findAllDrugPrescriptionByMedical")
    public @ResponseBody
    List findAllDrugPrescriptionByMedical(String medicalNo,String state){
        return drugPrescriptionService.findByMedNo(medicalNo,state);
    }
    /**
     * 返回患者姓名
     * @param medicalNo 病历号
     * @return 姓名
     */
    @RequestMapping("findNameByMedical")
    public @ResponseBody
    String findNameByMedical(String medicalNo){
        String str=medicalNo;
//        List<RegistrationInfo> all = registrationInfoService.findAll();
//        for(RegistrationInfo registrationInfo:all){
//            if(Integer.parseInt(registrationInfo.getMedicalRecordNo())==Integer.parseInt(medicalNo)){
//                str=registrationInfo.getPatientName();
//            }
//        }
        return str;
    }

    /**
     * 展示选中的prescription
     * @param medicalNo 病历号
     * @param prescriptionId id
     * @return 发药单
     */
    @RequestMapping("showDetails")
    public @ResponseBody
    DrugPrescription showDetails(String medicalNo,String prescriptionId){
        DrugPrescription dp =new DrugPrescription();
        List<DrugPrescription> drugPrescriptions= drugPrescriptionService.findPrescription(medicalNo);
        for(DrugPrescription drugPrescription:drugPrescriptions){
            if(drugPrescription.getId()==Integer.parseInt(prescriptionId)){
                dp=drugPrescription;
            }
        }
        return dp;
    }

}