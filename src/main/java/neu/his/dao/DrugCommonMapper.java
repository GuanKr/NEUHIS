package neu.his.dao;

import java.util.List;
import neu.his.bean.DrugCommon;
import neu.his.bean.DrugCommonExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface DrugCommonMapper {
    int countByExample(DrugCommonExample example);

    int deleteByExample(DrugCommonExample example);

    @Delete({
        "delete from drug_common",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into drug_common (id, drug_name, ",
        "doctor_id, drug_format)",
        "values (#{id,jdbcType=INTEGER}, #{drugName,jdbcType=VARCHAR}, ",
        "#{doctorId,jdbcType=INTEGER}, #{drugFormat,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(DrugCommon record);

    int insertSelective(DrugCommon record);

    List<DrugCommon> selectByExample(DrugCommonExample example);

    @Select({
        "select",
        "id, drug_name, doctor_id, drug_format",
        "from drug_common",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    DrugCommon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DrugCommon record, @Param("example") DrugCommonExample example);

    int updateByExample(@Param("record") DrugCommon record, @Param("example") DrugCommonExample example);

    int updateByPrimaryKeySelective(DrugCommon record);

    @Update({
        "update drug_common",
        "set drug_name = #{drugName,jdbcType=VARCHAR},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "drug_format = #{drugFormat,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DrugCommon record);
}