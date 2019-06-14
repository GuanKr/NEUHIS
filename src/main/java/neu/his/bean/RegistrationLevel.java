package neu.his.bean;

import java.math.BigDecimal;

public class RegistrationLevel {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 号别编码
     */
    private String code;
    /**
     * 号别名称
     */
    private String levelName;
    /**
     * 是否默认
     */
    private String isDefault;
    /**
     * 挂号费
     */
    private BigDecimal registrationPrice;

    /**
     *构造方法1
     *@param id 主键id
     *@param code 号别编码
     *@param levelName 号别名称
     *@param isDefault 是否默认
     *@param registrationPrice 挂号费
     */
    public RegistrationLevel(Integer id, String code, String levelName, String isDefault, BigDecimal registrationPrice) {
        this.id = id;
        this.code = code;
        this.levelName = levelName;
        this.isDefault = isDefault;
        this.registrationPrice = registrationPrice;
    }

    /**
     *构造方法2
     *@param code 号别编码
     *@param levelName 号别名称
     *@param isDefault 是否默认
     *@param registrationPrice 挂号费
     */
    public RegistrationLevel(String code, String levelName, String isDefault, BigDecimal registrationPrice) {
        this.code = code;
        this.levelName = levelName;
        this.isDefault = isDefault;
        this.registrationPrice = registrationPrice;
    }

    public RegistrationLevel() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public BigDecimal getRegistrationPrice() {
        return registrationPrice;
    }

    public void setRegistrationPrice(BigDecimal registrationPrice) {
        this.registrationPrice = registrationPrice;
    }
}