package neu.his.bean;

import java.math.BigDecimal;
/**
 * 存储药品信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class Drug {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 药品编码
     */
    private String drugCode;

    /**
     * 药品名称
     */
    private String drugName;

    /**
     * 药品规格
     */
    private String drugFormat;

    /**
     * 包装单位
     */
    private String drugUnit;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 药品剂型
     */
    private String drugDosage;

    /**
     * 药品类型
     */
    private String drugType;

    /**
     * 药品单价
     */
    private BigDecimal drugPrice;

    /**
     * 拼音助记码
     */
    private String mnemonicCode;

    /**
     * 构造方法
     * @param id 主键id
     * @param drugCode 药品编码
     * @param drugName 药品名称
     * @param drugFormat 药品规格
     * @param drugUnit 包装单位
     * @param manufacturer 生产厂家
     * @param drugDosage 药品剂型
     * @param drugType 药品类型
     * @param drugPrice 药品单价
     * @param mnemonicCode 拼音助记码
     */
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