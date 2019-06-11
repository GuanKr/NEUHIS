package neu.his.dao;

import java.util.List;
import neu.his.bean.Disease;
import neu.his.bean.DiseaseExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface DiseaseMapper {
    int countByExample(DiseaseExample example);

    int deleteByExample(DiseaseExample example);

    @Delete({
        "delete from disease",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into disease (id, diagnose_directory_id, ",
        "international_icd_code, disease_name, ",
        "disease_mnemonic_code)",
        "values (#{id,jdbcType=INTEGER}, #{diagnoseDirectoryId,jdbcType=INTEGER}, ",
        "#{internationalIcdCode,jdbcType=VARCHAR}, #{diseaseName,jdbcType=VARCHAR}, ",
        "#{diseaseMnemonicCode,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Disease record);

    int insertSelective(Disease record);

    List<Disease> selectByExample(DiseaseExample example);

    @Select({
        "select",
        "id, diagnose_directory_id, international_icd_code, disease_name, disease_mnemonic_code",
        "from disease",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Disease selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Disease record, @Param("example") DiseaseExample example);

    int updateByExample(@Param("record") Disease record, @Param("example") DiseaseExample example);

    int updateByPrimaryKeySelective(Disease record);

    @Update({
        "update disease",
        "set diagnose_directory_id = #{diagnoseDirectoryId,jdbcType=INTEGER},",
          "international_icd_code = #{internationalIcdCode,jdbcType=VARCHAR},",
          "disease_name = #{diseaseName,jdbcType=VARCHAR},",
          "disease_mnemonic_code = #{diseaseMnemonicCode,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Disease record);
}