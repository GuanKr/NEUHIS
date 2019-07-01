package neu.his.dto;

import neu.his.bean.DrugPrescription;

import java.util.List;

public class DrugPrescriptionDTO {
    private List<DrugPrescription> drugPrescriptions;

    public List<DrugPrescription> getDrugPrescription() {
        return drugPrescriptions;
    }

    public void setDrugPrescription(List<DrugPrescription> drugPrescription) {
        this.drugPrescriptions = drugPrescription;
    }
}
