package neu.his.dao;

import java.util.List;
import neu.his.bean.PrescriptionSetDetail;
import neu.his.bean.PrescriptionSetDetailExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
/**
 * 处理处方组套详细信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public interface PrescriptionSetDetailMapper {


    /**
     * 查找某组套下所有项目
     * @param setId 组套id
     * @return 项目列表
     */
    List<PrescriptionSetDetail> selectBySet(Integer setId);

    /**
     * 插入项目
     * @param prescriptionSetDetail 药品项目
     */
    void insertDetail(PrescriptionSetDetail prescriptionSetDetail);

    int countByExample(PrescriptionSetDetailExample example);

    int deleteByExample(PrescriptionSetDetailExample example);

    @Delete({
        "delete from prescription_set_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into prescription_set_detail (id, prescription_set_id, ",
        "drug_id, drug_format, ",
        "drug_usage, drug_dosage, ",
        "frequency)",
        "values (#{id,jdbcType=INTEGER}, #{prescriptionSetId,jdbcType=INTEGER}, ",
        "#{drugId,jdbcType=INTEGER}, #{drugFormat,jdbcType=VARCHAR}, ",
        "#{drugUsage,jdbcType=VARCHAR}, #{drugDosage,jdbcType=DECIMAL}, ",
        "#{frequency,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(PrescriptionSetDetail record);

    int insertSelective(PrescriptionSetDetail record);

    List<PrescriptionSetDetail> selectByExample(PrescriptionSetDetailExample example);

    @Select({
        "select",
        "id, prescription_set_id, drug_id, drug_format, drug_usage, drug_dosage, frequency",
        "from prescription_set_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    PrescriptionSetDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrescriptionSetDetail record, @Param("example") PrescriptionSetDetailExample example);

    int updateByExample(@Param("record") PrescriptionSetDetail record, @Param("example") PrescriptionSetDetailExample example);

    int updateByPrimaryKeySelective(PrescriptionSetDetail record);

    @Update({
        "update prescription_set_detail",
        "set prescription_set_id = #{prescriptionSetId,jdbcType=INTEGER},",
          "drug_id = #{drugId,jdbcType=INTEGER},",
          "drug_format = #{drugFormat,jdbcType=VARCHAR},",
          "drug_usage = #{drugUsage,jdbcType=VARCHAR},",
          "drug_dosage = #{drugDosage,jdbcType=DECIMAL},",
          "frequency = #{frequency,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PrescriptionSetDetail record);
}