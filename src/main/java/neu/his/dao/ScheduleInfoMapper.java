package neu.his.dao;

import java.util.List;

import neu.his.bean.Query;
import neu.his.bean.ScheduleInfo;
import neu.his.bean.ScheduleInfoExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

/**
 * 处理排班信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface ScheduleInfoMapper {

    /**
     * 查询排班信息
     * @return 排班信息列表
     */
    List<neu.his.bean.ScheduleInfo> selectWithName();

    void insertScheduleInfo(neu.his.bean.ScheduleInfo scheduleInfo);

    int countByExample(neu.his.bean.ScheduleInfoExample example);

    int deleteByExample(neu.his.bean.ScheduleInfoExample example);

    List<ScheduleInfo> query(Query query);


    @Delete({
        "delete from schedule_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into schedule_info (id, user_id, ",
        "schedule_date, bisessional_operation, ",
        "surplus_quota, status, ",
        "schedule_quota)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{scheduleDate,jdbcType=DATE}, #{bisessionalOperation,jdbcType=CHAR}, ",
        "#{surplusQuota,jdbcType=INTEGER}, #{status,jdbcType=CHAR}, ",
        "#{scheduleQuota,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(ScheduleInfo record);

    int insertSelective(ScheduleInfo record);

    List<ScheduleInfo> selectByExample(ScheduleInfoExample example);

    @Select({
        "select",
        "id, user_id, schedule_date, bisessional_operation, surplus_quota, status, schedule_quota",
        "from schedule_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    ScheduleInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScheduleInfo record, @Param("example") ScheduleInfoExample example);

    int updateByExample(@Param("record") ScheduleInfo record, @Param("example") ScheduleInfoExample example);

    int updateByPrimaryKeySelective(ScheduleInfo record);

    @Update({
        "update schedule_info",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "schedule_date = #{scheduleDate,jdbcType=DATE},",
          "bisessional_operation = #{bisessionalOperation,jdbcType=CHAR},",
          "surplus_quota = #{surplusQuota,jdbcType=INTEGER},",
          "status = #{status,jdbcType=CHAR},",
          "schedule_quota = #{scheduleQuota,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ScheduleInfo record);
}