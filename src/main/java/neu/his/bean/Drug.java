package neu.his.bean;

import java.math.BigDecimal;

public class Drug {
    private Integer id;

    private String drugCode;

    private String drugName;

    private String drugFormat;

    private String drugUnit;

    private String manufacturer;

    private String drugDosage;

    private String drugType;

    private BigDecimal drugPrice;

    private String mnemonicCode;

    public Drug(Integer id, String drugCode, String drugName, String drugFormat, String drugUnit, String manufacturer, String drugDosage, String drugType, BigDecimal drugPrice, String mnemonicCode) {
        this.id = id;
        this.drugCode = drugCode;
        this.drugName = drugName;
        this.drugFormat = drugFormat;
        this.drugUnit = drugUnit;
        this.manufacturer = manufacturer;
        this.drugDosage = drugDosage;
        this.drugType = drugType;
        this.drugPrice = drugPrice;
        this.mnemonicCode = mnemonicCode;
    }

    public Drug() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode == null ? null : drugCode.trim();
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public String getDrugFormat() {
        return drugFormat;
    }

    public void setDrugFormat(String drugFormat) {
        this.drugFormat = drugFormat == null ? null : drugFormat.trim();
    }

    public String getDrugUnit() {
        return drugUnit;
    }

    public void setDrugUnit(String drugUnit) {
        this.drugUnit = drugUnit == null ? null : drugUnit.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getDrugDosage() {
        return drugDosage;
    }

    public void setDrugDosage(String drugDosage) {
        this.drugDosage = drugDosage == null ? null : drugDosage.trim();
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType == null ? null : drugType.trim();
    }

    public BigDecimal getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(BigDecimal drugPrice) {
        this.drugPrice = drugPrice;
    }

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode == null ? null : mnemonicCode.trim();
    }
}