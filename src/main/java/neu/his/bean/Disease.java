package neu.his.bean;

public class Disease {
    private Integer id;

    private Integer diagnoseDirectoryId;

    private String internationalIcdCode;

    private String diseaseName;

    private String diseaseMnemonicCode;

    public String diagnoseDirectoryName;

    /**
     *@param: [id, diagnoseDirectoryId, internationalIcdCode, diseaseName, diseaseMnemonicCode]
     * 主键id ，诊断目录id，国际ICD编码，疾病名称，疾病助记编码
     *@return:
     *@Description: 构造方法1
     */
    public Disease(Integer id, Integer diagnoseDirectoryId, String internationalIcdCode, String diseaseName, String diseaseMnemonicCode) {
        this.id = id;
        this.diagnoseDirectoryId = diagnoseDirectoryId;
        this.internationalIcdCode = internationalIcdCode;
        this.diseaseName = diseaseName;
        this.diseaseMnemonicCode = diseaseMnemonicCode;
    }

    /**
     *@param: [id, internationalIcdCode, diseaseName, diseaseMnemonicCode, diagnoseDirectoryName]
     * 主键id ，国际ICD编码，疾病名称，疾病助记编码，诊断目录名称
     *@return:
     *@Description: 构造方法2
     */

    public Disease(Integer id, String internationalIcdCode, String diseaseName, String diseaseMnemonicCode, String diagnoseDirectoryName) {
        this.id = id;
        this.internationalIcdCode = internationalIcdCode;
        this.diseaseName = diseaseName;
        this.diseaseMnemonicCode = diseaseMnemonicCode;
        this.diagnoseDirectoryName = diagnoseDirectoryName;
    }

    /**
     *@Author
     *@param: [internationalIcdCode, diseaseName, diseaseMnemonicCode, diagnoseDirectoryName]
     * 国际ICD编码，疾病名称，疾病助记编码，诊断目录名称
     *@return:
     *@Description: 构造方法3
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