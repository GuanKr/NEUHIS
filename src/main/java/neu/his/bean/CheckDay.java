package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 存储日结信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class CheckDay {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 收费员id
     */
    private Integer tollCollectorId;

    /**
     * 日结开始时间
     */
    private Date startTime;

    /**
     * 日结结束时间
     */
    private Date endTime;

    /**
     * 金额
     */
    private BigDecimal cost;

    /**
     * 核对标志
     */
    private String approve;

    /**
     * 日结时间
     */
    private Date checkDayTime;

    /**
     * 构造方法
     * @param id 主键id
     * @param tollCollectorId 收费员id
     * @param startTime 日结开始时间
     * @param endTime 日结结束时间
     * @param cost 金额
     * @param approve 核对标志
     * @param checkDayTime 日结时间
     */
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