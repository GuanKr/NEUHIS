package neu.his.dao;

import java.util.List;
import neu.his.bean.InspectionSet;
import neu.his.bean.InspectionSetExample;
import neu.his.bean.SetQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
/**
 * 处理检查/检验/处置组套
 * @author lsy
 * @version 1.8
 * @since 1.0
 */
public interface InspectionSetMapper {

    /**
     * 查询组套
     * @param setQuery 封装的查询信息
     * @return 查询结果列表
     */
    List<InspectionSet> query(SetQuery setQuery);

    /**
     * 查找所有检查组套
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<InspectionSet> findAllInsSet(Integer doctorId);

    /**
     * 查找所有检验组套
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<InspectionSet> findAllCheckSet(Integer doctorId);

    /**
     * 查找所有处置组套
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<InspectionSet> findAllHandleSet(Integer doctorId);

    /**
     * 查询组套信息
     * @param doctorId 操作的医生id
     * @return 组套列表
     */
    List<InspectionSet> selectWithName(Integer doctorId);

    int countByExample(InspectionSetExample example);

    int deleteByExample(InspectionSetExample example);

    @Delete({
        "delete from inspection_set",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into inspection_set (id, doctor_id, ",
        "combinatorial_code, combinatorial_name, ",
        "category, requirement, ",
        "create_time)",
        "values (#{id,jdbcType=INTEGER}, #{doctorId,jdbcType=INTEGER}, ",
        "#{combinatorialCode,jdbcType=VARCHAR}, #{combinatorialName,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=CHAR}, #{requirement,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(InspectionSet record);

    int insertSelective(InspectionSet record);

    List<InspectionSet> selectByExample(InspectionSetExample example);

    @Select({
        "select",
        "id, doctor_id, combinatorial_code, combinatorial_name, category, requirement, ",
        "create_time",
        "from inspection_set",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    InspectionSet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InspectionSet record, @Param("example") InspectionSetExample example);

    int updateByExample(@Param("record") InspectionSet record, @Param("example") InspectionSetExample example);

    int updateByPrimaryKeySelective(InspectionSet record);

    @Update({
        "update inspection_set",
        "set doctor_id = #{doctorId,jdbcType=INTEGER},",
          "combinatorial_code = #{combinatorialCode,jdbcType=VARCHAR},",
          "combinatorial_name = #{combinatorialName,jdbcType=VARCHAR},",
          "category = #{category,jdbcType=CHAR},",
          "requirement = #{requirement,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(InspectionSet record);
}