package neu.his.bean;

import java.util.Date;

public class ScheduleInfo {
    private Integer id;

    private Integer userId;

    private Date schedulDate;

    private String bisessionalOperation;

    private Integer surplusQuota;

    public ScheduleInfo(Integer id, Integer userId, Date schedulDate, String bisessionalOperation, Integer surplusQuota) {
        this.id = id;
        this.userId = userId;
        this.schedulDate = schedulDate;
        this.bisessionalOperation = bisessionalOperation;
        this.surplusQuota = surplusQuota;
    }

    public ScheduleInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getSchedulDate() {
        return schedulDate;
    }

    public void setSchedulDate(Date schedulDate) {
        this.schedulDate = schedulDate;
    }

    public String getBisessionalOperation() {
        return bisessionalOperation;
    }

    public void setBisessionalOperation(String bisessionalOperation) {
        this.bisessionalOperation = bisessionalOperation == null ? null : bisessionalOperation.trim();
    }

    public Integer getSurplusQuota() {
        return surplusQuota;
    }

    public void setSurplusQuota(Integer surplusQuota) {
        this.surplusQuota = surplusQuota;
    }
}