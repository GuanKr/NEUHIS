package neu.his.controller;

import neu.his.bean.SettlementType;
import neu.his.dto.SettlementTypeDTO;
import neu.his.service.SettlementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("SettlementType")
public class SettlementTypeController {
    @Autowired
    SettlementTypeService settlementTypeService;
    @RequestMapping("settlementTypeManagement")
    public String toSettlementTypeManagement(){
        return "settlementType/settlementTypeManagement";
    }
    @RequestMapping("list")
    public @ResponseBody
    List settlementTypeList(){
        List<SettlementType> settlementtypelist = settlementTypeService.findAll();
        return settlementtypelist;
    }
    @RequestMapping("deleteSettlementTypesByID")
    public @ResponseBody
    void deleteSettlementTypesByID(int[] ids ){
        for(int id:ids){
            settlementTypeService.deleteByID(id);
        }
    }
    @RequestMapping("updateSettlementTypes")
    public @ResponseBody
    void updateSettlementTypes(SettlementTypeDTO settlementtypes){
        List<SettlementType> settlementTypes1=settlementtypes.getSettlementTypes();
        for(SettlementType settlementType:settlementTypes1){
            settlementTypeService.updateSettlementType(settlementType);
        }
    }
}
