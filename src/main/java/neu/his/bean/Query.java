package neu.his.bean;

public class Query {
    private String attribute_name;
    private String attribute;

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
