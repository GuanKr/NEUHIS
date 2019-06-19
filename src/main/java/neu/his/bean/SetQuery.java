package neu.his.bean;

public class SetQuery {
    private String attribute_name;
    private String attribute;
    private Integer doctorId;

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
