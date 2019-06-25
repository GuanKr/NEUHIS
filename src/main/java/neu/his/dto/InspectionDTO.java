package neu.his.dto;

import neu.his.bean.Inspection;

import java.util.List;

public class InspectionDTO {
    private List<Inspection> inspections;

    public List<Inspection> getInspections() {
        return inspections;
    }

    public void setInspections(List<Inspection> inspections) {
        this.inspections = inspections;
    }
}
