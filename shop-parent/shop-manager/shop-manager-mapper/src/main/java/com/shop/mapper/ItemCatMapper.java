package com.shop.mapper;

import com.shop.pojo.ItemCat;
import com.shop.pojo.ItemCatExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ItemCatMapper {
    @SelectProvider(type=ItemCatSqlProvider.class, method="countByExample")
    int countByExample(ItemCatExample example);

    @DeleteProvider(type=ItemCatSqlProvider.class, method="deleteByExample")
    int deleteByExample(ItemCatExample example);

    @Delete({
        "delete from item_cat",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into item_cat (id, parent_id, ",
        "name, status, sort_order, ",
        "is_parent, created, ",
        "updated)",
        "values (#{id,jdbcType=BIGINT}, #{parentId,jdbcType=BIGINT}, ",
        "#{name,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, #{sortOrder,jdbcType=INTEGER}, ",
        "#{isParent,jdbcType=BIT}, #{created,jdbcType=TIMESTAMP}, ",
        "#{updated,jdbcType=TIMESTAMP})"
    })
    int insert(ItemCat record);

    @InsertProvider(type=ItemCatSqlProvider.class, method="insertSelective")
    int insertSelective(ItemCat record);

    @SelectProvider(type=ItemCatSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="sort_order", property="sortOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="is_parent", property="isParent", jdbcType=JdbcType.BIT),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ItemCat> selectByExample(ItemCatExample example);

    @Select({
        "select",
        "id, parent_id, name, status, sort_order, is_parent, created, updated",
        "from item_cat",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="sort_order", property="sortOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="is_parent", property="isParent", jdbcType=JdbcType.BIT),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    ItemCat selectByPrimaryKey(Long id);

    @UpdateProvider(type=ItemCatSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ItemCat record, @Param("example") ItemCatExample example);

    @UpdateProvider(type=ItemCatSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ItemCat record, @Param("example") ItemCatExample example);

    @UpdateProvider(type=ItemCatSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ItemCat record);

    @Update({
        "update item_cat",
        "set parent_id = #{parentId,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "sort_order = #{sortOrder,jdbcType=INTEGER},",
          "is_parent = #{isParent,jdbcType=BIT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ItemCat record);
}