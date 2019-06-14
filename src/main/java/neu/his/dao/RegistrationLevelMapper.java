package neu.his.dao;

import java.util.List;
import neu.his.bean.RegistrationLevel;
import neu.his.bean.RegistrationLevelExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
/**
 * 处理挂号级别
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface RegistrationLevelMapper {
    int countByExample(RegistrationLevelExample example);

    int deleteByExample(RegistrationLevelExample example);

    @Delete({
        "delete from registration_level",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into registration_level (id, code, ",
        "level_name, is_default, ",
        "registration_price)",
        "values (#{id,jdbcType=INTEGER}, #{code,jdbcType=VARCHAR}, ",
        "#{levelName,jdbcType=VARCHAR}, #{isDefault,jdbcType=CHAR}, ",
        "#{registrationPrice,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(RegistrationLevel record);

    int insertSelective(RegistrationLevel record);

    List<RegistrationLevel> selectByExample(RegistrationLevelExample example);

    @Select({
        "select",
        "id, code, level_name, is_default, registration_price",
        "from registration_level",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    RegistrationLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RegistrationLevel record, @Param("example") RegistrationLevelExample example);

    int updateByExample(@Param("record") RegistrationLevel record, @Param("example") RegistrationLevelExample example);

    int updateByPrimaryKeySelective(RegistrationLevel record);

    @Update({
        "update registration_level",
        "set code = #{code,jdbcType=VARCHAR},",
          "level_name = #{levelName,jdbcType=VARCHAR},",
          "is_default = #{isDefault,jdbcType=CHAR},",
          "registration_price = #{registrationPrice,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RegistrationLevel record);
}