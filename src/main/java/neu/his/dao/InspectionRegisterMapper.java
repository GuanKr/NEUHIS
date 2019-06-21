package neu.his.dao;

import java.util.List;
import neu.his.bean.InspectionRegister;
import neu.his.bean.InspectionRegisterExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface InspectionRegisterMapper {
    int countByExample(InspectionRegisterExample example);

    int deleteByExample(InspectionRegisterExample example);

    @Delete({
        "delete from inspection_register",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into inspection_register (id, register_time, ",
        "doctor_id, cost, ",
        "medical_record_no, patient_name)",
        "values (#{id,jdbcType=INTEGER}, #{registerTime,jdbcType=TIMESTAMP}, ",
        "#{doctorId,jdbcType=INTEGER}, #{cost,jdbcType=DECIMAL}, ",
        "#{medicalRecordNo,jdbcType=CHAR}, #{patientName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(InspectionRegister record);

    int insertSelective(InspectionRegister record);

    List<InspectionRegister> selectByExample(InspectionRegisterExample example);

    @Select({
        "select",
        "id, register_time, doctor_id, cost, medical_record_no, patient_name",
        "from inspection_register",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    InspectionRegister selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InspectionRegister record, @Param("example") InspectionRegisterExample example);

    int updateByExample(@Param("record") InspectionRegister record, @Param("example") InspectionRegisterExample example);

    int updateByPrimaryKeySelective(InspectionRegister record);

    @Update({
        "update inspection_register",
        "set register_time = #{registerTime,jdbcType=TIMESTAMP},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "cost = #{cost,jdbcType=DECIMAL},",
          "medical_record_no = #{medicalRecordNo,jdbcType=CHAR},",
          "patient_name = #{patientName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(InspectionRegister record);
}