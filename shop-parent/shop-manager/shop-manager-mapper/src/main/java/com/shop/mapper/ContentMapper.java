package com.shop.mapper;

import com.shop.pojo.Content;
import com.shop.pojo.ContentExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ContentMapper {
    @SelectProvider(type=ContentSqlProvider.class, method="countByExample")
    int countByExample(ContentExample example);

    @DeleteProvider(type=ContentSqlProvider.class, method="deleteByExample")
    int deleteByExample(ContentExample example);

    @Delete({
        "delete from content",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into content (id, category_id, ",
        "title, sub_title, ",
        "title_desc, url, ",
        "pic, pic2, created, ",
        "updated, content)",
        "values (#{id,jdbcType=BIGINT}, #{categoryId,jdbcType=BIGINT}, ",
        "#{title,jdbcType=VARCHAR}, #{subTitle,jdbcType=VARCHAR}, ",
        "#{titleDesc,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{pic,jdbcType=VARCHAR}, #{pic2,jdbcType=VARCHAR}, #{created,jdbcType=TIMESTAMP}, ",
        "#{updated,jdbcType=TIMESTAMP}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Content record);

    @InsertProvider(type=ContentSqlProvider.class, method="insertSelective")
    int insertSelective(Content record);

    @SelectProvider(type=ContentSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_title", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="title_desc", property="titleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic2", property="pic2", jdbcType=JdbcType.VARCHAR),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Content> selectByExampleWithBLOBs(ContentExample example);

    @SelectProvider(type=ContentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_title", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="title_desc", property="titleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic2", property="pic2", jdbcType=JdbcType.VARCHAR),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Content> selectByExample(ContentExample example);

    @Select({
        "select",
        "id, category_id, title, sub_title, title_desc, url, pic, pic2, created, updated, ",
        "content",
        "from content",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_title", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="title_desc", property="titleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic2", property="pic2", jdbcType=JdbcType.VARCHAR),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    Content selectByPrimaryKey(Long id);

    @UpdateProvider(type=ContentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    @UpdateProvider(type=ContentSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Content record, @Param("example") ContentExample example);

    @UpdateProvider(type=ContentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

    @UpdateProvider(type=ContentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Content record);

    @Update({
        "update content",
        "set category_id = #{categoryId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "sub_title = #{subTitle,jdbcType=VARCHAR},",
          "title_desc = #{titleDesc,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "pic2 = #{pic2,jdbcType=VARCHAR},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Content record);

    @Update({
        "update content",
        "set category_id = #{categoryId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "sub_title = #{subTitle,jdbcType=VARCHAR},",
          "title_desc = #{titleDesc,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "pic2 = #{pic2,jdbcType=VARCHAR},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Content record);
}