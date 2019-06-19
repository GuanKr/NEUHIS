package neu.his.dao;

import java.util.List;
import neu.his.bean.Diagnose;
import neu.his.bean.DiagnoseExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface DiagnoseMapper {
    int countByExample(DiagnoseExample example);

    int deleteByExample(DiagnoseExample example);

    @Delete({
        "delete from diagnose",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into diagnose (id, disease_id, ",
        "medical_record_no, major_diagnose_sign, ",
        "suspected_sign, disease_time, ",
        "doctor_id, disease_type, ",
        "is_common)",
        "values (#{id,jdbcType=INTEGER}, #{diseaseId,jdbcType=INTEGER}, ",
        "#{medicalRecordNo,jdbcType=CHAR}, #{majorDiagnoseSign,jdbcType=CHAR}, ",
        "#{suspectedSign,jdbcType=CHAR}, #{diseaseTime,jdbcType=DATE}, ",
        "#{doctorId,jdbcType=INTEGER}, #{diseaseType,jdbcType=CHAR}, ",
        "#{isCommon,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Diagnose record);

    int insertSelective(Diagnose record);

    List<Diagnose> selectByExample(DiagnoseExample example);

    @Select({
        "select",
        "id, disease_id, medical_record_no, major_diagnose_sign, suspected_sign, disease_time, ",
        "doctor_id, disease_type, is_common",
        "from diagnose",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Diagnose selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Diagnose record, @Param("example") DiagnoseExample example);

    int updateByExample(@Param("record") Diagnose record, @Param("example") DiagnoseExample example);

    int updateByPrimaryKeySelective(Diagnose record);

    @Update({
        "update diagnose",
        "set disease_id = #{diseaseId,jdbcType=INTEGER},",
          "medical_record_no = #{medicalRecordNo,jdbcType=CHAR},",
          "major_diagnose_sign = #{majorDiagnoseSign,jdbcType=CHAR},",
          "suspected_sign = #{suspectedSign,jdbcType=CHAR},",
          "disease_time = #{diseaseTime,jdbcType=DATE},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "disease_type = #{diseaseType,jdbcType=CHAR},",
          "is_common = #{isCommon,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Diagnose record);
}