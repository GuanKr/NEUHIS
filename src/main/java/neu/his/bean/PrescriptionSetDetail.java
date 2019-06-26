package neu.his.bean;

import java.math.BigDecimal;
/**
 * 存储处方组套信息明细
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class PrescriptionSetDetail {
    /***
     * 主键id
     */
    private Integer id;

    /**
     * 处方组套id
     */
    private Integer prescriptionSetId;

    /**
     * 药品id
     */
    private Integer drugId;

    /**
     * 药品规格
     */
    private String drugFormat;

    /**
     * 药品用法
     */
    private String drugUsage;

    /**
     * 药品用量
     */
    private BigDecimal drugDosage;

    /**
     * 频次
     */
    private String frequency;

    /**
     * 药品名称
     */
    private String drugName;

    /**
     * 构造方法
     * @param id 主键id
     * @param prescriptionSetId 处方组套id
     * @param drugId 药品id
     * @param drugFormat 药品规格
     * @param drugUsage 药品用法
     * @param drugDosage 药品用量
     * @param frequency 频次
     */
    public PrescriptionSetDetail(Integer id, Integer prescriptionSetId, Integer drugId, String drugFormat, String drugUsage, BigDecimal drugDosage, String frequency) {
        this.id = id;
        this.prescriptionSetId = prescriptionSetId;
        this.drugId = drugId;
        this.drugFormat = drugFormat;
        this.drugUsage = drugUsage;
        this.drugDosage = drugDosage;
        this.frequency = frequency;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public PrescriptionSetDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrescriptionSetId() {
        return prescriptionSetId;
    }

    public void setPrescriptionSetId(Integer prescriptionSetId) {
        this.prescriptionSetId = prescriptionSetId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getDrugFormat() {
        return drugFormat;
    }

    public void setDrugFormat(String drugFormat) {
        this.drugFormat = drugFormat == null ? null : drugFormat.trim();
    }

    public String getDrugUsage() {
        return drugUsage;
    }

    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage == null ? null : drugUsage.trim();
    }

    public BigDecimal getDrugDosage() {
        return drugDosage;
    }

    public void setDrugDosage(BigDecimal drugDosage) {
        this.drugDosage = drugDosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    @Override
    public String toString() {
        return "PrescriptionSetDetail{" +
                "id=" + id +
                ", prescriptionSetId=" + prescriptionSetId +
                ", drugId=" + drugId +
                ", drugFormat='" + drugFormat + '\'' +
                ", drugUsage='" + drugUsage + '\'' +
                ", drugDosage=" + drugDosage +
                ", frequency='" + frequency + '\'' +
                ", drugName='" + drugName + '\'' +
                '}';
    }
}