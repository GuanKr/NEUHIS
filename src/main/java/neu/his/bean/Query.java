package neu.his.bean;
/**
 * 封装查询信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class Query {
    /**
     * 属性名称
     */
    private String attribute_name;

    /**
     * 属性内容
     */
    private String attribute;

    /**
     * 封装查询信息
     * @param attribute_name 属性名称
     * @param attribute 属性内容
     */
    public Query(String attribute_name, String attribute) {
        this.attribute_name = attribute_name;
        this.attribute = attribute;
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
