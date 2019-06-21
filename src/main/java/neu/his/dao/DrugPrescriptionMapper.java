package neu.his.dao;

import java.util.List;
import neu.his.bean.DrugPrescription;
import neu.his.bean.DrugPrescriptionExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface DrugPrescriptionMapper {
    int countByExample(DrugPrescriptionExample example);

    int deleteByExample(DrugPrescriptionExample example);

    @Delete({
        "delete from drug_prescription",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into drug_prescription (id, medical_record_no, ",
        "drug_id, drug_usage, ",
        "drug_dosage, frequency, ",
        "day_number, quantity, ",
        "doctor_advice, doctor_id, ",
        "payment_state, payment_time, ",
        "take_medicine_state, status, ",
        "drug_type, drug_format, ",
        "cost, drug_price)",
        "values (#{id,jdbcType=INTEGER}, #{medicalRecordNo,jdbcType=CHAR}, ",
        "#{drugId,jdbcType=INTEGER}, #{drugUsage,jdbcType=VARCHAR}, ",
        "#{drugDosage,jdbcType=DECIMAL}, #{frequency,jdbcType=VARCHAR}, ",
        "#{dayNumber,jdbcType=DECIMAL}, #{quantity,jdbcType=INTEGER}, ",
        "#{doctorAdvice,jdbcType=VARCHAR}, #{doctorId,jdbcType=INTEGER}, ",
        "#{paymentState,jdbcType=CHAR}, #{paymentTime,jdbcType=TIMESTAMP}, ",
        "#{takeMedicineState,jdbcType=CHAR}, #{status,jdbcType=CHAR}, ",
        "#{drugType,jdbcType=CHAR}, #{drugFormat,jdbcType=VARCHAR}, ",
        "#{cost,jdbcType=DECIMAL}, #{drugPrice,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(DrugPrescription record);

    int insertSelective(DrugPrescription record);

    List<DrugPrescription> selectByExample(DrugPrescriptionExample example);

    @Select({
        "select",
        "id, medical_record_no, drug_id, drug_usage, drug_dosage, frequency, day_number, ",
        "quantity, doctor_advice, doctor_id, payment_state, payment_time, take_medicine_state, ",
        "status, drug_type, drug_format, cost, drug_price",
        "from drug_prescription",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    DrugPrescription selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DrugPrescription record, @Param("example") DrugPrescriptionExample example);

    int updateByExample(@Param("record") DrugPrescription record, @Param("example") DrugPrescriptionExample example);

    int updateByPrimaryKeySelective(DrugPrescription record);

    @Update({
        "update drug_prescription",
        "set medical_record_no = #{medicalRecordNo,jdbcType=CHAR},",
          "drug_id = #{drugId,jdbcType=INTEGER},",
          "drug_usage = #{drugUsage,jdbcType=VARCHAR},",
          "drug_dosage = #{drugDosage,jdbcType=DECIMAL},",
          "frequency = #{frequency,jdbcType=VARCHAR},",
          "day_number = #{dayNumber,jdbcType=DECIMAL},",
          "quantity = #{quantity,jdbcType=INTEGER},",
          "doctor_advice = #{doctorAdvice,jdbcType=VARCHAR},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "payment_state = #{paymentState,jdbcType=CHAR},",
          "payment_time = #{paymentTime,jdbcType=TIMESTAMP},",
          "take_medicine_state = #{takeMedicineState,jdbcType=CHAR},",
          "status = #{status,jdbcType=CHAR},",
          "drug_type = #{drugType,jdbcType=CHAR},",
          "drug_format = #{drugFormat,jdbcType=VARCHAR},",
          "cost = #{cost,jdbcType=DECIMAL},",
          "drug_price = #{drugPrice,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DrugPrescription record);
}