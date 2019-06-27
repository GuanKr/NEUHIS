package neu.his.dao;

import java.util.List;
import neu.his.bean.DiagnoseDirectory;
import neu.his.bean.DiagnoseDirectoryExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
/**
 * 处理诊断目录
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public interface DiagnoseDirectoryMapper {
    int countByExample(DiagnoseDirectoryExample example);

    int deleteByExample(DiagnoseDirectoryExample example);

    @Delete({
        "delete from diagnose_directory",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into diagnose_directory (id, disease_category_code, ",
        "disease_category_name, sequence_no, ",
        "disease_type)",
        "values (#{id,jdbcType=INTEGER}, #{diseaseCategoryCode,jdbcType=VARCHAR}, ",
        "#{diseaseCategoryName,jdbcType=VARCHAR}, #{sequenceNo,jdbcType=INTEGER}, ",
        "#{diseaseType,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(DiagnoseDirectory record);

    int insertSelective(DiagnoseDirectory record);

    List<DiagnoseDirectory> selectByExample(DiagnoseDirectoryExample example);

    @Select({
        "select",
        "id, disease_category_code, disease_category_name, sequence_no, disease_type",
        "from diagnose_directory",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    DiagnoseDirectory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DiagnoseDirectory record, @Param("example") DiagnoseDirectoryExample example);

    int updateByExample(@Param("record") DiagnoseDirectory record, @Param("example") DiagnoseDirectoryExample example);

    int updateByPrimaryKeySelective(DiagnoseDirectory record);

    @Update({
        "update diagnose_directory",
        "set disease_category_code = #{diseaseCategoryCode,jdbcType=VARCHAR},",
          "disease_category_name = #{diseaseCategoryName,jdbcType=VARCHAR},",
          "sequence_no = #{sequenceNo,jdbcType=INTEGER},",
          "disease_type = #{diseaseType,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DiagnoseDirectory record);
}