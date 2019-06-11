package neu.his.dao;

import java.util.List;
import neu.his.bean.ScheduleRule;
import neu.his.bean.ScheduleRuleExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ScheduleRuleMapper {
    int countByExample(ScheduleRuleExample example);

    int deleteByExample(ScheduleRuleExample example);

    @Delete({
        "delete from schedule_rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into schedule_rule (id, user_id, ",
        "time, bisessional_operation, ",
        "schedul_quota)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{time,jdbcType=TIMESTAMP}, #{bisessionalOperation,jdbcType=CHAR}, ",
        "#{schedulQuota,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(ScheduleRule record);

    int insertSelective(ScheduleRule record);

    List<ScheduleRule> selectByExample(ScheduleRuleExample example);

    @Select({
        "select",
        "id, user_id, time, bisessional_operation, schedul_quota",
        "from schedule_rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    ScheduleRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScheduleRule record, @Param("example") ScheduleRuleExample example);

    int updateByExample(@Param("record") ScheduleRule record, @Param("example") ScheduleRuleExample example);

    int updateByPrimaryKeySelective(ScheduleRule record);

    @Update({
        "update schedule_rule",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "bisessional_operation = #{bisessionalOperation,jdbcType=CHAR},",
          "schedul_quota = #{schedulQuota,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ScheduleRule record);
}