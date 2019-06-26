package neu.his.bean;
/**
 * 疾病查询信息封装
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class DiseaseQuery {
    /**
     * 诊断目录名称
     */
    private String directory_name;

    /**
     * 属性名称
     */
    private String attribute_name;

    /**
     * 属性内容
     */
    private String attribute;

    /**
     * 构造方法
     * @param directory_name 诊断目录名称
     * @param attribute_name 属性名称
     * @param attribute 属性内容
     */
    public DiseaseQuery(String directory_name, String attribute_name, String attribute) {
        this.directory_name = directory_name;
        this.attribute_name = attribute_name;
        this.attribute = attribute;
    }

    public String getDirectory_name() {
        return directory_name;
    }

    public void setDirectory_name(String directory_name) {
        this.directory_name = directory_name;
    }

    public String getAttribute_name() {
        return attribute_name;
    }

    public void setAttribute_name(String attribute_name) {
        this.attribute_name = attribute_name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }


}
