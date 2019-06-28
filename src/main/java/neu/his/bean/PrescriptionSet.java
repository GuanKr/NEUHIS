package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 存储处方组套
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class PrescriptionSet {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 组合编码
     */
    private String combinatorialCode;

    /**
     * 组合名称
     */
    private String combinatorialName;

    /**
     * 类别
     */
    private String category;

    /**
     * 目的和要求
     */
    private String requirement;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 医生姓名
     */
    private String doctorName;




    /**
     * 构造方法
     * @param id 主键id
     * @param doctorId 医生id
     * @param combinatorialCode 组合编码
     * @param combinatorialName 组合名称
     * @param category 类别
     * @param requirement 目的和要求
     * @param createTime 创建时间
     */
    public PrescriptionSet(Integer id, Integer doctorId, String combinatorialCode, String combinatorialName, String category, String requirement, Date createTime) {
        this.id = id;
        this.doctorId = doctorId;
        this.combinatorialCode = combinatorialCode;
        this.combinatorialName = combinatorialName;
        this.category = category;
        this.requirement = requirement;
        this.createTime = createTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public PrescriptionSet() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getCombinatorialCode() {
        return combinatorialCode;
    }

    public void setCombinatorialCode(String combinatorialCode) {
        this.combinatorialCode = combinatorialCode == null ? null : combinatorialCode.trim();
    }

    public String getCombinatorialName() {
        return combinatorialName;
    }

    public void setCombinatorialName(String combinatorialName) {
        this.combinatorialName = combinatorialName == null ? null : combinatorialName.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PrescriptionSet{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", combinatorialCode='" + combinatorialCode + '\'' +
                ", combinatorialName='" + combinatorialName + '\'' +
                ", category='" + category + '\'' +
                ", requirement='" + requirement + '\'' +
                ", createTime=" + createTime +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}