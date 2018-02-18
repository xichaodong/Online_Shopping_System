package com.shop.mapper;

import com.shop.pojo.ItemDesc;
import com.shop.pojo.ItemDescExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ItemDescMapper {
    @SelectProvider(type=ItemDescSqlProvider.class, method="countByExample")
    int countByExample(ItemDescExample example);

    @DeleteProvider(type=ItemDescSqlProvider.class, method="deleteByExample")
    int deleteByExample(ItemDescExample example);

    @Delete({
        "delete from item_desc",
        "where item_id = #{itemId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long itemId);

    @Insert({
        "insert into item_desc (item_id, created, ",
        "updated, item_desc)",
        "values (#{itemId,jdbcType=BIGINT}, #{created,jdbcType=TIMESTAMP}, ",
        "#{updated,jdbcType=TIMESTAMP}, #{itemDesc,jdbcType=LONGVARCHAR})"
    })
    int insert(ItemDesc record);

    @InsertProvider(type=ItemDescSqlProvider.class, method="insertSelective")
    int insertSelective(ItemDesc record);

    @SelectProvider(type=ItemDescSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="item_desc", property="itemDesc", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ItemDesc> selectByExampleWithBLOBs(ItemDescExample example);

    @SelectProvider(type=ItemDescSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ItemDesc> selectByExample(ItemDescExample example);

    @Select({
        "select",
        "item_id, created, updated, item_desc",
        "from item_desc",
        "where item_id = #{itemId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="item_desc", property="itemDesc", jdbcType=JdbcType.LONGVARCHAR)
    })
    ItemDesc selectByPrimaryKey(Long itemId);

    @UpdateProvider(type=ItemDescSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ItemDesc record, @Param("example") ItemDescExample example);

    @UpdateProvider(type=ItemDescSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ItemDesc record, @Param("example") ItemDescExample example);

    @UpdateProvider(type=ItemDescSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ItemDesc record, @Param("example") ItemDescExample example);

    @UpdateProvider(type=ItemDescSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ItemDesc record);

    @Update({
        "update item_desc",
        "set created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "item_desc = #{itemDesc,jdbcType=LONGVARCHAR}",
        "where item_id = #{itemId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ItemDesc record);

    @Update({
        "update item_desc",
        "set created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where item_id = #{itemId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ItemDesc record);
}