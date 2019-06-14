package neu.his.bean;


public class Title {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 职称名称
     */
    private String titleName;

    /**
     *构造方法1
     *@param id, 主键id
     *@param titleName 职称名称
     */
    public Title(Integer id, String titleName) {
        this.id = id;
        this.titleName = titleName;
    }

    /**
     *构造方法2
     *@param titleName 职称名称
     */
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