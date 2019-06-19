package neu.his.dao;

import java.util.List;
import neu.his.bean.Drug;
import neu.his.bean.DrugExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface DrugMapper {
    int countByExample(DrugExample example);

    int deleteByExample(DrugExample example);

    @Delete({
        "delete from drug",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into drug (id, drug_code, ",
        "drug_name, drug_format, ",
        "drug_unit, manufacturer, ",
        "drug_dosage, drug_type, ",
        "drug_price, mnemonic_code)",
        "values (#{id,jdbcType=INTEGER}, #{drugCode,jdbcType=VARCHAR}, ",
        "#{drugName,jdbcType=VARCHAR}, #{drugFormat,jdbcType=VARCHAR}, ",
        "#{drugUnit,jdbcType=VARCHAR}, #{manufacturer,jdbcType=VARCHAR}, ",
        "#{drugDosage,jdbcType=VARCHAR}, #{drugType,jdbcType=VARCHAR}, ",
        "#{drugPrice,jdbcType=DECIMAL}, #{mnemonicCode,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Drug record);

    int insertSelective(Drug record);

    List<Drug> selectByExample(DrugExample example);

    @Select({
        "select",
        "id, drug_code, drug_name, drug_format, drug_unit, manufacturer, drug_dosage, ",
        "drug_type, drug_price, mnemonic_code",
        "from drug",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Drug selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByExample(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByPrimaryKeySelective(Drug record);

    @Update({
        "update drug",
        "set drug_code = #{drugCode,jdbcType=VARCHAR},",
          "drug_name = #{drugName,jdbcType=VARCHAR},",
          "drug_format = #{drugFormat,jdbcType=VARCHAR},",
          "drug_unit = #{drugUnit,jdbcType=VARCHAR},",
          "manufacturer = #{manufacturer,jdbcType=VARCHAR},",
          "drug_dosage = #{drugDosage,jdbcType=VARCHAR},",
          "drug_type = #{drugType,jdbcType=VARCHAR},",
          "drug_price = #{drugPrice,jdbcType=DECIMAL},",
          "mnemonic_code = #{mnemonicCode,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Drug record);
}