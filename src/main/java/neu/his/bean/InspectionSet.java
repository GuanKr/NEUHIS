package neu.his.bean;

import java.util.Date;

public class InspectionSet {
    private Integer id;

    private Integer doctorId;

    private String combinatorialCode;

    private String combinatorialName;

    private String category;

    private String requirement;

    private Date createTime;

    private String doctorName;

    public InspectionSet(Integer id, Integer doctorId, String combinatorialCode, String combinatorialName, String category, String requirement, Date createTime) {
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

    public InspectionSet() {
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
        return "InspectionSet{" +
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