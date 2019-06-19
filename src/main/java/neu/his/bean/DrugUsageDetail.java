package neu.his.bean;

public class DrugUsageDetail {
    private Integer id;

    private String drugUsage;

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