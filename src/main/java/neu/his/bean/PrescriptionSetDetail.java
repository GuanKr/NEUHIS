package neu.his.bean;

import java.math.BigDecimal;

public class PrescriptionSetDetail {
    private Integer id;

    private Integer prescriptionSetId;

    private Integer drugId;

    private String drugFormat;

    private String drugUsage;

    private BigDecimal drugDosage;

    private String frequency;

    private String drugName;

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