package neu.his.bean;

import java.math.BigDecimal;

/**
 * 存储缴费项目信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class Item {
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
    private BigDecimal unitPrice;
    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 金额
     */
    private BigDecimal cost;
    /**
     * 执行科室名称
     */
    private String departmentName;
    /**
     * 类别
     */
    private String category;
    /**
     * 属于的类别的id
     */
    private Integer categoryId;
    /**
     * 医生姓名
     */
    private String doctorName;
    /**
     * 开立科室名称
     */
    private String drawBillDepartmentName;

    /**
     * 构造方法
     * @param itemName 项目名称
     * @param format 规格
     * @param unitPrice 单价
     * @param quantity 数量
     * @param cost 金额
     * @param departmentName 执行科室名称
     */
    public Item(String itemName, String format, BigDecimal unitPrice, Integer quantity, BigDecimal cost, String departmentName) {
        this.itemName = itemName;
        this.format = format;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.cost = cost;
        this.departmentName = departmentName;
    }

    public Item() {
        super();
    }

    public String getDrawBillDepartmentName() {
        return drawBillDepartmentName;
    }

    public void setDrawBillDepartmentName(String drawBillDepartmentName) {
        this.drawBillDepartmentName = drawBillDepartmentName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", format='" + format + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", cost=" + cost +
                ", departmentName='" + departmentName + '\'' +
                ", category='" + category + '\'' +
                ", categoryId=" + categoryId +
                ", doctorName='" + doctorName + '\'' +
                ", drawBillDepartmentName='" + drawBillDepartmentName + '\'' +
                '}';
    }
}
