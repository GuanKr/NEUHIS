package neu.his.dao;

import java.util.List;
import neu.his.bean.Invoice;
import neu.his.bean.InvoiceExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface InvoiceMapper {
    int countByExample(InvoiceExample example);

    int deleteByExample(InvoiceExample example);

    @Delete({
        "delete from invoice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into invoice (id, invoice_no, ",
        "cost_type, cost_type_id, ",
        "settlement_type_id, receivable, ",
        "\"net receipt\", chnge, ",
        "invoice_time, toll_collector_id)",
        "values (#{id,jdbcType=INTEGER}, #{invoiceNo,jdbcType=CHAR}, ",
        "#{costType,jdbcType=CHAR}, #{costTypeId,jdbcType=INTEGER}, ",
        "#{settlementTypeId,jdbcType=INTEGER}, #{receivable,jdbcType=DECIMAL}, ",
        "#{netReceipt,jdbcType=DECIMAL}, #{chnge,jdbcType=DECIMAL}, ",
        "#{invoiceTime,jdbcType=TIMESTAMP}, #{tollCollectorId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Invoice record);

    int insertSelective(Invoice record);

    List<Invoice> selectByExample(InvoiceExample example);

    @Select({
        "select",
        "id, invoice_no, cost_type, cost_type_id, settlement_type_id, receivable, \"net receipt\", ",
        "chnge, invoice_time, toll_collector_id",
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
          "receivable = #{receivable,jdbcType=DECIMAL},",
          "\"net receipt\" = #{netReceipt,jdbcType=DECIMAL},",
          "chnge = #{chnge,jdbcType=DECIMAL},",
          "invoice_time = #{invoiceTime,jdbcType=TIMESTAMP},",
          "toll_collector_id = #{tollCollectorId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Invoice record);
}