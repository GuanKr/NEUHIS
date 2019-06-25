package neu.his.bean;

public class CheckDayDetail {
    private Integer id;

    private Integer checkDayId;

    private Integer invoiceId;

    public CheckDayDetail(Integer id, Integer checkDayId, Integer invoiceId) {
        this.id = id;
        this.checkDayId = checkDayId;
        this.invoiceId = invoiceId;
    }

    public CheckDayDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckDayId() {
        return checkDayId;
    }

    public void setCheckDayId(Integer checkDayId) {
        this.checkDayId = checkDayId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }
}