package neu.his.bean;

public class InspectionSetDetail {
    private Integer id;

    private Integer inspectionSetId;

    private Integer nonDrugListId;

    private String itemName;

    public InspectionSetDetail(Integer id, Integer inspectionSetId, Integer nonDrugListId) {
        this.id = id;
        this.inspectionSetId = inspectionSetId;
        this.nonDrugListId = nonDrugListId;
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