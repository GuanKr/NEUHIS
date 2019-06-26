package neu.his.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 存储非药品目录信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class NonDrugList {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 项目编码
     */
    private String itemCode;
    /**
     * 项目名称
     */
    private String itemName;
    /**
     * 规格
     */
    private String format;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 所属费用科目id
     */
    private Integer expenseClassId;
    /**
     * 执行科室id
     */
    private Integer executivedepartmentId;
    /**
     * 拼音助记码
     */
    private String mnemonicCode;
    /**
     * 项目类型
     */
    private String itemType;
    /**
     * 创建时间
     */
    private Date creationTime;
    /**
     * 所属费用科目名称
     */
    private String expenseClassName;
    /**
     * 执行科室名称
     */
    private String executivedepartmentName;
    /**
     * 项目类型名称
     */
    private String itemTypeName;

    private String creationdateString;


    /**
     * 构造方法1
     * @param id 主键id
     * @param itemCode 项目编码
     * @param itemName 项目名称
     * @param format 规格
     * @param price 单价
     * @param expenseClassId 所属费用科目id
     * @param executivedepartmentId 执行科室id
     * @param mnemonicCode 拼音助记码
     * @param itemType 项目类型
     * @param creationTime 创建时间
     */
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

    /**
     * 构造方法2
     * @param id 主键id
     * @param itemCode 项目编码
     * @param itemName 项目名称
     * @param format 规格
     * @param price 单价
     * @param mnemonicCode 拼音助记码
     * @param creationTime 创建时间
     * @param expenseClassName 所属费用科目名称
     * @param executivedepartmentName 执行科室名称
     * @param itemTypeName 项目类型名称
     */
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

    /**
     * 构造方法2
     * @param itemCode 项目编码
     * @param itemName 项目名称
     * @param format 规格
     * @param price 单价
     * @param mnemonicCode 拼音助记码
     * @param creationTime 创建时间
     * @param expenseClassName 所属费用科目名称
     * @param executivedepartmentName 执行科室名称
     * @param itemTypeName 项目类型名称
     */
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

    public String getCreationdateString() {
        return creationdateString;
    }

    public void setCreationdateString(String creationdateString) {
        this.creationdateString = creationdateString;
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