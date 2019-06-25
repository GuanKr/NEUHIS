package neu.his.service;

import neu.his.bean.Invoice;
import neu.his.bean.Item;

import java.util.Date;
import java.util.List;

/**处理发票信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface InvoiceService {
    /**
     * 查找未缴费项目
     * @param medicalNo 病历号
     * @return 未缴费项目列表
     */
    List<Item> findUnpaidItem(String medicalNo);

    /**
     * 应收金额
     * @param list 项目列表
     * @return 应收金额
     */
    Double calCost(List<Item> list);

    /**
     * 收费
     * @param list 项目列表
     * @param settlementType 结算类别
     * @param tollCollectorId 收费员id
     * @param patientName 患者姓名
     * @param medicalNo 病历号
     */
    void charge(List<Item> list,String settlementType,Integer tollCollectorId,String patientName,String medicalNo);


    /**
     * 退号
     * @param medicalNo 病历号
     * @return "成功"/"已看诊，无法退号"/"未缴费"
     */
    String returnReg(String medicalNo);

    /**
     * 找到已缴费列表
     * @param medicalNo 病历号
     * @return 缴费列表
     */
    List<Invoice> findByMedNo(String medicalNo);

    /**
     * 退费
     * @param invoice 缴费记录
     * @return 返回提示
     */
    String returnCost(Invoice invoice);

    /**
     * 查询患者费用明细
     * @param medicalNo 病历号
     * @param startTime 开始时间
     * @param endTime 截止时间
     * @return 费用明细
     */
    List<Invoice> query(String medicalNo, Date startTime, Date endTime);


}
