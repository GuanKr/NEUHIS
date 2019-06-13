package neu.his.bean;

import java.math.BigDecimal;

public class RegistrationLevel {
    private Integer id;

    private String code;

    private String levelName;

    private String isDefault;

    private BigDecimal registrationPrice;

    /**
     *@Author: dell on 2019/6/13 16:25
     *@param: [id, code, levelName, isDefault, registrationPrice]
     * 主键id，号别编码，号别名称，是否默认，挂号费
     *@return:
     *@Description: 构造方法1
     */
    public RegistrationLevel(Integer id, String code, String levelName, String isDefault, BigDecimal registrationPrice) {
        this.id = id;
        this.code = code;
        this.levelName = levelName;
        this.isDefault = isDefault;
        this.registrationPrice = registrationPrice;
    }

    /**
     *@Author:
     *@param: [code, levelName, isDefault, registrationPrice]
     * 号别编码，号别名称，是否默认，挂号费
     *@return:
     *@Description: 构造方法2
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