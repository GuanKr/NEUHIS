package neu.his.controller;
/**
 * 结算类型
 * @version 1.0
 * @since 1.8
 */

import neu.his.bean.SettlementType;
import neu.his.dto.SettlementTypeDTO;
import neu.his.service.SettlementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("settlementType")
public class SettlementTypeController {
    @Autowired
    SettlementTypeService settlementTypeService;
    /**
     *@Author: dell on 2019/6/14 14:30
     *@param: []
     *@return: java.lang.String
     *@Description: settlementTypeManagement
     */
    @RequestMapping("settlementTypeManagement")
    public String toSettlementTypeManagement(){
        return "settlementType/settlementTypeManagement";
    }
    /**
     *@Author: dell on 2019/6/14 14:30
     *@param: []
     *@return: java.util.List
     *@Description: settlementTypeList
     */
    @RequestMapping("list")
    public @ResponseBody
    List settlementTypeList(){
        List<SettlementType> settlementtypelist = settlementTypeService.findAll();
        return settlementtypelist;
    }
    /**
     *@Author: dell on 2019/6/14 14:29
     *@param: [idStirng]
     *@return: void
     *@Description: deleteSettlementTypesByID
     */
    @RequestMapping("deleteSettlementTypesByID")
    public @ResponseBody
    void deleteSettlementTypesByID(String idStirng ){
        String[] IDs =idStirng.split(",");
        for(String id:IDs){
            settlementTypeService.deleteByID(Integer.parseInt(id));
        }
    }
    /**
     *@Author: dell on 2019/6/14 14:31
     *@param: [settlementtypes]
     *@return: void
     *@Description: updateSettlementTypes
     */
    @RequestMapping("updateSettlementTypes")
    public @ResponseBody
    void updateSettlementTypes(SettlementTypeDTO settlementtypes){
        List<SettlementType> settlementTypes1=settlementtypes.getSettlementTypes();
        for(SettlementType settlementType:settlementTypes1){
            settlementTypeService.updateSettlementType(settlementType);
        }
    }
}
