package neu.his.dao;

import java.util.List;

import neu.his.bean.Query;
import neu.his.bean.RegistrationInfo;
import neu.his.bean.RegistrationInfoExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
/**
 * 处理挂号信息
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface RegistrationInfoMapper {


    /**
     * 查找挂号的信息：诊毕用
     * @param query 查询信息
     * @return 挂号信息
     */
    List<RegistrationInfo> query(Query query);

    /**
     * 查找挂号的信息：收费用
     * @param query 查询信息
     * @return 挂号信息
     */
    List<RegistrationInfo> query2(Query query);

    /**
     * 查找待诊病人的信息
     * @param id 医生id
     * @return 待诊病人信息
     */
    List<RegistrationInfo> queryMissedByDoctorId(Integer id);

    /**
     * 查找已诊病人的信息
     * @param id 医生id
     * @return 已诊病人信息
     */
    List<RegistrationInfo> queryAlreadyByDoctorId(Integer id);

    /**
     * 查询挂号信息
     * @return 挂号信息列表
     */
    List<RegistrationInfo> selectWithName();

    /**
     * 插入挂号信息
     * @param registrationInfo 挂号信息
     */
    void insertRegInfo(RegistrationInfo registrationInfo);

    /**
     * 返回最晚生成的流水号
     * @return 最晚生成的流水号
     */
    String serNumber();

    int countByExample(RegistrationInfoExample example);

    int deleteByExample(RegistrationInfoExample example);

    @Delete({
        "delete from registration_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into registration_info (id, medical_record_no, ",
        "registration_level_id, see_doctor_date, ",
        "department_id, doctor_id, ",
        "registration_resource, settlement_type_id, ",
        "is_need_medicalrecordbook, is_seen_doctor, ",
        "expense, payment_state, ",
        "payment_time, registration_state, ",
        "is_completed, patient_name, ",
        "patient_identity_number, patient_age, ",
        "patient_sex, patient_birthday, ",
        "address)",
        "values (#{id,jdbcType=INTEGER}, #{medicalRecordNo,jdbcType=CHAR}, ",
        "#{registrationLevelId,jdbcType=INTEGER}, #{seeDoctorDate,jdbcType=TIMESTAMP}, ",
        "#{departmentId,jdbcType=INTEGER}, #{doctorId,jdbcType=INTEGER}, ",
        "#{registrationResource,jdbcType=CHAR}, #{settlementTypeId,jdbcType=INTEGER}, ",
        "#{isNeedMedicalrecordbook,jdbcType=CHAR}, #{isSeenDoctor,jdbcType=CHAR}, ",
        "#{expense,jdbcType=DECIMAL}, #{paymentState,jdbcType=CHAR}, ",
        "#{paymentTime,jdbcType=TIMESTAMP}, #{registrationState,jdbcType=CHAR}, ",
        "#{isCompleted,jdbcType=CHAR}, #{patientName,jdbcType=VARCHAR}, ",
        "#{patientIdentityNumber,jdbcType=CHAR}, #{patientAge,jdbcType=INTEGER}, ",
        "#{patientSex,jdbcType=CHAR}, #{patientBirthday,jdbcType=DATE}, ",
        "#{address,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(RegistrationInfo record);

    int insertSelective(RegistrationInfo record);

    List<RegistrationInfo> selectByExample(RegistrationInfoExample example);

    @Select({
        "select",
        "id, medical_record_no, registration_level_id, see_doctor_date, department_id, ",
        "doctor_id, registration_resource, settlement_type_id, is_need_medicalrecordbook, ",
        "is_seen_doctor, expense, payment_state, payment_time, registration_state, is_completed, ",
        "patient_name, patient_identity_number, patient_age, patient_sex, patient_birthday, ",
        "address",
        "from registration_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    RegistrationInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RegistrationInfo record, @Param("example") RegistrationInfoExample example);

    int updateByExample(@Param("record") RegistrationInfo record, @Param("example") RegistrationInfoExample example);

    int updateByPrimaryKeySelective(RegistrationInfo record);

    @Update({
        "update registration_info",
        "set medical_record_no = #{medicalRecordNo,jdbcType=CHAR},",
          "registration_level_id = #{registrationLevelId,jdbcType=INTEGER},",
          "see_doctor_date = #{seeDoctorDate,jdbcType=TIMESTAMP},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "registration_resource = #{registrationResource,jdbcType=CHAR},",
          "settlement_type_id = #{settlementTypeId,jdbcType=INTEGER},",
          "is_need_medicalrecordbook = #{isNeedMedicalrecordbook,jdbcType=CHAR},",
          "is_seen_doctor = #{isSeenDoctor,jdbcType=CHAR},",
          "expense = #{expense,jdbcType=DECIMAL},",
          "payment_state = #{paymentState,jdbcType=CHAR},",
          "payment_time = #{paymentTime,jdbcType=TIMESTAMP},",
          "registration_state = #{registrationState,jdbcType=CHAR},",
          "is_completed = #{isCompleted,jdbcType=CHAR},",
          "patient_name = #{patientName,jdbcType=VARCHAR},",
          "patient_identity_number = #{patientIdentityNumber,jdbcType=CHAR},",
          "patient_age = #{patientAge,jdbcType=INTEGER},",
          "patient_sex = #{patientSex,jdbcType=CHAR},",
          "patient_birthday = #{patientBirthday,jdbcType=DATE},",
          "address = #{address,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RegistrationInfo record);
}