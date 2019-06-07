package neu.his.dao;

import java.util.List;
import neu.his.bean.Title;
import neu.his.bean.TitleExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface TitleMapper {

    int countByExample(TitleExample example);

    int deleteByExample(TitleExample example);

    @Delete({
        "delete from title",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into title (id, title_name)",
        "values (#{id,jdbcType=INTEGER}, #{titleName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Title record);

    int insertSelective(Title record);

    List<Title> selectByExample(TitleExample example);

    @Select({
        "select",
        "id, title_name",
        "from title",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Title selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Title record, @Param("example") TitleExample example);

    int updateByExample(@Param("record") Title record, @Param("example") TitleExample example);

    int updateByPrimaryKeySelective(Title record);

    @Update({
        "update title",
        "set title_name = #{titleName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Title record);
}