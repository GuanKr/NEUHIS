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
/**
 * 处理用户信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface UserMapper {
    /**
     * 更新用户信息
     * @param user 用户信息
     */
    void updateUser(User user);


    /**
     * 插入用户信息
     * @param user 用户信息
     */
    void insertUser(User user);

    /**
     * 通过角色名称查询
     * @param attribute 属性内容
     * @return 用户列表
     */
    List<User> queryByRole(String attribute);

    /**
     * 通过职称查询
     * @param attribute 属性内容
     * @return 用户列表
     */
    List<User> queryByTitle(String attribute);

    /**
     * 通过科室查询
     * @param attribute 属性内容
     * @return 用户列表
     */
    List<User> queryByDepartment(String attribute);

    /**
     * 通过姓名查询
     * @param attribute 属性内容
     * @return 用户列表
     */
    List<User> queryByName(String attribute);

    /**
     * 通过登陆名查询
     * @param attribute 属性内容
     * @return 用户列表
     */
    List<User> queryByLoginName(String attribute);

    /**
     * 通过挂号等级查询
     * @param attribute 属性内容
     * @return 用户列表
     */
    List<User> queryByReLevel(String attribute);

    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<User> selectWithName();

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