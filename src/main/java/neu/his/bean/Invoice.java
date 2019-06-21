package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Invoice {
    private Integer id;

    private String invoiceNo;

    private String costType;

    private Integer costTypeId;

    private Integer settlementTypeId;

    private BigDecimal receivable;

    private BigDecimal netReceipt;

    private BigDecimal chnge;

    private Date invoiceTime;

    private Integer tollCollectorId;

    public Invoice(Integer id, String invoiceNo, String costType, Integer costTypeId, Integer settlementTypeId, BigDecimal receivable, BigDecimal netReceipt, BigDecimal chnge, Date invoiceTime, Integer tollCollectorId) {
        this.id = id;
        this.invoiceNo = invoiceNo;
        this.costType = costType;
        this.costTypeId = costTypeId;
        this.settlementTypeId = settlementTypeId;
        this.receivable = receivable;
        this.netReceipt = netReceipt;
        this.chnge = chnge;
        this.invoiceTime = invoiceTime;
        this.tollCollectorId = tollCollectorId;
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

    public BigDecimal getReceivable() {
        return receivable;
    }

    public void setReceivable(BigDecimal receivable) {
        this.receivable = receivable;
    }

    public BigDecimal getNetReceipt() {
        return netReceipt;
    }

    public void setNetReceipt(BigDecimal netReceipt) {
        this.netReceipt = netReceipt;
    }

    public BigDecimal getChnge() {
        return chnge;
    }

    public void setChnge(BigDecimal chnge) {
        this.chnge = chnge;
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
}