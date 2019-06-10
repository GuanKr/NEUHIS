package neu.his.dao;

import java.util.List;
import neu.his.bean.SettlementType;
import neu.his.bean.SettlementTypeExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface SettlementTypeMapper {
    int countByExample(SettlementTypeExample example);

    int deleteByExample(SettlementTypeExample example);

    @Delete({
        "delete from settlement_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into settlement_type (id, settlement_type_name)",
        "values (#{id,jdbcType=INTEGER}, #{settlementTypeName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(SettlementType record);

    int insertSelective(SettlementType record);

    List<SettlementType> selectByExample(SettlementTypeExample example);

    @Select({
        "select",
        "id, settlement_type_name",
        "from settlement_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    SettlementType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SettlementType record, @Param("example") SettlementTypeExample example);

    int updateByExample(@Param("record") SettlementType record, @Param("example") SettlementTypeExample example);

    int updateByPrimaryKeySelective(SettlementType record);

    @Update({
        "update settlement_type",
        "set settlement_type_name = #{settlementTypeName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SettlementType record);
}