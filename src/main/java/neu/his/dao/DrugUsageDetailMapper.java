package neu.his.dao;

import java.util.List;
import neu.his.bean.DrugUsageDetail;
import neu.his.bean.DrugUsageDetailExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
/**
 * 处理药品用法信息
 * @author lsy
 * @version 1.0
 * @since 1.8
 */
public interface DrugUsageDetailMapper {
    int countByExample(DrugUsageDetailExample example);

    int deleteByExample(DrugUsageDetailExample example);

    @Delete({
        "delete from drug_usage_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into drug_usage_detail (id, drug_usage)",
        "values (#{id,jdbcType=INTEGER}, #{drugUsage,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(DrugUsageDetail record);

    int insertSelective(DrugUsageDetail record);

    List<DrugUsageDetail> selectByExample(DrugUsageDetailExample example);

    @Select({
        "select",
        "id, drug_usage",
        "from drug_usage_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    DrugUsageDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DrugUsageDetail record, @Param("example") DrugUsageDetailExample example);

    int updateByExample(@Param("record") DrugUsageDetail record, @Param("example") DrugUsageDetailExample example);

    int updateByPrimaryKeySelective(DrugUsageDetail record);

    @Update({
        "update drug_usage_detail",
        "set drug_usage = #{drugUsage,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DrugUsageDetail record);
}