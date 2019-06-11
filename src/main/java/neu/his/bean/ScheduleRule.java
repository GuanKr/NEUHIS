package neu.his.bean;

import java.util.Date;

public class ScheduleRule {
    private Integer id;

    private Integer userId;

    private Date time;

    private String bisessionalOperation;

    private Integer schedulQuota;

    public ScheduleRule(Integer id, Integer userId, Date time, String bisessionalOperation, Integer schedulQuota) {
        this.id = id;
        this.userId = userId;
        this.time = time;
        this.bisessionalOperation = bisessionalOperation;
        this.schedulQuota = schedulQuota;
    }

    public ScheduleRule() {
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getBisessionalOperation() {
        return bisessionalOperation;
    }

    public void setBisessionalOperation(String bisessionalOperation) {
        this.bisessionalOperation = bisessionalOperation == null ? null : bisessionalOperation.trim();
    }

    public Integer getSchedulQuota() {
        return schedulQuota;
    }

    public void setSchedulQuota(Integer schedulQuota) {
        this.schedulQuota = schedulQuota;
    }
}