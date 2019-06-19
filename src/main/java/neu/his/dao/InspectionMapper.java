package neu.his.dao;

import java.util.List;
import neu.his.bean.Inspection;
import neu.his.bean.InspectionExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
/**
 * 处理检查/检验/处置信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface InspectionMapper {

    /**
     * 查找检查/检验信息
     * @param medicalNo 病历号
     * @return检查/检验/处置列表
     */
    List<Inspection> selectWithName(String medicalNo);


    /**
     * 查找常用检查/检验/处置信息
     * @param id 医生id
     * @return 常用检查/检验/处置列表
     */
    List<Inspection> selectCommon(Integer id);


    int countByExample(InspectionExample example);

    int deleteByExample(InspectionExample example);

    @Delete({
        "delete from inspection",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into inspection (id, medical_record_no, ",
        "non_drug_list_id, doctor_id, ",
        "inspection_result_analysis, pay_state, ",
        "pay_time, register_state, ",
        "validity, cost, is_common)",
        "values (#{id,jdbcType=INTEGER}, #{medicalRecordNo,jdbcType=CHAR}, ",
        "#{nonDrugListId,jdbcType=INTEGER}, #{doctorId,jdbcType=INTEGER}, ",
        "#{inspectionResultAnalysis,jdbcType=VARCHAR}, #{payState,jdbcType=CHAR}, ",
        "#{payTime,jdbcType=TIMESTAMP}, #{registerState,jdbcType=CHAR}, ",
        "#{validity,jdbcType=CHAR}, #{cost,jdbcType=DECIMAL}, #{isCommon,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Inspection record);

    int insertSelective(Inspection record);

    List<Inspection> selectByExample(InspectionExample example);

    @Select({
        "select",
        "id, medical_record_no, non_drug_list_id, doctor_id, inspection_result_analysis, ",
        "pay_state, pay_time, register_state, validity, cost, is_common",
        "from inspection",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Inspection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Inspection record, @Param("example") InspectionExample example);

    int updateByExample(@Param("record") Inspection record, @Param("example") InspectionExample example);

    int updateByPrimaryKeySelective(Inspection record);

    @Update({
        "update inspection",
        "set medical_record_no = #{medicalRecordNo,jdbcType=CHAR},",
          "non_drug_list_id = #{nonDrugListId,jdbcType=INTEGER},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "inspection_result_analysis = #{inspectionResultAnalysis,jdbcType=VARCHAR},",
          "pay_state = #{payState,jdbcType=CHAR},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "register_state = #{registerState,jdbcType=CHAR},",
          "validity = #{validity,jdbcType=CHAR},",
          "cost = #{cost,jdbcType=DECIMAL},",
          "is_common = #{isCommon,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Inspection record);
}