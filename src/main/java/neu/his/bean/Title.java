package neu.his.bean;

public class Title {
    private Integer id;

    private String titleName;

    public Title(Integer id, String titleName) {
        this.id = id;
        this.titleName = titleName;
    }

    public Title(String titleName) {
        this.titleName = titleName;
    }

    public Title() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", titleName='" + titleName + '\'' +
                '}';
    }
}