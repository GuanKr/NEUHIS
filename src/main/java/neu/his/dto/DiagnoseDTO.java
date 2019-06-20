package neu.his.dto;

import neu.his.bean.Diagnose;

import java.util.List;

public class DiagnoseDTO {
    private List<Diagnose> diagnoses;

    public List<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
