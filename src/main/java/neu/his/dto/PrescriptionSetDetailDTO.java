package neu.his.dto;

import neu.his.bean.PrescriptionSetDetail;

import java.util.List;

public class PrescriptionSetDetailDTO {
    private List<PrescriptionSetDetail> prescriptionSetDetailList;

    public List<PrescriptionSetDetail> getPrescriptionSetDetailList() {
        return prescriptionSetDetailList;
    }

    public void setPrescriptionSetDetailList(List<PrescriptionSetDetail> prescriptionSetDetailList) {
        this.prescriptionSetDetailList = prescriptionSetDetailList;
    }
}
