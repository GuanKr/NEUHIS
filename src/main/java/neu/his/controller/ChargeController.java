package neu.his.controller;

import neu.his.bean.Item;
import neu.his.dto.ChargeDTO;
import neu.his.dto.ResultDTO;
import neu.his.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("charge")
public class ChargeController {
    @Autowired
    InvoiceService invoiceService;
    @RequestMapping("chargeManagement")
    public String toChargeManagement(){
        return "charge/chargeManagement";
    }

    /**
     * 查找未缴费项目
     * @param medicalNo 病历号
     * @return 未缴费项目列表和项目的总额
     */
    @RequestMapping("findUnpaidItem")
    public @ResponseBody Map findUnpaidItem(String medicalNo){
        List<Item> itemList = invoiceService. findUnpaidItem(medicalNo);
        Map<String,Object> map = new HashMap<>();
        map.put("items",itemList);
        map.put("cost",invoiceService.calCost(itemList));
        return map;
    }

    /**
     * 缴费
     * @param chargeDTO 包含缴费项目列表、缴费类型、收费员id、病历号、病人姓名
     */
    @RequestMapping("charge")
    public @ResponseBody void charge(@RequestBody ChargeDTO chargeDTO){
        Item[] items = chargeDTO.getItems();
        List<Item> itemList = new ArrayList<>(Arrays.asList(items));
        invoiceService.charge(itemList,chargeDTO.getSettlementType(),chargeDTO.getTollCollectorId(),chargeDTO.getPatientName(),chargeDTO.getMedicalNo());
    }

    /**
     * 退号
     * @param medicalRecordNo 病历号
     * @return 是否成功
     */
    @RequestMapping("withdraw")
    public @ResponseBody ResultDTO withdraw(String medicalRecordNo){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(invoiceService.returnReg(medicalRecordNo));
        return resultDTO;
    }
}
