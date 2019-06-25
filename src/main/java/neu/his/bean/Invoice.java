package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Invoice {
    private Integer id;

    private String invoiceNo;

    private String costType;

    private Integer costTypeId;

    private Integer settlementTypeId;

    private BigDecimal cost;

    private Date invoiceTime;

    private Integer tollCollectorId;

    private String patientName;

    private String status;

    private String itemName;

    private String medicalRecordNo;

    private String doctorName;

    private String executiveDepartmentName;

    private String drawBillDepartmentName;

    private String settlementTypeName;


    public Invoice(Integer id, String invoiceNo, String costType, Integer costTypeId, Integer settlementTypeId, BigDecimal cost, Date invoiceTime, Integer tollCollectorId, String patientName, String status, String itemName, String medicalRecordNo, String doctorName, String executiveDepartmentName, String drawBillDepartmentName) {
        this.id = id;
        this.invoiceNo = invoiceNo;
        this.costType = costType;
        this.costTypeId = costTypeId;
        this.settlementTypeId = settlementTypeId;
        this.cost = cost;
        this.invoiceTime = invoiceTime;
        this.tollCollectorId = tollCollectorId;
        this.patientName = patientName;
        this.status = status;
        this.itemName = itemName;
        this.medicalRecordNo = medicalRecordNo;
        this.doctorName = doctorName;
        this.executiveDepartmentName = executiveDepartmentName;
        this.drawBillDepartmentName = drawBillDepartmentName;
    }

    public String getSettlementTypeName() {
        return settlementTypeName;
    }

    public void setSettlementTypeName(String settlementTypeName) {
        this.settlementTypeName = settlementTypeName;
    }

    public Invoice() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType == null ? null : costType.trim();
    }

    public Integer getCostTypeId() {
        return costTypeId;
    }

    public void setCostTypeId(Integer costTypeId) {
        this.costTypeId = costTypeId;
    }

    public Integer getSettlementTypeId() {
        return settlementTypeId;
    }

    public void setSettlementTypeId(Integer settlementTypeId) {
        this.settlementTypeId = settlementTypeId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Date getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(Date invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public Integer getTollCollectorId() {
        return tollCollectorId;
    }

    public void setTollCollectorId(Integer tollCollectorId) {
        this.tollCollectorId = tollCollectorId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo == null ? null : medicalRecordNo.trim();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public String getExecutiveDepartmentName() {
        return executiveDepartmentName;
    }

    public void setExecutiveDepartmentName(String executiveDepartmentName) {
        this.executiveDepartmentName = executiveDepartmentName == null ? null : executiveDepartmentName.trim();
    }

    public String getDrawBillDepartmentName() {
        return drawBillDepartmentName;
    }

    public void setDrawBillDepartmentName(String drawBillDepartmentName) {
        this.drawBillDepartmentName = drawBillDepartmentName == null ? null : drawBillDepartmentName.trim();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", costType='" + costType + '\'' +
                ", costTypeId=" + costTypeId +
                ", settlementTypeId=" + settlementTypeId +
                ", cost=" + cost +
                ", invoiceTime=" + invoiceTime +
                ", tollCollectorId=" + tollCollectorId +
                ", patientName='" + patientName + '\'' +
                ", status='" + status + '\'' +
                ", itemName='" + itemName + '\'' +
                ", medicalRecordNo='" + medicalRecordNo + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", executiveDepartmentName='" + executiveDepartmentName + '\'' +
                ", drawBillDepartmentName='" + drawBillDepartmentName + '\'' +
                ", settlementTypeName='" + settlementTypeName + '\'' +
                '}';
    }
}