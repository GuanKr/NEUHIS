package neu.his.bean;

public class SettlementType {
    private Integer id;

    private String settlementTypeName;

    public SettlementType(Integer id, String settlementTypeName) {
        this.id = id;
        this.settlementTypeName = settlementTypeName;
    }

    public SettlementType() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSettlementTypeName() {
        return settlementTypeName;
    }

    public void setSettlementTypeName(String settlementTypeName) {
        this.settlementTypeName = settlementTypeName == null ? null : settlementTypeName.trim();
    }
}