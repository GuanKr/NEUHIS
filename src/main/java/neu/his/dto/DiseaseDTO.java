package neu.his.dto;

import neu.his.bean.Disease;

import java.util.List;

public class DiseaseDTO {
    private List<Disease> diseases;

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }
}
