package neu.his.dao;

import java.util.List;
import neu.his.bean.User;
import neu.his.bean.UserExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (id, role_id, ",
        "department_id, name, ",
        "login_name, password, ",
        "title_id, registration_level_id)",
        "values (#{id,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
        "#{departmentId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{loginName,jdbcType=VARCHAR}, #{password,jdbcType=CHAR}, ",
        "#{titleId,jdbcType=INTEGER}, #{registrationLevelId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, role_id, department_id, name, login_name, password, title_id, registration_level_id",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "login_name = #{loginName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=CHAR},",
          "title_id = #{titleId,jdbcType=INTEGER},",
          "registration_level_id = #{registrationLevelId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}