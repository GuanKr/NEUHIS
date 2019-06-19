package neu.his.dao;

import java.util.List;
import neu.his.bean.InspectionSetDetail;
import neu.his.bean.InspectionSetDetailExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
/**
 * 处理检查/检验/处置项目组套
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface InspectionSetDetailMapper {
    /**
     * 查找某组套下所有项目
     * @param setId 组套id
     * @return 项目列表
     */
    List<InspectionSetDetail> selectBySet(Integer setId);

    /**
     * 插入项目
     * @param inspectionSetDetail 非药品项目
     */
    void insertDetail(InspectionSetDetail inspectionSetDetail);

    int countByExample(InspectionSetDetailExample example);

    int deleteByExample(InspectionSetDetailExample example);

    @Delete({
        "delete from inspection_set_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into inspection_set_detail (id, inspection_set_id, ",
        "non_drug_list_id)",
        "values (#{id,jdbcType=INTEGER}, #{inspectionSetId,jdbcType=INTEGER}, ",
        "#{nonDrugListId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(InspectionSetDetail record);

    int insertSelective(InspectionSetDetail record);

    List<InspectionSetDetail> selectByExample(InspectionSetDetailExample example);

    @Select({
        "select",
        "id, inspection_set_id, non_drug_list_id",
        "from inspection_set_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    InspectionSetDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InspectionSetDetail record, @Param("example") InspectionSetDetailExample example);

    int updateByExample(@Param("record") InspectionSetDetail record, @Param("example") InspectionSetDetailExample example);

    int updateByPrimaryKeySelective(InspectionSetDetail record);

    @Update({
        "update inspection_set_detail",
        "set inspection_set_id = #{inspectionSetId,jdbcType=INTEGER},",
          "non_drug_list_id = #{nonDrugListId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(InspectionSetDetail record);
}