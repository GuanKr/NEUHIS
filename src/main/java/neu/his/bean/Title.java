package neu.his.bean;


public class Title {
    /**
     *@Author:

     */

    private Integer id;

    private String titleName;
    /**
     *@Author:
     *@param: [id, titleName]
     * 主键id，职称名称
     *@return:
     *@Description: 构造方法1
     *
     */
    public Title(Integer id, String titleName) {
        this.id = id;
        this.titleName = titleName;
    }
    /**
     *@Author:
     *@param: [titleName]
     * 职称名称
     *@return:
     *@Description: 构造方法2
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