package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;

public class RegistrationInfo {
    private Integer id;

    private String medicalRecordNo;

    private Integer registrationLevelId;

    private Date seeDoctorDate;

    private Integer departmentId;

    private Integer doctorId;

    private String registrationResource;

    private Integer settlementTypeId;

    private String isNeedMedicalrecordbook;

    private String isSeenDoctor;

    private BigDecimal expense;

    private String paymentState;

    private Date paymentTime;

    private String registrationState;

    private String isCompleted;

    private String patientName;

    private String patientIdentityNumber;

    private Integer patientAge;

    private String patientSex;

    private Date patientBirthday;

    private String address;

    private String registrationLevelName;

    private String registrationLevelPrice;

    private String departmentName;

    private String doctorName;

    private String settlementTypeName;

    public RegistrationInfo(Date seeDoctorDate, Integer doctorId, String isSeenDoctor, String paymentState, String registrationState) {
        this.seeDoctorDate = seeDoctorDate;
        this.doctorId = doctorId;
        this.isSeenDoctor = isSeenDoctor;
        this.paymentState = paymentState;
        this.registrationState = registrationState;
    }

    public RegistrationInfo(Integer id, String medicalRecordNo, Integer registrationLevelId, Date seeDoctorDate, Integer departmentId, Integer doctorId, String registrationResource, Integer settlementTypeId, String isNeedMedicalrecordbook, String isSeenDoctor, BigDecimal expense, String paymentState, Date paymentTime, String registrationState, String isCompleted, String patientName, String patientIdentityNumber, Integer patientAge, String patientSex, Date patientBirthday, String address) {
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
    }

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