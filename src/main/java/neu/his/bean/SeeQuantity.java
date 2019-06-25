package neu.his.bean;

import java.util.Date;

public class SeeQuantity {
    private Date startTime;
    private Date endTime;
    private String departmentName;

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
