package neu.his.bean;

import java.util.Date;

public class MedicalRecord {
    private Integer id;

    private Integer doctorId;

    private String chiefComplaint;

    private String historyOfPresentIllness;

    private String treatmentOfCurrentIllness;

    private String pastHistory;

    private String allergyHistory;

    private String physicalExamination;

    private String medicalRecordNo;

    private String isCommon;

    private String templateName;

    private String category;

    private Date seeTime;

    private String doctorName;

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