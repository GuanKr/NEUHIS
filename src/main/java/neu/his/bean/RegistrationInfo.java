package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 存储挂号信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class RegistrationInfo {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 病历号
     */
    private String medicalRecordNo;

    /**
     * 挂号级别id
     */
    private Integer registrationLevelId;

    /**
     * 看诊日期
     */
    private Date seeDoctorDate;

    /**
     * 科室id
     */
    private Integer departmentId;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 挂号来源
     */
    private String registrationResource;

    /**
     * 结算类别id
     */
    private Integer settlementTypeId;

    /**
     * 需要病历本标志
     */
    private String isNeedMedicalrecordbook;

    /**
     * 看诊标志
     */
    private String isSeenDoctor;

    /**
     * 费用
     */
    private BigDecimal expense;

    /**
     * 缴费状态
     */
    private String paymentState;

    /**
     * 缴费时间
     */
    private Date paymentTime;

    /**
     * 挂号状态
     */
    private String registrationState;

    /**
     * 诊毕标志
     */
    private String isCompleted;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 患者身份证号
     */
    private String patientIdentityNumber;

    /**
     * 患者年龄
     */
    private Integer patientAge;

    /**
     * 患者性别
     */
    private String patientSex;

    /**
     * 患者出生日期
     */
    private Date patientBirthday;

    /**
     * 患者地址
     */
    private String address;

    /**
     * 挂号级别名称
     */
    private String registrationLevelName;

    /**
     * 挂号级别价格
     */
    private String registrationLevelPrice;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 结算类别名称
     */
    private String settlementTypeName;

    /**
     * 存放转为字符串的缴费时间
     */
    private String paymentTimeString;
    /**
     * 存放转为字符串的生日
     */
    private String patientBirthdayString;
    /**
     * 存放转为字符串的看诊日期
     */
    private String seeDoctorDateString;

    /**
     * 构造方法
     * @param seeDoctorDate 看诊日期
     * @param doctorId 医生id
     * @param isSeenDoctor 看诊标志
     * @param paymentState 缴费状态
     * @param registrationState 挂号状态
     */
    public RegistrationInfo(Date seeDoctorDate, Integer doctorId, String isSeenDoctor, String paymentState, String registrationState) {
        this.seeDoctorDate = seeDoctorDate;
        this.doctorId = doctorId;
        this.isSeenDoctor = isSeenDoctor;
        this.paymentState = paymentState;
        this.registrationState = registrationState;
    }


   /* public RegistrationInfo(Integer id, String medicalRecordNo, Integer registrationLevelId, Date seeDoctorDate, Integer departmentId, Integer doctorId, String registrationResource, Integer settlementTypeId, String isNeedMedicalrecordbook, String isSeenDoctor, BigDecimal expense, String paymentState, Date paymentTime, String registrationState, String isCompleted, String patientName, String patientIdentityNumber, Integer patientAge, String patientSex, Date patientBirthday, String address) {
        this.id = id;
        this.medicalRecordNo = medicalRecordNo;
        this.registrationLevelId = registrationLevelId;
        this.seeDoctorDate = seeDoctorDate;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.registrationResource = registrationResource;
        this.settlementTypeId = settlementTypeId;
        this.isNeedMedicalrecordbook = isNeedMedicalrecordbook;
        this.isSeenDoctor = isSeenDoctor;
        this.expense = expense;
        this.paymentState = paymentState;
        this.paymentTime = paymentTime;
        this.registrationState = registrationState;
        this.isCompleted = isCompleted;
        this.patientName = patientName;
        this.patientIdentityNumber = patientIdentityNumber;
        this.patientAge = patientAge;
        this.patientSex = patientSex;
        this.patientBirthday = patientBirthday;
        this.address = address;
    }*/

    /**
     * 构造方法
     * @param medicalRecordNo 病历号
     * @param seeDoctorDate 看诊日期
     * @param registrationResource 挂号来源
     * @param isNeedMedicalrecordbook 需要病历本标志
     * @param expense 费用
     * @param patientName 患者姓名
     * @param patientIdentityNumber 患者身份证号
     * @param patientAge 患者年龄
     * @param patientSex 患者性别
     * @param patientBirthday 患者出生日期
     * @param address 地址
     */
    public RegistrationInfo(String medicalRecordNo, Date seeDoctorDate, String registrationResource, String isNeedMedicalrecordbook, BigDecimal expense, String patientName, String patientIdentityNumber, Integer patientAge, String patientSex, Date patientBirthday, String address) {
        this.medicalRecordNo = medicalRecordNo;
        this.seeDoctorDate = seeDoctorDate;
        this.registrationResource = registrationResource;
        this.isNeedMedicalrecordbook = isNeedMedicalrecordbook;
        this.expense = expense;
        this.patientName = patientName;
        this.patientIdentityNumber = patientIdentityNumber;
        this.patientAge = patientAge;
        this.patientSex = patientSex;
        this.patientBirthday = patientBirthday;
        this.address = address;
    }


    /**
     * 前端返回的挂号信息构造方法
     * @param medicalRecordNo 病历号
     * @param registrationResource 挂号来源
     * @param isNeedMedicalrecordbook 需要病历本标志
     * @param expense 费用
     * @param patientName 患者姓名
     * @param patientIdentityNumber 患者身份证号
     * @param patientAge 患者年龄
     * @param patientSex 患者性别
     * @param patientBirthday 患者出生日期
     * @param address 地址
     * @param registrationLevelName 挂号级别名称
     * @param departmentName 科室名称
     * @param doctorName 医生姓名
     * @param settlementTypeName 结算类别名称
     * @param seeDoctorDateString 转为字符串的看诊日期
     */
    public RegistrationInfo(String medicalRecordNo, String registrationResource, String isNeedMedicalrecordbook, BigDecimal expense, String patientName, String patientIdentityNumber, Integer patientAge, String patientSex, Date patientBirthday, String address, String registrationLevelName, String departmentName, String doctorName, String settlementTypeName, String seeDoctorDateString) {
        this.medicalRecordNo = medicalRecordNo;
        this.registrationResource = registrationResource;
        this.isNeedMedicalrecordbook = isNeedMedicalrecordbook;
        this.expense = expense;
        this.patientName = patientName;
        this.patientIdentityNumber = patientIdentityNumber;
        this.patientAge = patientAge;
        this.patientSex = patientSex;
        this.patientBirthday = patientBirthday;
        this.address = address;
        this.registrationLevelName = registrationLevelName;
        this.departmentName = departmentName;
        this.doctorName = doctorName;
        this.settlementTypeName = settlementTypeName;
        this.seeDoctorDateString = seeDoctorDateString;
    }

    public String getPaymentTimeString() {
        return paymentTimeString;
    }

    public void setPaymentTimeString(String paymentTimeString) {
        this.paymentTimeString = paymentTimeString;
    }

    public String getPatientBirthdayString() {
        return patientBirthdayString;
    }

    public void setPatientBirthdayString(String patientBirthdayString) {
        this.patientBirthdayString = patientBirthdayString;
    }

    public String getSeeDoctorDateString() {
        return seeDoctorDateString;
    }

    public void setSeeDoctorDateString(String seeDoctorDateString) {
        this.seeDoctorDateString = seeDoctorDateString;
    }

    public String getRegistrationLevelName() {
        return registrationLevelName;
    }

    public void setRegistrationLevelName(String registrationLevelName) {
        this.registrationLevelName = registrationLevelName;
    }

    public String getRegistrationLevelPrice() {
        return registrationLevelPrice;
    }

    public void setRegistrationLevelPrice(String registrationLevelPrice) {
        this.registrationLevelPrice = registrationLevelPrice;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSettlementTypeName() {
        return settlementTypeName;
    }

    public void setSettlementTypeName(String settlementTypeName) {
        this.settlementTypeName = settlementTypeName;
    }

    public RegistrationInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public Integer getRegistrationLevelId() {
        return registrationLevelId;
    }

    public void setRegistrationLevelId(Integer registrationLevelId) {
        this.registrationLevelId = registrationLevelId;
    }

    public Date getSeeDoctorDate() {
        return seeDoctorDate;
    }

    public void setSeeDoctorDate(Date seeDoctorDate) {
        this.seeDoctorDate = seeDoctorDate;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getRegistrationResource() {
        return registrationResource;
    }

    public void setRegistrationResource(String registrationResource) {
        this.registrationResource = registrationResource == null ? null : registrationResource.trim();
    }

    public Integer getSettlementTypeId() {
        return settlementTypeId;
    }

    public void setSettlementTypeId(Integer settlementTypeId) {
        this.settlementTypeId = settlementTypeId;
    }

    public String getIsNeedMedicalrecordbook() {
        return isNeedMedicalrecordbook;
    }

    public void setIsNeedMedicalrecordbook(String isNeedMedicalrecordbook) {
        this.isNeedMedicalrecordbook = isNeedMedicalrecordbook == null ? null : isNeedMedicalrecordbook.trim();
    }

    public String getIsSeenDoctor() {
        return isSeenDoctor;
    }

    public void setIsSeenDoctor(String isSeenDoctor) {
        this.isSeenDoctor = isSeenDoctor == null ? null : isSeenDoctor.trim();
    }

    public BigDecimal getExpense() {
        return expense;
    }

    public void setExpense(BigDecimal expense) {
        this.expense = expense;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState == null ? null : paymentState.trim();
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getRegistrationState() {
        return registrationState;
    }

    public void setRegistrationState(String registrationState) {
        this.registrationState = registrationState == null ? null : registrationState.trim();
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted == null ? null : isCompleted.trim();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getPatientIdentityNumber() {
        return patientIdentityNumber;
    }

    public void setPatientIdentityNumber(String patientIdentityNumber) {
        this.patientIdentityNumber = patientIdentityNumber == null ? null : patientIdentityNumber.trim();
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex == null ? null : patientSex.trim();
    }

    public Date getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(Date patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    @Override
    public String toString() {
        return "RegistrationInfo{" +
                "id=" + id +
                ", medicalRecordNo=" + medicalRecordNo +
                ", registrationLevelId=" + registrationLevelId +
                ", seeDoctorDate=" + seeDoctorDate +
                ", departmentId=" + departmentId +
                ", doctorId=" + doctorId +
                ", registrationResource='" + registrationResource + '\'' +
                ", settlementTypeId=" + settlementTypeId +
                ", isNeedMedicalrecordbook='" + isNeedMedicalrecordbook + '\'' +
                ", isSeenDoctor='" + isSeenDoctor + '\'' +
                ", expense=" + expense +
                ", paymentState='" + paymentState + '\'' +
                ", paymentTime=" + paymentTime +
                ", registrationState='" + registrationState + '\'' +
                ", isCompleted='" + isCompleted + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientIdentityNumber='" + patientIdentityNumber + '\'' +
                ", patientAge=" + patientAge +
                ", patientSex='" + patientSex + '\'' +
                ", patientBirthday=" + patientBirthday +
                ", address='" + address + '\'' +
                ", registrationLevelName='" + registrationLevelName + '\'' +
                ", registrationLevelPrice='" + registrationLevelPrice + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", settlementTypeName='" + settlementTypeName + '\'' +
                '}';
    }
}