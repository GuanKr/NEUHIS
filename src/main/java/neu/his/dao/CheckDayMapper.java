package neu.his.dao;

import java.util.List;
import neu.his.bean.CheckDay;
import neu.his.bean.CheckDayExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
/**
 * 处理日结信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public interface CheckDayMapper {
    int countByExample(CheckDayExample example);

    int deleteByExample(CheckDayExample example);

    @Delete({
        "delete from check_day",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into check_day (id, toll_collector_id, ",
        "start_time, end_time, ",
        "cost, approve, check_day_time)",
        "values (#{id,jdbcType=INTEGER}, #{tollCollectorId,jdbcType=INTEGER}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{cost,jdbcType=DECIMAL}, #{approve,jdbcType=CHAR}, #{checkDayTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(CheckDay record);

    int insertSelective(CheckDay record);

    List<CheckDay> selectByExample(CheckDayExample example);

    @Select({
        "select",
        "id, toll_collector_id, start_time, end_time, cost, approve, check_day_time",
        "from check_day",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    CheckDay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckDay record, @Param("example") CheckDayExample example);

    int updateByExample(@Param("record") CheckDay record, @Param("example") CheckDayExample example);

    int updateByPrimaryKeySelective(CheckDay record);

    @Update({
        "update check_day",
        "set toll_collector_id = #{tollCollectorId,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "cost = #{cost,jdbcType=DECIMAL},",
          "approve = #{approve,jdbcType=CHAR},",
          "check_day_time = #{checkDayTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CheckDay record);
}