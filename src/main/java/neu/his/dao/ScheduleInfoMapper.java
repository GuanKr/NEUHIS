package neu.his.dao;

import java.util.List;
import neu.his.bean.ScheduleInfo;
import neu.his.bean.ScheduleInfoExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ScheduleInfoMapper {
    int countByExample(ScheduleInfoExample example);

    int deleteByExample(ScheduleInfoExample example);

    @Delete({
        "delete from schedule_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into schedule_info (id, user_id, ",
        "schedul_date, bisessional_operation, ",
        "surplus_quota)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{schedulDate,jdbcType=DATE}, #{bisessionalOperation,jdbcType=CHAR}, ",
        "#{surplusQuota,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(ScheduleInfo record);

    int insertSelective(ScheduleInfo record);

    List<ScheduleInfo> selectByExample(ScheduleInfoExample example);

    @Select({
        "select",
        "id, user_id, schedul_date, bisessional_operation, surplus_quota",
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
          "schedul_date = #{schedulDate,jdbcType=DATE},",
          "bisessional_operation = #{bisessionalOperation,jdbcType=CHAR},",
          "surplus_quota = #{surplusQuota,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ScheduleInfo record);
}