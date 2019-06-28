package neu.his.dto;

import neu.his.bean.DrugPrescription;

import java.util.List;

public class DrugPrescriptionDTO {
    private List<DrugPrescription> drugPrescriptionList;

    public List<DrugPrescription> getDrugPrescriptionList() {
        return drugPrescriptionList;
    }

    public void setDrugPrescriptionList(List<DrugPrescription> drugPrescriptionList) {
        this.drugPrescriptionList = drugPrescriptionList;
    }
}
