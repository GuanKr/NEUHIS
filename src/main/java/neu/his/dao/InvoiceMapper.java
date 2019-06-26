package neu.his.dao;

import java.util.List;
import neu.his.bean.Invoice;
import neu.his.bean.InvoiceExample;
import neu.his.bean.SeeQuantity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface InvoiceMapper {

    /**
     * 根据执行科室返回看诊人次
     * @param seeQuantity 查找信息
     * @return 看诊人次
     */
    Integer seeQuantity(SeeQuantity seeQuantity);

    /**
     * 根据开立科室返回看诊人次
     * @param seeQuantity 查找信息
     * @return 看诊人次
     */
    Integer seeQuantity2(SeeQuantity seeQuantity);

    /**
     * 根据门诊医生返回看诊人次
     * @param seeQuantity 查找信息
     * @return 看诊人次
     */
    Integer seeQuantity3(SeeQuantity seeQuantity);
    /**
     * 找到以执行科室，类别分组的信息
     * @return
     */
    List<Invoice> groupByEx();
    /**
     * 返回最晚生成的发票号
     * @return 最晚生成的发票号
     */
    String serNumber();

    int countByExample(InvoiceExample example);

    int deleteByExample(InvoiceExample example);

    @Delete({
        "delete from invoice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into invoice (invoice_no, ",
        "cost_type, cost_type_id, ",
        "settlement_type_id, cost, ",
        "invoice_time, toll_collector_id, ",
        "patient_name, status, ",
        "item_name, medical_record_no, ",
        "doctor_name, executive_department_name, ",
        "draw_bill_department_name)",
        "values (#{invoiceNo,jdbcType=CHAR}, ",
        "#{costType,jdbcType=CHAR}, #{costTypeId,jdbcType=INTEGER}, ",
        "#{settlementTypeId,jdbcType=INTEGER}, #{cost,jdbcType=DECIMAL}, ",
        "#{invoiceTime,jdbcType=TIMESTAMP}, #{tollCollectorId,jdbcType=INTEGER}, ",
        "#{patientName,jdbcType=VARCHAR}, #{status,jdbcType=CHAR}, ",
        "#{itemName,jdbcType=VARCHAR}, #{medicalRecordNo,jdbcType=CHAR}, ",
        "#{doctorName,jdbcType=VARCHAR}, #{executiveDepartmentName,jdbcType=VARCHAR}, ",
        "#{drawBillDepartmentName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Invoice record);

    int insertSelective(Invoice record);

    List<Invoice> selectByExample(InvoiceExample example);

    @Select({
        "select",
        "id, invoice_no, cost_type, cost_type_id, settlement_type_id, cost, invoice_time, ",
        "toll_collector_id, patient_name, status, item_name, medical_record_no, doctor_name, ",
        "executive_department_name, draw_bill_department_name",
        "from invoice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Invoice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Invoice record, @Param("example") InvoiceExample example);

    int updateByExample(@Param("record") Invoice record, @Param("example") InvoiceExample example);

    int updateByPrimaryKeySelective(Invoice record);

    @Update({
        "update invoice",
        "set invoice_no = #{invoiceNo,jdbcType=CHAR},",
          "cost_type = #{costType,jdbcType=CHAR},",
          "cost_type_id = #{costTypeId,jdbcType=INTEGER},",
          "settlement_type_id = #{settlementTypeId,jdbcType=INTEGER},",
          "cost = #{cost,jdbcType=DECIMAL},",
          "invoice_time = #{invoiceTime,jdbcType=TIMESTAMP},",
          "toll_collector_id = #{tollCollectorId,jdbcType=INTEGER},",
          "patient_name = #{patientName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=CHAR},",
          "item_name = #{itemName,jdbcType=VARCHAR},",
          "medical_record_no = #{medicalRecordNo,jdbcType=CHAR},",
          "doctor_name = #{doctorName,jdbcType=VARCHAR},",
          "executive_department_name = #{executiveDepartmentName,jdbcType=VARCHAR},",
          "draw_bill_department_name = #{drawBillDepartmentName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Invoice record);
}