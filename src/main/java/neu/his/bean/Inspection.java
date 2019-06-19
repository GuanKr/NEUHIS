package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Inspection {
    private Integer id;

    private String medicalRecordNo;

    private Integer nonDrugListId;

    private Integer doctorId;

    private String inspectionResultAnalysis;

    private String payState;

    private Date payTime;

    private String registerState;

    private String validity;

    private BigDecimal cost;

    private String isCommon;

    private String nonDrugListName;

    public Inspection(Integer id, String medicalRecordNo, Integer nonDrugListId, Integer doctorId, String inspectionResultAnalysis, String payState, Date payTime, String registerState, String validity, BigDecimal cost, String isCommon) {
        this.id = id;
        this.medicalRecordNo = medicalRecordNo;
        this.nonDrugListId = nonDrugListId;
        this.doctorId = doctorId;
        this.inspectionResultAnalysis = inspectionResultAnalysis;
        this.payState = payState;
        this.payTime = payTime;
        this.registerState = registerState;
        this.validity = validity;
        this.cost = cost;
        this.isCommon = isCommon;
    }

    public String getNonDrugListName() {
        return nonDrugListName;
    }

    public void setNonDrugListName(String nonDrugListName) {
        this.nonDrugListName = nonDrugListName;
    }

    public Inspection() {
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
        this.medicalRecordNo = medicalRecordNo == null ? null : medicalRecordNo.trim();
    }

    public Integer getNonDrugListId() {
        return nonDrugListId;
    }

    public void setNonDrugListId(Integer nonDrugListId) {
        this.nonDrugListId = nonDrugListId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getInspectionResultAnalysis() {
        return inspectionResultAnalysis;
    }

    public void setInspectionResultAnalysis(String inspectionResultAnalysis) {
        this.inspectionResultAnalysis = inspectionResultAnalysis == null ? null : inspectionResultAnalysis.trim();
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getRegisterState() {
        return registerState;
    }

    public void setRegisterState(String registerState) {
        this.registerState = registerState == null ? null : registerState.trim();
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity == null ? null : validity.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(String isCommon) {
        this.isCommon = isCommon == null ? null : isCommon.trim();
    }

    @Override
    public String toString() {
        return "Inspection{" +
                "id=" + id +
                ", medicalRecordNo='" + medicalRecordNo + '\'' +
                ", nonDrugListId=" + nonDrugListId +
                ", doctorId=" + doctorId +
                ", inspectionResultAnalysis='" + inspectionResultAnalysis + '\'' +
                ", payState='" + payState + '\'' +
                ", payTime=" + payTime +
                ", registerState='" + registerState + '\'' +
                ", validity='" + validity + '\'' +
                ", cost=" + cost +
                ", isCommon='" + isCommon + '\'' +
                ", nonDrugListName='" + nonDrugListName + '\'' +
                '}';
    }
}