package neu.his.dto;

import neu.his.bean.Drug;

import java.util.List;

public class DrugDTO {
    private List<Drug> drugList;

    public List<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<Drug> drugList) {
        this.drugList = drugList;
    }
}
