package neu.his.bean;

public class Disease {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 诊断目录id
     */
    private Integer diagnoseDirectoryId;
    /**
     * 国际ICD编码
     */
    private String internationalIcdCode;
    /**
     * 疾病名称
     */
    private String diseaseName;
    /**
     * 疾病助记编码
     */
    private String diseaseMnemonicCode;
    /**
     * 诊断目录名称
     */
    public String diagnoseDirectoryName;

    /**
     * 构造方法1
     * @param id 主键id
     * @param diagnoseDirectoryId 诊断目录id
     * @param internationalIcdCode 国际ICD编码
     * @param diseaseName 疾病名称
     * @param diseaseMnemonicCode 疾病助记编码
     */
    public Disease(Integer id, Integer diagnoseDirectoryId, String internationalIcdCode, String diseaseName, String diseaseMnemonicCode) {
        this.id = id;
        this.diagnoseDirectoryId = diagnoseDirectoryId;
        this.internationalIcdCode = internationalIcdCode;
        this.diseaseName = diseaseName;
        this.diseaseMnemonicCode = diseaseMnemonicCode;
    }

    /**
     * 构造方法2
     * @param id 主键id
     * @param internationalIcdCode 国际ICD编码
     * @param diseaseName 疾病名称
     * @param diseaseMnemonicCode 疾病助记编码
     * @param diagnoseDirectoryName 诊断目录名称
     */
    public Disease(Integer id, String internationalIcdCode, String diseaseName, String diseaseMnemonicCode, String diagnoseDirectoryName) {
        this.id = id;
        this.internationalIcdCode = internationalIcdCode;
        this.diseaseName = diseaseName;
        this.diseaseMnemonicCode = diseaseMnemonicCode;
        this.diagnoseDirectoryName = diagnoseDirectoryName;
    }

    /**
     * 构造方法3
     * @param internationalIcdCode 国际ICD编码
     * @param diseaseName 疾病名称
     * @param diseaseMnemonicCode 疾病助记编码
     * @param diagnoseDirectoryName 诊断目录名称
     */
    public Disease(String internationalIcdCode, String diseaseName,String diseaseMnemonicCode, String diagnoseDirectoryName) {
        this.internationalIcdCode = internationalIcdCode;
        this.diseaseName = diseaseName;
        this.diseaseMnemonicCode = diseaseMnemonicCode;
        this.diagnoseDirectoryName = diagnoseDirectoryName;
    }

    public String getDiagnoseDirectoryName() {
        return diagnoseDirectoryName;
    }

    public void setDiagnoseDirectoryName(String diagnoseDirectoryName) {
        this.diagnoseDirectoryName = diagnoseDirectoryName;
    }

    public Disease() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiagnoseDirectoryId() {
        return diagnoseDirectoryId;
    }

    public void setDiagnoseDirectoryId(Integer diagnoseDirectoryId) {
        this.diagnoseDirectoryId = diagnoseDirectoryId;
    }

    public String getInternationalIcdCode() {
        return internationalIcdCode;
    }

    public void setInternationalIcdCode(String internationalIcdCode) {
        this.internationalIcdCode = internationalIcdCode == null ? null : internationalIcdCode.trim();
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName == null ? null : diseaseName.trim();
    }

    public String getDiseaseMnemonicCode() {
        return diseaseMnemonicCode;
    }

    public void setDiseaseMnemonicCode(String diseaseMnemonicCode) {
        this.diseaseMnemonicCode = diseaseMnemonicCode == null ? null : diseaseMnemonicCode.trim();
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", diagnoseDirectoryId=" + diagnoseDirectoryId +
                ", internationalIcdCode='" + internationalIcdCode + '\'' +
                ", diseaseName='" + diseaseName + '\'' +
                ", diseaseMnemonicCode='" + diseaseMnemonicCode + '\'' +
                ", diagnoseDirectoryName='" + diagnoseDirectoryName + '\'' +
                '}';
    }
}