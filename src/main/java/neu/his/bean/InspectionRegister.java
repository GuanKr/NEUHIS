package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 存储检查/检验登记信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class InspectionRegister {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 登记时间
     */
    private Date registerTime;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 金额
     */
    private BigDecimal cost;

    /**
     * 病历号
     */
    private String medicalRecordNo;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 构造方法：创建检查/检验登记信息
     * @param id 主键id
     * @param registerTime 登记时间
     * @param doctorId 医生id
     * @param cost 金额
     * @param medicalRecordNo 病历号
     * @param patientName 患者姓名
     */
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