package neu.his.bean;

import java.math.BigDecimal;
/**
 * 存储检查/检验/处置组套详细信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class InspectionSetDetail {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 组套id
     */
    private Integer inspectionSetId;

    /**
     * 非药品id
     */
    private Integer nonDrugListId;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 项目编码
     */
    private String itemCode;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 构造方法
     * @param id 主键id
     * @param inspectionSetId 组套id
     * @param nonDrugListId 非药品id
     */
    public InspectionSetDetail(Integer id, Integer inspectionSetId, Integer nonDrugListId) {
        this.id = id;
        this.inspectionSetId = inspectionSetId;
        this.nonDrugListId = nonDrugListId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public InspectionSetDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInspectionSetId() {
        return inspectionSetId;
    }

    public void setInspectionSetId(Integer inspectionSetId) {
        this.inspectionSetId = inspectionSetId;
    }

    public Integer getNonDrugListId() {
        return nonDrugListId;
    }

    public void setNonDrugListId(Integer nonDrugListId) {
        this.nonDrugListId = nonDrugListId;
    }

    @Override
    public String toString() {
        return "InspectionSetDetail{" +
                "id=" + id +
                ", inspectionSetId=" + inspectionSetId +
                ", nonDrugListId=" + nonDrugListId +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}