package com.shop.mapper;

import com.shop.pojo.ContentCategory;
import com.shop.pojo.ContentCategoryExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ContentCategoryMapper {
    @SelectProvider(type=ContentCategorySqlProvider.class, method="countByExample")
    int countByExample(ContentCategoryExample example);

    @DeleteProvider(type=ContentCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(ContentCategoryExample example);

    @Delete({
        "delete from content_category",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into content_category (id, parent_id, ",
        "name, status, sort_order, ",
        "is_parent, created, ",
        "updated)",
        "values (#{id,jdbcType=BIGINT}, #{parentId,jdbcType=BIGINT}, ",
        "#{name,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, #{sortOrder,jdbcType=INTEGER}, ",
        "#{isParent,jdbcType=BIT}, #{created,jdbcType=TIMESTAMP}, ",
        "#{updated,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(ContentCategory record);

    @InsertProvider(type=ContentCategorySqlProvider.class, method="insertSelective")
    int insertSelective(ContentCategory record);

    @SelectProvider(type=ContentCategorySqlProvider.class, method="selectByExample")
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
    List<ContentCategory> selectByExample(ContentCategoryExample example);

    @Select({
        "select",
        "id, parent_id, name, status, sort_order, is_parent, created, updated",
        "from content_category",
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
    ContentCategory selectByPrimaryKey(Long id);

    @UpdateProvider(type=ContentCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ContentCategory record, @Param("example") ContentCategoryExample example);

    @UpdateProvider(type=ContentCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ContentCategory record, @Param("example") ContentCategoryExample example);

    @UpdateProvider(type=ContentCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ContentCategory record);

    @Update({
        "update content_category",
        "set parent_id = #{parentId,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "sort_order = #{sortOrder,jdbcType=INTEGER},",
          "is_parent = #{isParent,jdbcType=BIT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ContentCategory record);
}