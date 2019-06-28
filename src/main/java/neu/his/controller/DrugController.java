package neu.his.controller;

import neu.his.bean.Drug;
import neu.his.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    List searchBy(String code,String name,String dosage,String mnemonic){
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


}
