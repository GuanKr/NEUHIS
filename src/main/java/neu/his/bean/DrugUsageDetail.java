package neu.his.bean;
/**
 * 存储药品用法
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class DrugUsageDetail {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 药品用法
     */
    private String drugUsage;

    /**
     * 构造方法：创建药品用法
     * @param id 主键id
     * @param drugUsage 药品用法
     */
    public DrugUsageDetail(Integer id, String drugUsage) {
        this.id = id;
        this.drugUsage = drugUsage;
    }

    public DrugUsageDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugUsage() {
        return drugUsage;
    }

    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage == null ? null : drugUsage.trim();
    }
}