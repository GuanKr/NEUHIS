package neu.his.bean;

import java.util.Date;
/**
 * 存储病历信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class MedicalRecord {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 主诉
     */
    private String chiefComplaint;

    /**
     * 现病史
     */
    private String historyOfPresentIllness;

    /**
     * 现病治疗情况
     */
    private String treatmentOfCurrentIllness;

    /**
     * 既往史
     */
    private String pastHistory;

    /**
     * 过敏史
     */
    private String allergyHistory;

    /**
     * 体格检查
     */
    private String physicalExamination;

    /**
     * 病历号
     */
    private String medicalRecordNo;

    /**
     * 常用标志
     */
    private String isCommon;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 模板类别
     */
    private String category;

    /**
     * 看诊时间
     */
    private Date seeTime;

    /**
     * 医生姓名
     */
    private String doctorName;


    /**
     *
     * @param id 主键id
     * @param doctorId 医生id
     * @param chiefComplaint 主诉
     * @param historyOfPresentIllness 现病史
     * @param treatmentOfCurrentIllness 现病治疗情况
     * @param pastHistory 既往史
     * @param allergyHistory 过敏史
     * @param physicalExamination 体格检查
     * @param medicalRecordNo 病历号
     * @param isCommon 常用标志
     * @param templateName 模板名称
     * @param category 模板类别
     * @param seeTime 看诊时间
     */
    public MedicalRecord(Integer id, Integer doctorId, String chiefComplaint, String historyOfPresentIllness, String treatmentOfCurrentIllness, String pastHistory, String allergyHistory, String physicalExamination, String medicalRecordNo, String isCommon, String templateName, String category, Date seeTime) {
        this.id = id;
        this.doctorId = doctorId;
        this.chiefComplaint = chiefComplaint;
        this.historyOfPresentIllness = historyOfPresentIllness;
        this.treatmentOfCurrentIllness = treatmentOfCurrentIllness;
        this.pastHistory = pastHistory;
        this.allergyHistory = allergyHistory;
        this.physicalExamination = physicalExamination;
        this.medicalRecordNo = medicalRecordNo;
        this.isCommon = isCommon;
        this.templateName = templateName;
        this.category = category;
        this.seeTime = seeTime;
    }

    /**
     * 用于根据前端返回的数据构造病例对象
     * @param chiefComplaint 主诉
     * @param historyOfPresentIllness 现病史
     * @param treatmentOfCurrentIllness 现病治疗情况
     * @param pastHistory 既往史
     * @param allergyHistory 过敏史
     * @param physicalExamination 体格检查
     */
    public MedicalRecord(String chiefComplaint, String historyOfPresentIllness, String treatmentOfCurrentIllness, String pastHistory, String allergyHistory, String physicalExamination) {
        this.chiefComplaint = chiefComplaint;
        this.historyOfPresentIllness = historyOfPresentIllness;
        this.treatmentOfCurrentIllness = treatmentOfCurrentIllness;
        this.pastHistory = pastHistory;
        this.allergyHistory = allergyHistory;
        this.physicalExamination = physicalExamination;
    }
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public MedicalRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint == null ? null : chiefComplaint.trim();
    }

    public String getHistoryOfPresentIllness() {
        return historyOfPresentIllness;
    }

    public void setHistoryOfPresentIllness(String historyOfPresentIllness) {
        this.historyOfPresentIllness = historyOfPresentIllness == null ? null : historyOfPresentIllness.trim();
    }

    public String getTreatmentOfCurrentIllness() {
        return treatmentOfCurrentIllness;
    }

    public void setTreatmentOfCurrentIllness(String treatmentOfCurrentIllness) {
        this.treatmentOfCurrentIllness = treatmentOfCurrentIllness == null ? null : treatmentOfCurrentIllness.trim();
    }

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory == null ? null : pastHistory.trim();
    }

    public String getAllergyHistory() {
        return allergyHistory;
    }

    public void setAllergyHistory(String allergyHistory) {
        this.allergyHistory = allergyHistory == null ? null : allergyHistory.trim();
    }

    public String getPhysicalExamination() {
        return physicalExamination;
    }

    public void setPhysicalExamination(String physicalExamination) {
        this.physicalExamination = physicalExamination == null ? null : physicalExamination.trim();
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo == null ? null : medicalRecordNo.trim();
    }

    public String getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(String isCommon) {
        this.isCommon = isCommon == null ? null : isCommon.trim();
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Date getSeeTime() {
        return seeTime;
    }

    public void setSeeTime(Date seeTime) {
        this.seeTime = seeTime;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", chiefComplaint='" + chiefComplaint + '\'' +
                ", historyOfPresentIllness='" + historyOfPresentIllness + '\'' +
                ", treatmentOfCurrentIllness='" + treatmentOfCurrentIllness + '\'' +
                ", pastHistory='" + pastHistory + '\'' +
                ", allergyHistory='" + allergyHistory + '\'' +
                ", physicalExamination='" + physicalExamination + '\'' +
                ", medicalRecordNo='" + medicalRecordNo + '\'' +
                ", isCommon='" + isCommon + '\'' +
                ", templateName='" + templateName + '\'' +
                ", category='" + category + '\'' +
                ", seeTime=" + seeTime +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}