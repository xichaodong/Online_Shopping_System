package com.shop.mapper;

import com.shop.pojo.ItemParam;
import com.shop.pojo.ItemParamExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ItemParamMapper {
    @SelectProvider(type=ItemParamSqlProvider.class, method="countByExample")
    int countByExample(ItemParamExample example);

    @DeleteProvider(type=ItemParamSqlProvider.class, method="deleteByExample")
    int deleteByExample(ItemParamExample example);

    @Delete({
        "delete from item_param",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into item_param (id, item_cat_id, ",
        "created, updated, ",
        "item_cat_name, param_data)",
        "values (#{id,jdbcType=BIGINT}, #{itemCatId,jdbcType=BIGINT}, ",
        "#{created,jdbcType=TIMESTAMP}, #{updated,jdbcType=TIMESTAMP}, ",
        "#{itemCatName,jdbcType=VARCHAR}, #{paramData,jdbcType=LONGVARCHAR})"
    })
    int insert(ItemParam record);

    @InsertProvider(type=ItemParamSqlProvider.class, method="insertSelective")
    int insertSelective(ItemParam record);

    @SelectProvider(type=ItemParamSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="item_cat_id", property="itemCatId", jdbcType= JdbcType.BIGINT),
        @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="item_cat_name", property="itemCatName", jdbcType= JdbcType.VARCHAR),
        @Result(column="param_data", property="paramData", jdbcType= JdbcType.LONGVARCHAR)
    })
    List<ItemParam> selectByExampleWithBLOBs(ItemParamExample example);

    @SelectProvider(type=ItemParamSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="item_cat_id", property="itemCatId", jdbcType= JdbcType.BIGINT),
        @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="item_cat_name", property="itemCatName", jdbcType= JdbcType.VARCHAR)
    })
    List<ItemParam> selectByExample(ItemParamExample example);

    @Select({
        "select",
        "id, item_cat_id, created, updated, item_cat_name, param_data",
        "from item_param",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="item_cat_id", property="itemCatId", jdbcType= JdbcType.BIGINT),
        @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="item_cat_name", property="itemCatName", jdbcType= JdbcType.VARCHAR),
        @Result(column="param_data", property="paramData", jdbcType= JdbcType.LONGVARCHAR)
    })
    ItemParam selectByPrimaryKey(Long id);

    @UpdateProvider(type=ItemParamSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ItemParam record, @Param("example") ItemParamExample example);

    @UpdateProvider(type=ItemParamSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ItemParam record, @Param("example") ItemParamExample example);

    @UpdateProvider(type=ItemParamSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ItemParam record, @Param("example") ItemParamExample example);

    @UpdateProvider(type=ItemParamSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ItemParam record);

    @Update({
        "update item_param",
        "set item_cat_id = #{itemCatId,jdbcType=BIGINT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "item_cat_name = #{itemCatName,jdbcType=VARCHAR},",
          "param_data = #{paramData,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ItemParam record);

    @Update({
        "update item_param",
        "set item_cat_id = #{itemCatId,jdbcType=BIGINT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "item_cat_name = #{itemCatName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ItemParam record);
}