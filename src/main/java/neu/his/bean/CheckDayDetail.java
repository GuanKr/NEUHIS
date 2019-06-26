package neu.his.bean;
/**
 * 存储日结详细信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class CheckDayDetail {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 日结id
     */
    private Integer checkDayId;

    /**
     * 发票信息id
     */
    private Integer invoiceId;

    /**
     * 构造方法
     * @param id 主键id
     * @param checkDayId 日结信息id
     * @param invoiceId 发票信息id
     */
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