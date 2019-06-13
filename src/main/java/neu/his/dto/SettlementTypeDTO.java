package neu.his.dto;

import neu.his.bean.SettlementType;

import java.util.List;

public class SettlementTypeDTO {
    private List<SettlementType>  settlementTypes;

    public List<SettlementType> getSettlementTypes() {
        return settlementTypes;
    }

    public void setSettlementTypes(List<SettlementType> settlementTypes) {
        this.settlementTypes = settlementTypes;
    }
}
