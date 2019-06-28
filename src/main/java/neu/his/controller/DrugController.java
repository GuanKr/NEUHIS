package neu.his.controller;

import neu.his.bean.Drug;
import neu.his.service.DrugService;
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

    /**
     * 药品维护页面
     * @return
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
     *
     * @return
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
        List<Drug> drugList = drugService.query(drug);
        return drugList;
    }

    /**
     *
     * @return
     */
    @RequestMapping("list")
    public @ResponseBody
    List list(){
        return drugService.findAll();
    }

    /**
     * 删除药品
     * @param deleteId
     */
    @RequestMapping("deleteDrugListsByID")
    public @ResponseBody
    void deleteDrugListsByID(String deleteId){
        drugService.deleteDrug(Integer.parseInt(deleteId));
    }

    /**
     *
     * @param code
     * @param name
     * @param format
     * @param unit
     * @param manufacturer
     * @param dosage
     * @param type
     * @param price
     * @param mnemonic
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
}
