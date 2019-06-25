package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CheckDay {
    private Integer id;

    private Integer tollCollectorId;

    private Date startTime;

    private Date endTime;

    private BigDecimal cost;

    private String approve;

    private Date checkDayTime;

    public CheckDay(Integer id, Integer tollCollectorId, Date startTime, Date endTime, BigDecimal cost, String approve, Date checkDayTime) {
        this.id = id;
        this.tollCollectorId = tollCollectorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
        this.approve = approve;
        this.checkDayTime = checkDayTime;
    }

    public CheckDay() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTollCollectorId() {
        return tollCollectorId;
    }

    public void setTollCollectorId(Integer tollCollectorId) {
        this.tollCollectorId = tollCollectorId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve == null ? null : approve.trim();
    }

    public Date getCheckDayTime() {
        return checkDayTime;
    }

    public void setCheckDayTime(Date checkDayTime) {
        this.checkDayTime = checkDayTime;
    }

    @Override
    public String toString() {
        return "CheckDay{" +
                "id=" + id +
                ", tollCollectorId=" + tollCollectorId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", cost=" + cost +
                ", approve='" + approve + '\'' +
                ", checkDayTime=" + checkDayTime +
                '}';
    }
}