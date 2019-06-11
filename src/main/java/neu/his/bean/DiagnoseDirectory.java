package neu.his.bean;

public class DiagnoseDirectory {
    private Integer id;

    private String diseaseCategoryCode;

    private String diseaseCategoryName;

    private Integer sequenceNo;

    private String diseaseType;

    public DiagnoseDirectory(Integer id, String diseaseCategoryCode, String diseaseCategoryName, Integer sequenceNo, String diseaseType) {
        this.id = id;
        this.diseaseCategoryCode = diseaseCategoryCode;
        this.diseaseCategoryName = diseaseCategoryName;
        this.sequenceNo = sequenceNo;
        this.diseaseType = diseaseType;
    }

    public DiagnoseDirectory() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiseaseCategoryCode() {
        return diseaseCategoryCode;
    }

    public void setDiseaseCategoryCode(String diseaseCategoryCode) {
        this.diseaseCategoryCode = diseaseCategoryCode == null ? null : diseaseCategoryCode.trim();
    }

    public String getDiseaseCategoryName() {
        return diseaseCategoryName;
    }

    public void setDiseaseCategoryName(String diseaseCategoryName) {
        this.diseaseCategoryName = diseaseCategoryName == null ? null : diseaseCategoryName.trim();
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType == null ? null : diseaseType.trim();
    }

    @Override
    public String toString() {
        return "DiagnoseDirectory{" +
                "id=" + id +
                ", diseaseCategoryCode='" + diseaseCategoryCode + '\'' +
                ", diseaseCategoryName='" + diseaseCategoryName + '\'' +
                ", sequenceNo=" + sequenceNo +
                ", diseaseType='" + diseaseType + '\'' +
                '}';
    }
}