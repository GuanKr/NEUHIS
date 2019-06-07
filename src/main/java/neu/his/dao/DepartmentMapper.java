package neu.his.dao;

import java.util.List;
import neu.his.bean.Department;
import neu.his.bean.DepartmentExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface DepartmentMapper {
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    @Delete({
        "delete from department",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into department (id, department_code, ",
        "department_name, department_category, ",
        "department_type)",
        "values (#{id,jdbcType=INTEGER}, #{departmentCode,jdbcType=VARCHAR}, ",
        "#{departmentName,jdbcType=VARCHAR}, #{departmentCategory,jdbcType=VARCHAR}, ",
        "#{departmentType,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    @Select({
        "select",
        "id, department_code, department_name, department_category, department_type",
        "from department",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Department selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    @Update({
        "update department",
        "set department_code = #{departmentCode,jdbcType=VARCHAR},",
          "department_name = #{departmentName,jdbcType=VARCHAR},",
          "department_category = #{departmentCategory,jdbcType=VARCHAR},",
          "department_type = #{departmentType,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Department record);
}