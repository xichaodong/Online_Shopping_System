package com.shop.mapper;

import com.shop.pojo.ItemParamItem;
import com.shop.pojo.ItemParamItemExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ItemParamItemMapper {
    @SelectProvider(type=ItemParamItemSqlProvider.class, method="countByExample")
    int countByExample(ItemParamItemExample example);

    @DeleteProvider(type=ItemParamItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(ItemParamItemExample example);

    @Delete({
        "delete from item_param_item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into item_param_item (id, item_id, ",
        "created, updated, ",
        "param_data)",
        "values (#{id,jdbcType=BIGINT}, #{itemId,jdbcType=BIGINT}, ",
        "#{created,jdbcType=TIMESTAMP}, #{updated,jdbcType=TIMESTAMP}, ",
        "#{paramData,jdbcType=LONGVARCHAR})"
    })
    int insert(ItemParamItem record);

    @InsertProvider(type=ItemParamItemSqlProvider.class, method="insertSelective")
    int insertSelective(ItemParamItem record);

    @SelectProvider(type=ItemParamItemSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.BIGINT),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="param_data", property="paramData", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ItemParamItem> selectByExampleWithBLOBs(ItemParamItemExample example);

    @SelectProvider(type=ItemParamItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.BIGINT),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ItemParamItem> selectByExample(ItemParamItemExample example);

    @Select({
        "select",
        "id, item_id, created, updated, param_data",
        "from item_param_item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.BIGINT),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="param_data", property="paramData", jdbcType=JdbcType.LONGVARCHAR)
    })
    ItemParamItem selectByPrimaryKey(Long id);

    @UpdateProvider(type=ItemParamItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);

    @UpdateProvider(type=ItemParamItemSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);

    @UpdateProvider(type=ItemParamItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);

    @UpdateProvider(type=ItemParamItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ItemParamItem record);

    @Update({
        "update item_param_item",
        "set item_id = #{itemId,jdbcType=BIGINT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "param_data = #{paramData,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ItemParamItem record);

    @Update({
        "update item_param_item",
        "set item_id = #{itemId,jdbcType=BIGINT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ItemParamItem record);
}