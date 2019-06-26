package neu.his.bean;

import java.math.BigDecimal;
/**
 * 显示工作量信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class Workload {
    /**
     * 医生id
     */
    private Integer doctorId;
    /**
     * 医生姓名
     */
    private String doctorName;
    /**
     * 科室id
     */
    private Integer departmentId;
    /**
     * 科室名称
     */
    private String departmentName;
    /**
     * 发票数量
     */
    private Integer invoiceQuantity;
    /**
     * 看诊人数
     */
    private Integer seeQuantity;
    /**
     * 病人姓名
     */
    private String patientName;
    /**
     * 病历号
     */
    private String medicalNo;
    /**
     * 挂号费
     */
    private BigDecimal regCost;
    /**
     * 处方费
     */
    private BigDecimal drugCost;
    /**
     * 检查费
     */
    private BigDecimal inspectionCost;
    /**
     * 检验费
     */
    private BigDecimal checkoutCost;
    /**
     * 处置费
     */
    private BigDecimal handleCost;
    /**
     * 金额
     */
    private BigDecimal cost;

    /**
     * 构造方法
     * @param doctorId 医生id
     * @param doctorName 医生姓名
     * @param departmentId 科室id
     * @param departmentName 科室名称
     * @param invoiceQuantity 发票数量
     * @param regCost  挂号费
     * @param drugCost 处方费
     * @param inspectionCost 检查费
     * @param checkoutCost 检验费
     * @param handleCost 处置费
     * @param cost 金额
     */
    public Workload(Integer doctorId, String doctorName, Integer departmentId, String departmentName, Integer invoiceQuantity, BigDecimal regCost, BigDecimal drugCost, BigDecimal inspectionCost, BigDecimal checkoutCost, BigDecimal handleCost, BigDecimal cost) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.invoiceQuantity = invoiceQuantity;
        this.regCost = regCost;
        this.drugCost = drugCost;
        this.inspectionCost = inspectionCost;
        this.checkoutCost = checkoutCost;
        this.handleCost = handleCost;
        this.cost = cost;
    }

    /**
     * 构造方法
     * @param departmentName 科室名称
     */
    public Workload(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 构造方法
     * @param doctorName 医生姓名
     * @param departmentName 科室名称
     */
    public Workload(String doctorName, String departmentName) {
        this.doctorName = doctorName;
        this.departmentName = departmentName;
    }

    public Workload() {

    }

    public Integer getSeeQuantity() {
        return seeQuantity;
    }

    public void setSeeQuantity(Integer seeQuantity) {
        this.seeQuantity = seeQuantity;
    }

    public String getMedicalNo() {
        return medicalNo;
    }

    public void setMedicalNo(String medicalNo) {
        this.medicalNo = medicalNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Integer getInvoiceQuantity() {
        return invoiceQuantity;
    }

    public void setInvoiceQuantity(Integer invoiceQuantity) {
        this.invoiceQuantity = invoiceQuantity;
    }

    public BigDecimal getRegCost() {
        return regCost;
    }

    public void setRegCost(BigDecimal regCost) {
        this.regCost = regCost;
    }

    public BigDecimal getDrugCost() {
        return drugCost;
    }

    public void setDrugCost(BigDecimal drugCost) {
        this.drugCost = drugCost;
    }

    public BigDecimal getInspectionCost() {
        return inspectionCost;
    }

    public void setInspectionCost(BigDecimal inspectionCost) {
        this.inspectionCost = inspectionCost;
    }

    public BigDecimal getCheckoutCost() {
        return checkoutCost;
    }

    public void setCheckoutCost(BigDecimal checkoutCost) {
        this.checkoutCost = checkoutCost;
    }

    public BigDecimal getHandleCost() {
        return handleCost;
    }

    public void setHandleCost(BigDecimal handleCost) {
        this.handleCost = handleCost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Workload{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", invoiceQuantity=" + invoiceQuantity +
                ", seeQuantity=" + seeQuantity +
                ", patientName='" + patientName + '\'' +
                ", medicalNo='" + medicalNo + '\'' +
                ", regCost=" + regCost +
                ", drugCost=" + drugCost +
                ", inspectionCost=" + inspectionCost +
                ", checkoutCost=" + checkoutCost +
                ", handleCost=" + handleCost +
                ", cost=" + cost +
                '}';
    }
}
