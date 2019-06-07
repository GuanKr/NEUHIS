package neu.his.bean;

import java.math.BigDecimal;

public class RegistrationLevel {
    private Integer id;

    private String code;

    private String levelName;

    private String isDefault;

    private BigDecimal registrationPrice;

    public RegistrationLevel(Integer id, String code, String levelName, String isDefault, BigDecimal registrationPrice) {
        this.id = id;
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