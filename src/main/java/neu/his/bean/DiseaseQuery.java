package neu.his.bean;

public class DiseaseQuery {
    private String directory_name;
    private String attribute_name;
    private String attribute;

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
