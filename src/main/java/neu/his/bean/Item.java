package neu.his.bean;

import java.math.BigDecimal;

public class Item {
    private String itemName;
    private String format;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal cost;
    private String departmentName;
    private String category;
    private Integer categoryId;
    private String doctorName;
    private String drawBillDepartmentName;

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
