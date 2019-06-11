package neu.his.dao;

import java.util.List;
import neu.his.bean.ExpenseClass;
import neu.his.bean.ExpenseClassExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ExpenseClassMapper {
    int countByExample(ExpenseClassExample example);

    int deleteByExample(ExpenseClassExample example);

    @Delete({
        "delete from expense_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into expense_class (id, expense_code, ",
        "expense_name)",
        "values (#{id,jdbcType=INTEGER}, #{expenseCode,jdbcType=VARCHAR}, ",
        "#{expenseName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(ExpenseClass record);

    int insertSelective(ExpenseClass record);

    List<ExpenseClass> selectByExample(ExpenseClassExample example);

    @Select({
        "select",
        "id, expense_code, expense_name",
        "from expense_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    ExpenseClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExpenseClass record, @Param("example") ExpenseClassExample example);

    int updateByExample(@Param("record") ExpenseClass record, @Param("example") ExpenseClassExample example);

    int updateByPrimaryKeySelective(ExpenseClass record);

    @Update({
        "update expense_class",
        "set expense_code = #{expenseCode,jdbcType=VARCHAR},",
          "expense_name = #{expenseName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ExpenseClass record);
}