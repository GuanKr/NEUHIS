package neu.his.dao;

import java.util.List;
import neu.his.bean.NonDrugList;
import neu.his.bean.NonDrugListExample;
import neu.his.bean.Query;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface NonDrugListMapper {
    /**
     * 查询非药品目录信息
     * @param Query 封装的查询信息
     */
    List<NonDrugList> query(Query Query);

    /**
     * 更新非药品目录信息
     * @param nonDrugList 非药品目录信息
     */
    void updateNonDrugList(NonDrugList nonDrugList);

    /**
     * 插入非药品目录信息
     * @param nonDrugList 非药品目录信息
     */
    void insertNonDrugList(NonDrugList nonDrugList);
    /**
     * 查询根据类别查询非药品目录
     * @return 非药品目录信息列表
     */
    List<NonDrugList> selectWithName();

    int countByExample(NonDrugListExample example);

    int deleteByExample(NonDrugListExample example);

    @Delete({
        "delete from non_drug_list",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into non_drug_list (id, item_code, ",
        "item_name, format, ",
        "price, expense_class_id, ",
        "executivedepartment_id, mnemonic_code, ",
        "item_type, creation_time)",
        "values (#{id,jdbcType=INTEGER}, #{itemCode,jdbcType=CHAR}, ",
        "#{itemName,jdbcType=VARCHAR}, #{format,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=DECIMAL}, #{expenseClassId,jdbcType=INTEGER}, ",
        "#{executivedepartmentId,jdbcType=INTEGER}, #{mnemonicCode,jdbcType=VARCHAR}, ",
        "#{itemType,jdbcType=CHAR}, #{creationTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(NonDrugList record);

    int insertSelective(NonDrugList record);

    List<NonDrugList> selectByExample(NonDrugListExample example);

    @Select({
        "select",
        "id, item_code, item_name, format, price, expense_class_id, executivedepartment_id, ",
        "mnemonic_code, item_type, creation_time",
        "from non_drug_list",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    NonDrugList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NonDrugList record, @Param("example") NonDrugListExample example);

    int updateByExample(@Param("record") NonDrugList record, @Param("example") NonDrugListExample example);

    int updateByPrimaryKeySelective(NonDrugList record);

    @Update({
        "update non_drug_list",
        "set item_code = #{itemCode,jdbcType=CHAR},",
          "item_name = #{itemName,jdbcType=VARCHAR},",
          "format = #{format,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "expense_class_id = #{expenseClassId,jdbcType=INTEGER},",
          "executivedepartment_id = #{executivedepartmentId,jdbcType=INTEGER},",
          "mnemonic_code = #{mnemonicCode,jdbcType=VARCHAR},",
          "item_type = #{itemType,jdbcType=CHAR},",
          "creation_time = #{creationTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(NonDrugList record);
}