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
/**
 * 处理排版规则
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface ScheduleRuleMapper {


    /**
     * 插入排班规则信息
     * @param scheduleRule 排班规则信息
     */
    void insertScheduleRule(ScheduleRule scheduleRule);

    /**
     * 查询根据类别查询排班规则
     * @return 排班规则信息列表
     */
    List<ScheduleRule> selectWithName();


    int countByExample(ScheduleRuleExample example);

    int deleteByExample(ScheduleRuleExample example);

    @Delete({
        "delete from schedule_rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into schedule_rule (id, user_id, ",
        "week, bisessional_operation, ",
        "schedul_quota, status)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{week,jdbcType=VARCHAR}, #{bisessionalOperation,jdbcType=CHAR}, ",
        "#{schedulQuota,jdbcType=INTEGER}, #{status,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(ScheduleRule record);

    int insertSelective(ScheduleRule record);

    List<ScheduleRule> selectByExample(ScheduleRuleExample example);

    @Select({
        "select",
        "id, user_id, week, bisessional_operation, schedul_quota, status",
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
          "week = #{week,jdbcType=VARCHAR},",
          "bisessional_operation = #{bisessionalOperation,jdbcType=CHAR},",
          "schedul_quota = #{schedulQuota,jdbcType=INTEGER},",
          "status = #{status,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ScheduleRule record);
}