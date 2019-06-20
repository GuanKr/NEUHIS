package neu.his.bean;

import java.util.Date;

public class Diagnose {
    private Integer id;

    private Integer diseaseId;

    private String medicalRecordNo;

    private String majorDiagnoseSign;

    private String suspectedSign;

    private Date diseaseTime;

    private Integer doctorId;

    private String diseaseType;

    private String isCommon;

    private String diseaseName;

    private String doctorName;

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
}