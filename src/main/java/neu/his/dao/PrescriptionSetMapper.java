package neu.his.dao;

import java.util.List;
import neu.his.bean.PrescriptionSet;
import neu.his.bean.PrescriptionSetExample;
import neu.his.bean.SetQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
/**
 * 处理处方组套信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public interface PrescriptionSetMapper {

    /**
     * 查询组套
     * @param setQuery 封装的查询信息
     * @return 查询结果列表
     */
    List<PrescriptionSet> query(SetQuery setQuery);

    /**
     * 查询组套信息
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<PrescriptionSet> selectWithName(Integer doctorId);

    int countByExample(PrescriptionSetExample example);

    int deleteByExample(PrescriptionSetExample example);

    @Delete({
        "delete from prescription_set",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into prescription_set (id, doctor_id, ",
        "combinatorial_code, combinatorial_name, ",
        "category, requirement, ",
        "create_time)",
        "values (#{id,jdbcType=INTEGER}, #{doctorId,jdbcType=INTEGER}, ",
        "#{combinatorialCode,jdbcType=VARCHAR}, #{combinatorialName,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=CHAR}, #{requirement,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(PrescriptionSet record);

    int insertSelective(PrescriptionSet record);

    List<PrescriptionSet> selectByExample(PrescriptionSetExample example);

    @Select({
        "select",
        "id, doctor_id, combinatorial_code, combinatorial_name, category, requirement, ",
        "create_time",
        "from prescription_set",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    PrescriptionSet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrescriptionSet record, @Param("example") PrescriptionSetExample example);

    int updateByExample(@Param("record") PrescriptionSet record, @Param("example") PrescriptionSetExample example);

    int updateByPrimaryKeySelective(PrescriptionSet record);

    @Update({
        "update prescription_set",
        "set doctor_id = #{doctorId,jdbcType=INTEGER},",
          "combinatorial_code = #{combinatorialCode,jdbcType=VARCHAR},",
          "combinatorial_name = #{combinatorialName,jdbcType=VARCHAR},",
          "category = #{category,jdbcType=CHAR},",
          "requirement = #{requirement,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PrescriptionSet record);
}