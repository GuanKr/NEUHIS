package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 存储处方信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class DrugPrescription {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 病历号
     */
    private String medicalRecordNo;

    /**
     * 药品id
     */
    private Integer drugId;

    /**
     * 药品用法
     */
    private String drugUsage;

    /**
     * 药品用量
     */
    private BigDecimal drugDosage;

    /**
     * 频次
     */
    private String frequency;

    /**
     * 使用天数
     */
    private BigDecimal dayNumber;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 医嘱
     */
    private String doctorAdvice;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 缴费标志
     */
    private String paymentState;

    /**
     * 缴费时间
     */
    private Date paymentTime;

    /**
     * 取药标志
     */
    private String takeMedicineState;

    /**
     * 有效标志
     */
    private String status;

    /**
     * 药品类型
     */
    private String drugType;

    /**
     * 药品规格
     */
    private String drugFormat;

    /**
     * 金额
     */
    private BigDecimal cost;

    /**
     * 药品单价
     */
    private BigDecimal drugPrice;

    /**
     * 药品名称
     */
    private String drugName;

    /**
     * 构造方法：创建处方对象
     * @param id 主键id
     * @param medicalRecordNo 病历号
     * @param drugId 药品id
     * @param drugUsage 药品用法
     * @param drugDosage 药品用量
     * @param frequency 频次
     * @param dayNumber 使用天数
     * @param quantity 数量
     * @param doctorAdvice 医嘱
     * @param doctorId 医生id
     * @param paymentState 缴费标志
     * @param paymentTime 缴费时间
     * @param takeMedicineState 取药标志
     * @param status  有效标志
     * @param drugType 药品类型
     * @param drugFormat 药品规格
     * @param cost 金额
     * @param drugPrice 药品单价
     */
    public DrugPrescription(Integer id, String medicalRecordNo, Integer drugId, String drugUsage, BigDecimal drugDosage, String frequency, BigDecimal dayNumber, Integer quantity, String doctorAdvice, Integer doctorId, String paymentState, Date paymentTime, String takeMedicineState, String status, String drugType, String drugFormat, BigDecimal cost, BigDecimal drugPrice) {
        this.id = id;
        this.medicalRecordNo = medicalRecordNo;
        this.drugId = drugId;
        this.drugUsage = drugUsage;
        this.drugDosage = drugDosage;
        this.frequency = frequency;
        this.dayNumber = dayNumber;
        this.quantity = quantity;
        this.doctorAdvice = doctorAdvice;
        this.doctorId = doctorId;
        this.paymentState = paymentState;
        this.paymentTime = paymentTime;
        this.takeMedicineState = takeMedicineState;
        this.status = status;
        this.drugType = drugType;
        this.drugFormat = drugFormat;
        this.cost = cost;
        this.drugPrice = drugPrice;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public DrugPrescription() {
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

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getDrugUsage() {
        return drugUsage;
    }

    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage == null ? null : drugUsage.trim();
    }

    public BigDecimal getDrugDosage() {
        return drugDosage;
    }

    public void setDrugDosage(BigDecimal drugDosage) {
        this.drugDosage = drugDosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public BigDecimal getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(BigDecimal dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice == null ? null : doctorAdvice.trim();
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
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

    public String getTakeMedicineState() {
        return takeMedicineState;
    }

    public void setTakeMedicineState(String takeMedicineState) {
        this.takeMedicineState = takeMedicineState == null ? null : takeMedicineState.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType == null ? null : drugType.trim();
    }

    public String getDrugFormat() {
        return drugFormat;
    }

    public void setDrugFormat(String drugFormat) {
        this.drugFormat = drugFormat == null ? null : drugFormat.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(BigDecimal drugPrice) {
        this.drugPrice = drugPrice;
    }

    @Override
    public String toString() {
        return "DrugPrescription{" +
                "id=" + id +
                ", medicalRecordNo='" + medicalRecordNo + '\'' +
                ", drugId=" + drugId +
                ", drugUsage='" + drugUsage + '\'' +
                ", drugDosage=" + drugDosage +
                ", frequency='" + frequency + '\'' +
                ", dayNumber=" + dayNumber +
                ", quantity=" + quantity +
                ", doctorAdvice='" + doctorAdvice + '\'' +
                ", doctorId=" + doctorId +
                ", paymentState='" + paymentState + '\'' +
                ", paymentTime=" + paymentTime +
                ", takeMedicineState='" + takeMedicineState + '\'' +
                ", status='" + status + '\'' +
                ", drugType='" + drugType + '\'' +
                ", drugFormat='" + drugFormat + '\'' +
                ", cost=" + cost +
                ", drugPrice=" + drugPrice +
                ", drugName='" + drugName + '\'' +
                '}';
    }
}