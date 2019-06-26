package neu.his.bean;

/**
 * 存储常用药品信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class DrugCommon {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 药品名称
     */
    private String drugName;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 药品规格
     */
    private String drugFormat;

    /**
     * 构造方法
     * @param id 主键id
     * @param drugName 药品名称
     * @param doctorId 医生id
     * @param drugFormat 药品规格
     */
    public DrugCommon(Integer id, String drugName, Integer doctorId, String drugFormat) {
        this.id = id;
        this.drugName = drugName;
        this.doctorId = doctorId;
        this.drugFormat = drugFormat;
    }

    public DrugCommon() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDrugFormat() {
        return drugFormat;
    }

    public void setDrugFormat(String drugFormat) {
        this.drugFormat = drugFormat == null ? null : drugFormat.trim();
    }
}