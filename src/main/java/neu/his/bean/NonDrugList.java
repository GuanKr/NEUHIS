package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;

public class NonDrugList {
    private Integer id;

    private String itemCode;

    private String itemName;

    private String format;

    private BigDecimal price;

    private Integer expenseClassId;

    private Integer executivedepartmentId;

    private String mnemonicCode;

    private String itemType;

    private Date creationTime;

    private String expenseClassName;

    private String executivedepartmentName;

    private String itemTypeName;

    public NonDrugList(Integer id, String itemCode, String itemName, String format, BigDecimal price, Integer expenseClassId, Integer executivedepartmentId, String mnemonicCode, String itemType, Date creationTime) {
        this.id = id;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.format = format;
        this.price = price;
        this.expenseClassId = expenseClassId;
        this.executivedepartmentId = executivedepartmentId;
        this.mnemonicCode = mnemonicCode;
        this.itemType = itemType;
        this.creationTime = creationTime;
    }

    public NonDrugList(Integer id, String itemCode, String itemName, String format, BigDecimal price, String mnemonicCode, Date creationTime, String expenseClassName, String executivedepartmentName, String itemTypeName) {
        this.id = id;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.format = format;
        this.price = price;
        this.mnemonicCode = mnemonicCode;
        this.creationTime = creationTime;
        this.expenseClassName = expenseClassName;
        this.executivedepartmentName = executivedepartmentName;
        this.itemTypeName = itemTypeName;
    }

    public NonDrugList(String itemCode, String itemName, String format, BigDecimal price, String mnemonicCode, Date creationTime, String expenseClassName, String executivedepartmentName, String itemTypeName) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.format = format;
        this.price = price;
        this.mnemonicCode = mnemonicCode;
        this.creationTime = creationTime;
        this.expenseClassName = expenseClassName;
        this.executivedepartmentName = executivedepartmentName;
        this.itemTypeName = itemTypeName;
    }

    public String getExpenseClassName() {
        return expenseClassName;
    }

    public void setExpenseClassName(String expenseClassName) {
        this.expenseClassName = expenseClassName;
    }

    public String getExecutivedepartmentName() {
        return executivedepartmentName;
    }

    public void setExecutivedepartmentName(String executivedepartmentName) {
        this.executivedepartmentName = executivedepartmentName;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public NonDrugList() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getExpenseClassId() {
        return expenseClassId;
    }

    public void setExpenseClassId(Integer expenseClassId) {
        this.expenseClassId = expenseClassId;
    }

    public Integer getExecutivedepartmentId() {
        return executivedepartmentId;
    }

    public void setExecutivedepartmentId(Integer executivedepartmentId) {
        this.executivedepartmentId = executivedepartmentId;
    }

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode == null ? null : mnemonicCode.trim();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "NonDrugList{" +
                "id=" + id +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", format='" + format + '\'' +
                ", price=" + price +
                ", expenseClassId=" + expenseClassId +
                ", executivedepartmentId=" + executivedepartmentId +
                ", mnemonicCode='" + mnemonicCode + '\'' +
                ", itemType='" + itemType + '\'' +
                ", creationTime=" + creationTime +
                ", expenseClassName='" + expenseClassName + '\'' +
                ", executivedepartmentName='" + executivedepartmentName + '\'' +
                ", itemTypeName='" + itemTypeName + '\'' +
                '}';
    }
}