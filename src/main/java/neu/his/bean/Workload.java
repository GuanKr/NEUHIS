package neu.his.bean;

import java.math.BigDecimal;

public class Workload {
    private Integer doctorId;
    private String doctorName;
    private Integer departmentId;
    private String departmentName;
    private Integer invoiceQuantity;
    private Integer seeQuantity;
    private String patientName;
    private String medicalNo;
    private BigDecimal regCost;
    private BigDecimal drugCost;
    private BigDecimal inspectionCost;
    private BigDecimal checkoutCost;
    private BigDecimal handleCost;
    private BigDecimal cost;

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

    public Workload(String departmentName) {
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
