package neu.his.bean;
/**
 * 存储诊断目录信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class DiagnoseDirectory {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 分类编码
     */
    private String diseaseCategoryCode;
    /**
     * 分类名称
     */
    private String diseaseCategoryName;
    /**
     * 显示顺序号
     */
    private Integer sequenceNo;
    /**
     * 疾病类型
     */
    private String diseaseType;
    /**
     * 疾病类型名称
     */
    private String deseaseTypeName;

    /**
     * 构造方法1
     * @param id 主键id
     * @param diseaseCategoryCode 分类编码
     * @param diseaseCategoryName 分类名称
     * @param sequenceNo 显示顺序号
     * @param diseaseType 疾病类型
     */
       public DiagnoseDirectory(Integer id, String diseaseCategoryCode, String diseaseCategoryName, Integer sequenceNo, String diseaseType) {
        this.id = id;
        this.diseaseCategoryCode = diseaseCategoryCode;
        this.diseaseCategoryName = diseaseCategoryName;
        this.sequenceNo = sequenceNo;
        this.diseaseType = diseaseType;
    }

    /**
     * 构造方法2
     * @param id 主键id
     * @param diseaseCategoryCode 分类编码
     * @param diseaseCategoryName 分类名称
     * @param sequenceNo 显示顺序号
     * @param deseaseTypeName 疾病类型名称
     */
        public DiagnoseDirectory(String diseaseCategoryCode, Integer id, String diseaseCategoryName, Integer sequenceNo, String deseaseTypeName) {
        this.diseaseCategoryCode = diseaseCategoryCode;
        this.diseaseCategoryName = diseaseCategoryName;
        this.sequenceNo = sequenceNo;
        this.deseaseTypeName = deseaseTypeName;
    }

    /**
     * 构造方法3
     * @param diseaseCategoryCode 分类编码
     * @param diseaseCategoryName 分类名称
     * @param sequenceNo 显示顺序号
     * @param deseaseTypeName 疾病类型名称
     */
    public DiagnoseDirectory(String diseaseCategoryCode, String diseaseCategoryName, Integer sequenceNo, String deseaseTypeName) {
        this.diseaseCategoryCode = diseaseCategoryCode;
        this.diseaseCategoryName = diseaseCategoryName;
        this.sequenceNo = sequenceNo;
        this.deseaseTypeName = deseaseTypeName;
    }

    public String getDeseaseTypeName() {
        return deseaseTypeName;
    }

    public void setDeseaseTypeName(String deseaseTypeName) {
        this.deseaseTypeName = deseaseTypeName;
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
                ", deseaseTypeName='" + deseaseTypeName + '\'' +
                '}';
    }
}