package neu.his.bean;
/**
 * 存储排班规则信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class ScheduleRule {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 星期
     */
    private String week;
    /**
     * 午别
     */
    private String bisessionalOperation;
    /**
     * 排班限额
     */
    private Integer schedulQuota;
    /**
     * 状态
     */
    private String status;
    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 科室名称
     */
    private String department_name;

    /**
     * 挂号级别名称
     */
    private String registrationLevelName;

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 构造方法1
     * @param id 主键id
     * @param userId 用户id
     * @param week 星期
     * @param bisessionalOperation 午别
     * @param schedulQuota 排班限额
     * @param status 状态
     */
    public ScheduleRule(Integer id, Integer userId, String week, String bisessionalOperation, Integer schedulQuota, String status) {
        this.id = id;
        this.userId = userId;
        this.week = week;
        this.bisessionalOperation = bisessionalOperation;
        this.schedulQuota = schedulQuota;
        this.status = status;
    }

    /**
     * 构造方法3
     * @param id 主键
     * @param week 星期
     * @param bisessionalOperation 午别
     * @param schedulQuota 限额
     * @param statusName 状态名
     */
    public ScheduleRule(Integer id, String week, String bisessionalOperation, Integer schedulQuota, String statusName) {
        this.id = id;
        this.week = week;
        this.bisessionalOperation = bisessionalOperation;
        this.schedulQuota = schedulQuota;
        this.statusName = statusName;
    }

    /**
     * 构造方法2
     * @param week 星期
     * @param bisessionalOperation 午别
     * @param schedulQuota 排班限额
     * @param status 状态
     * @param userName 用户姓名
     */
    public ScheduleRule(String week, String bisessionalOperation, Integer schedulQuota, String status, String userName) {
        this.week = week;
        this.bisessionalOperation = bisessionalOperation;
        this.schedulQuota = schedulQuota;
        this.status = status;
        this.userName = userName;
    }

    /**
     * 构造方法，用于挂号时返回医生列表
     * @param department_name 科室名称
     * @param registrationLevelName 挂号级别名称
     */
    public ScheduleRule(String department_name, String registrationLevelName) {
        this.department_name = department_name;
        this.registrationLevelName = registrationLevelName;
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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        return "ScheduleRule{" +
                "id=" + id +
                ", userId=" + userId +
                ", week='" + week + '\'' +
                ", bisessionalOperation='" + bisessionalOperation + '\'' +
                ", schedulQuota=" + schedulQuota +
                ", status='" + status + '\'' +
                ", userName='" + userName + '\'' +
                ", department_name='" + department_name + '\'' +
                ", registrationLevelName='" + registrationLevelName + '\'' +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}