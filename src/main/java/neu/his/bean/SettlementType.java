package neu.his.bean;
/**
 * 存储结算类别信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class SettlementType {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 结算类型名称
     */
    private String settlementTypeName;

    /**
     *构造方法1
     *@param id 主键id
     *@param settlementTypeName 结算类型名称
     */
    public SettlementType(Integer id, String settlementTypeName) {
        this.id = id;
        this.settlementTypeName = settlementTypeName;
    }

    /**
     *构造方法2
     *@param settlementTypeName 结算类型名称
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