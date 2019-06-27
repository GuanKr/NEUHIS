package neu.his.bean;

import java.util.Date;
/**
 * 存储诊断信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class Diagnose {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 疾病id
     */
    private Integer diseaseId;

    /**
     * 病历号
     */
    private String medicalRecordNo;

    /**
     * 主诊标志
     */
    private String majorDiagnoseSign;

    /**
     * 疑似标志
     */
    private String suspectedSign;

    /**
     * 发病时间
     */
    private Date diseaseTime;

    /**
     * 诊断医生id
     */
    private Integer doctorId;

    /**
     * 疾病类型
     */
    private String diseaseType;

    /**
     * 模板标志
     */
    private String isCommon;

    /**
     * 疾病名称
     */
    private String diseaseName;

    /**
     * 诊断医生姓名
     */
    private String doctorName;

    /**
     * 诊断
     * @param id 主键id
     * @param diseaseId 疾病id
     * @param medicalRecordNo 病历号
     * @param majorDiagnoseSign 主诊标志
     * @param suspectedSign 疑似标志
     * @param diseaseTime 发病时间
     * @param doctorId 医生id
     * @param diseaseType 疾病类型
     * @param isCommon 模板标志
     */
    public Diagnose(Integer id, Integer diseaseId, String medicalRecordNo, String majorDiagnoseSign, String suspectedSign, Date diseaseTime, Integer doctorId, String diseaseType, String isCommon) {
        this.id = id;
        this.diseaseId = diseaseId;
        this.medicalRecordNo = medicalRecordNo;
        this.majorDiagnoseSign = majorDiagnoseSign;
        this.suspectedSign = suspectedSign;
        this.diseaseTime = diseaseTime;
        this.doctorId = doctorId;
        this.diseaseType = diseaseType;
        this.isCommon = isCommon;
    }

    /**
     * 用于根据前端返回的数据构造诊断对象
     * @param diseaseId 疾病id
     * @param majorDiagnoseSign 主诊
     * @param diseaseTime 发病时间
     * @param diseaseType 疾病类型
     * @param diseaseName 疾病名称
     */
    public Diagnose(Integer diseaseId, String majorDiagnoseSign, Date diseaseTime, String diseaseType, String diseaseName) {
        this.diseaseId = diseaseId;
        this.majorDiagnoseSign = majorDiagnoseSign;
        this.diseaseTime = diseaseTime;
        this.diseaseType = diseaseType;
        this.diseaseName = diseaseName;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Diagnose() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo == null ? null : medicalRecordNo.trim();
    }

    public String getMajorDiagnoseSign() {
        return majorDiagnoseSign;
    }

    public void setMajorDiagnoseSign(String majorDiagnoseSign) {
        this.majorDiagnoseSign = majorDiagnoseSign == null ? null : majorDiagnoseSign.trim();
    }

    public String getSuspectedSign() {
        return suspectedSign;
    }

    public void setSuspectedSign(String suspectedSign) {
        this.suspectedSign = suspectedSign == null ? null : suspectedSign.trim();
    }

    public Date getDiseaseTime() {
        return diseaseTime;
    }

    public void setDiseaseTime(Date diseaseTime) {
        this.diseaseTime = diseaseTime;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType == null ? null : diseaseType.trim();
    }

    public String getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(String isCommon) {
        this.isCommon = isCommon == null ? null : isCommon.trim();
    }

    @Override
    public String toString() {
        return "Diagnose{" +
                "id=" + id +
                ", diseaseId=" + diseaseId +
                ", medicalRecordNo='" + medicalRecordNo + '\'' +
                ", majorDiagnoseSign='" + majorDiagnoseSign + '\'' +
                ", suspectedSign='" + suspectedSign + '\'' +
                ", diseaseTime=" + diseaseTime +
                ", doctorId=" + doctorId +
                ", diseaseType='" + diseaseType + '\'' +
                ", isCommon='" + isCommon + '\'' +
                ", diseaseName='" + diseaseName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}