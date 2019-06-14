package neu.his.bean;

import java.util.Date;

public class ScheduleInfo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 排班日期
     */
    private Date scheduleDate;
    /**
     *  午别
     */
    private String bisessionalOperation;
    /**
     * 剩余名额
     */
    private Integer surplusQuota;
    /**
     * 状态
     */
    private String status;
    /**
     * 排班限额
     */
    private Integer scheduleQuota;
    /**
     * 用户姓名
     */
    private String userName;

    private String department_name;

    private String registrationLevelName;

    private String statusName;

    /**
     * 构造方法1
     * @param id 主键id
     * @param userId 用户id
     * @param scheduleDate 排班日期
     * @param bisessionalOperation 午别
     * @param surplusQuota 剩余名额
     * @param status 状态
     * @param scheduleQuota 排班限额
     */

    public ScheduleInfo(Integer id, Integer userId, Date scheduleDate, String bisessionalOperation, Integer surplusQuota, String status, Integer scheduleQuota) {
        this.id = id;
        this.userId = userId;
        this.scheduleDate = scheduleDate;
        this.bisessionalOperation = bisessionalOperation;
        this.surplusQuota = surplusQuota;
        this.status = status;
        this.scheduleQuota = scheduleQuota;
    }

    /**
     * 构造方法2
     * @param userId 用户id
     * @param scheduleDate 排班日期
     * @param bisessionalOperation 午别
     * @param surplusQuota 剩余名额
     * @param status 状态
     * @param scheduleQuota 排班限额
     */
    public ScheduleInfo( Integer userId, Date scheduleDate, String bisessionalOperation, Integer surplusQuota, String status, Integer scheduleQuota) {
        this.userId = userId;
        this.scheduleDate = scheduleDate;
        this.bisessionalOperation = bisessionalOperation;
        this.surplusQuota = surplusQuota;
        this.status = status;
        this.scheduleQuota = scheduleQuota;
    }


    /**
     * 构造方法3
     * @param scheduleDate 排班日期
     * @param bisessionalOperation 午别
     * @param surplusQuota 剩余名额
     * @param status 状态
     * @param scheduleQuota 排班限额
     * @param userName 用户姓名
     */
    public ScheduleInfo(Date scheduleDate, String bisessionalOperation, Integer surplusQuota, String status, Integer scheduleQuota, String userName) {
        this.scheduleDate = scheduleDate;
        this.bisessionalOperation = bisessionalOperation;
        this.surplusQuota = surplusQuota;
        this.status = status;
        this.scheduleQuota = scheduleQuota;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getRegistrationLevelName() {
        return registrationLevelName;
    }

    public void setRegistrationLevelName(String registrationLevelName) {
        this.registrationLevelName = registrationLevelName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getScheduleQuota() {
        return scheduleQuota;
    }

    public void setScheduleQuota(Integer scheduleQuota) {
        this.scheduleQuota = scheduleQuota;
    }

    @Override
    public String toString() {
        return "ScheduleInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", scheduleDate=" + scheduleDate +
                ", bisessionalOperation='" + bisessionalOperation + '\'' +
                ", surplusQuota=" + surplusQuota +
                ", status='" + status + '\'' +
                ", scheduleQuota=" + scheduleQuota +
                ", userName='" + userName + '\'' +
                ", department_name='" + department_name + '\'' +
                ", registrationLevelName='" + registrationLevelName + '\'' +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}