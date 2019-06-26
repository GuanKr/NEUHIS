package neu.his.bean;
/**
 * 封装组套查询信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public class SetQuery {
    /**
     * 属性名称
     */
    private String attribute_name;
    /**
     * 属性内容
     */
    private String attribute;
    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 构造方法
     * @param attribute_name 属性名称
     * @param attribute 属性内容
     * @param doctorId 医生id
     */
    public SetQuery(String attribute_name, String attribute, Integer doctorId) {
        this.attribute_name = attribute_name;
        this.attribute = attribute;
        this.doctorId = doctorId;
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

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
}
