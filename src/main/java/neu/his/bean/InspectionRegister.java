package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;

public class InspectionRegister {
    private Integer id;

    private Date registerTime;

    private Integer doctorId;

    private BigDecimal cost;

    private String medicalRecordNo;

    private String patientName;

    public InspectionRegister(Integer id, Date registerTime, Integer doctorId, BigDecimal cost, String medicalRecordNo, String patientName) {
        this.id = id;
        this.registerTime = registerTime;
        this.doctorId = doctorId;
        this.cost = cost;
        this.medicalRecordNo = medicalRecordNo;
        this.patientName = patientName;
    }

    public InspectionRegister() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo == null ? null : medicalRecordNo.trim();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    @Override
    public String toString() {
        return "InspectionRegister{" +
                "id=" + id +
                ", registerTime=" + registerTime +
                ", doctorId=" + doctorId +
                ", cost=" + cost +
                ", medicalRecordNo='" + medicalRecordNo + '\'' +
                ", patientName='" + patientName + '\'' +
                '}';
    }
}