package neu.his.dao;

import java.util.List;
import neu.his.bean.CheckDayDetail;
import neu.his.bean.CheckDayDetailExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
/**
 * 处理日结详细信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public interface CheckDayDetailMapper {

    int countByExample(CheckDayDetailExample example);

    int deleteByExample(CheckDayDetailExample example);

    @Delete({
        "delete from check_day_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into check_day_detail (id, check_day_id, ",
        "invoice_id)",
        "values (#{id,jdbcType=INTEGER}, #{checkDayId,jdbcType=INTEGER}, ",
        "#{invoiceId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(CheckDayDetail record);

    int insertSelective(CheckDayDetail record);

    List<CheckDayDetail> selectByExample(CheckDayDetailExample example);

    @Select({
        "select",
        "id, check_day_id, invoice_id",
        "from check_day_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    CheckDayDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckDayDetail record, @Param("example") CheckDayDetailExample example);

    int updateByExample(@Param("record") CheckDayDetail record, @Param("example") CheckDayDetailExample example);

    int updateByPrimaryKeySelective(CheckDayDetail record);

    @Update({
        "update check_day_detail",
        "set check_day_id = #{checkDayId,jdbcType=INTEGER},",
          "invoice_id = #{invoiceId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CheckDayDetail record);
}