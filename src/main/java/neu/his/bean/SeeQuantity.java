package neu.his.bean;

import java.util.Date;

/**
 * 封装查询看诊数量的信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class SeeQuantity {
    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 截止时间
     */
    private Date endTime;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 构造方法
     * @param startTime 开始时间
     * @param endTime 截止时间
     * @param departmentName 科室名称
     */
    public SeeQuantity(Date startTime, Date endTime, String departmentName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.departmentName = departmentName;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
