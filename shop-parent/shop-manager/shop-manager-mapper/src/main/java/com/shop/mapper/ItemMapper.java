package com.shop.mapper;

import com.shop.pojo.Item;
import com.shop.pojo.ItemExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ItemMapper {
    @SelectProvider(type=ItemSqlProvider.class, method="countByExample")
    int countByExample(ItemExample example);

    @DeleteProvider(type=ItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(ItemExample example);

    @Delete({
        "delete from item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into item (id, title, ",
        "sell_point, price, ",
        "num, barcode, image, ",
        "cid, status, created, ",
        "updated)",
        "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{sellPoint,jdbcType=VARCHAR}, #{price,jdbcType=BIGINT}, ",
        "#{num,jdbcType=INTEGER}, #{barcode,jdbcType=VARCHAR}, #{image,jdbcType=VARCHAR}, ",
        "#{cid,jdbcType=BIGINT}, #{status,jdbcType=TINYINT}, #{created,jdbcType=TIMESTAMP}, ",
        "#{updated,jdbcType=TIMESTAMP})"
    })
    int insert(Item record);

    @InsertProvider(type=ItemSqlProvider.class, method="insertSelective")
    int insertSelective(Item record);

    @SelectProvider(type=ItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="sell_point", property="sellPoint", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.BIGINT),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="barcode", property="barcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Item> selectByExample(ItemExample example);

    @Select({
        "select",
        "id, title, sell_point, price, num, barcode, image, cid, status, created, updated",
        "from item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="sell_point", property="sellPoint", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.BIGINT),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="barcode", property="barcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    Item selectByPrimaryKey(Long id);

    @UpdateProvider(type=ItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    @UpdateProvider(type=ItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    @UpdateProvider(type=ItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Item record);

    @Update({
        "update item",
        "set title = #{title,jdbcType=VARCHAR},",
          "sell_point = #{sellPoint,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=BIGINT},",
          "num = #{num,jdbcType=INTEGER},",
          "barcode = #{barcode,jdbcType=VARCHAR},",
          "image = #{image,jdbcType=VARCHAR},",
          "cid = #{cid,jdbcType=BIGINT},",
          "status = #{status,jdbcType=TINYINT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Item record);
}