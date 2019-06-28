package neu.his.controller;

import neu.his.bean.Invoice;
import neu.his.bean.Item;
import neu.his.dto.ChargeDTO;
import neu.his.dto.ResultDTO;
import neu.his.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    /**
     * 查找已缴费列表
     * @param medicalNo 病历号
     * @return 已缴费列表
     */
    @RequestMapping("findByMedNo")
    public @ResponseBody ResultDTO findByMedNo(String medicalNo){
        List<Invoice> invoiceList =  invoiceService.findByMedNo(medicalNo);
        ResultDTO<List<Invoice>> resultDTO = new ResultDTO<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (invoiceList.isEmpty()){
            resultDTO.setStatus("NG");
        } else {
            resultDTO.setStatus("OK");
            for (Invoice invoice : invoiceList) {
                //病人姓名存放时间字符串
                if (invoice.getInvoiceTime() != null)
                    invoice.setPatientName(dateFormat.format(invoice.getInvoiceTime()));
                switch (invoice.getSettlementTypeId()){
                    case 1 :
                        invoice.setSettlementTypeName("自费");
                        break;
                    case 2 :
                        invoice.setSettlementTypeName("医保");
                        break;
                    case 3 :
                        invoice.setSettlementTypeName("新农合");
                        break;
                    default :
                        invoice.setSettlementTypeName("其他");
                        break;
                }
            }
            resultDTO.setData(invoiceList);
        }
        return resultDTO;
    }
}
