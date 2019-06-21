package neu.his.bean;

public class DrugCommon {
    private Integer id;

    private String drugName;

    private Integer doctorId;

    private String drugFormat;

    public DrugCommon(Integer id, String drugName, Integer doctorId, String drugFormat) {
        this.id = id;
        this.drugName = drugName;
        this.doctorId = doctorId;
        this.drugFormat = drugFormat;
    }

    public DrugCommon() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDrugFormat() {
        return drugFormat;
    }

    public void setDrugFormat(String drugFormat) {
        this.drugFormat = drugFormat == null ? null : drugFormat.trim();
    }
}