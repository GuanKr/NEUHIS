package neu.his.bean;

public class SettlementType {
    private Integer id;

    private String settlementTypeName;

    /**
     *@Author:
     *@param: [id, settlementTypeName]
     * 主键id ，结算类型名称
     *@return:
     *@Description: 构造方法1
     */
    public SettlementType(Integer id, String settlementTypeName) {
        this.id = id;
        this.settlementTypeName = settlementTypeName;
    }

    /**
     *@Author:
     *@param: [settlementTypeName]
     * 结算类型名称
     *@return:
     *@Description: 构造方法2
     */
    public SettlementType(String settlementTypeName) {
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