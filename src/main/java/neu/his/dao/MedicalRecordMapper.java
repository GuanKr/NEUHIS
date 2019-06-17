package neu.his.dao;

import java.util.List;
import neu.his.bean.MedicalRecord;
import neu.his.bean.MedicalRecordExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface MedicalRecordMapper {
    int countByExample(MedicalRecordExample example);

    int deleteByExample(MedicalRecordExample example);

    @Delete({
        "delete from medical_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into medical_record (id, doctor_id, ",
        "chief_complaint, history_of_present_illness, ",
        "treatment_of_current_illness, past_history, ",
        "allergy_history, physical_examination, ",
        "medical_record_no, is_common, ",
        "template_name, category)",
        "values (#{id,jdbcType=INTEGER}, #{doctorId,jdbcType=INTEGER}, ",
        "#{chiefComplaint,jdbcType=VARCHAR}, #{historyOfPresentIllness,jdbcType=VARCHAR}, ",
        "#{treatmentOfCurrentIllness,jdbcType=VARCHAR}, #{pastHistory,jdbcType=VARCHAR}, ",
        "#{allergyHistory,jdbcType=VARCHAR}, #{physicalExamination,jdbcType=VARCHAR}, ",
        "#{medicalRecordNo,jdbcType=CHAR}, #{isCommon,jdbcType=CHAR}, ",
        "#{templateName,jdbcType=VARCHAR}, #{category,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(MedicalRecord record);

    int insertSelective(MedicalRecord record);

    List<MedicalRecord> selectByExample(MedicalRecordExample example);

    @Select({
        "select",
        "id, doctor_id, chief_complaint, history_of_present_illness, treatment_of_current_illness, ",
        "past_history, allergy_history, physical_examination, medical_record_no, is_common, ",
        "template_name, category",
        "from medical_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    MedicalRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MedicalRecord record, @Param("example") MedicalRecordExample example);

    int updateByExample(@Param("record") MedicalRecord record, @Param("example") MedicalRecordExample example);

    int updateByPrimaryKeySelective(MedicalRecord record);

    @Update({
        "update medical_record",
        "set doctor_id = #{doctorId,jdbcType=INTEGER},",
          "chief_complaint = #{chiefComplaint,jdbcType=VARCHAR},",
          "history_of_present_illness = #{historyOfPresentIllness,jdbcType=VARCHAR},",
          "treatment_of_current_illness = #{treatmentOfCurrentIllness,jdbcType=VARCHAR},",
          "past_history = #{pastHistory,jdbcType=VARCHAR},",
          "allergy_history = #{allergyHistory,jdbcType=VARCHAR},",
          "physical_examination = #{physicalExamination,jdbcType=VARCHAR},",
          "medical_record_no = #{medicalRecordNo,jdbcType=CHAR},",
          "is_common = #{isCommon,jdbcType=CHAR},",
          "template_name = #{templateName,jdbcType=VARCHAR},",
          "category = #{category,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MedicalRecord record);
}