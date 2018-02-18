package com.shop.mapper;

import com.shop.pojo.OrderItem;
import com.shop.pojo.OrderItemExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OrderItemMapper {
    @SelectProvider(type=OrderItemSqlProvider.class, method="countByExample")
    int countByExample(OrderItemExample example);

    @DeleteProvider(type=OrderItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderItemExample example);

    @Delete({
        "delete from order_item",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into order_item (id, item_id, ",
        "order_id, num, title, ",
        "price, total_fee, pic_path)",
        "values (#{id,jdbcType=VARCHAR}, #{itemId,jdbcType=VARCHAR}, ",
        "#{orderId,jdbcType=VARCHAR}, #{num,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=BIGINT}, #{totalFee,jdbcType=BIGINT}, #{picPath,jdbcType=VARCHAR})"
    })
    int insert(OrderItem record);

    @InsertProvider(type=OrderItemSqlProvider.class, method="insertSelective")
    int insertSelective(OrderItem record);

    @SelectProvider(type=OrderItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.BIGINT),
        @Result(column="total_fee", property="totalFee", jdbcType=JdbcType.BIGINT),
        @Result(column="pic_path", property="picPath", jdbcType=JdbcType.VARCHAR)
    })
    List<OrderItem> selectByExample(OrderItemExample example);

    @Select({
        "select",
        "id, item_id, order_id, num, title, price, total_fee, pic_path",
        "from order_item",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.BIGINT),
        @Result(column="total_fee", property="totalFee", jdbcType=JdbcType.BIGINT),
        @Result(column="pic_path", property="picPath", jdbcType=JdbcType.VARCHAR)
    })
    OrderItem selectByPrimaryKey(String id);

    @UpdateProvider(type=OrderItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

    @UpdateProvider(type=OrderItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

    @UpdateProvider(type=OrderItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderItem record);

    @Update({
        "update order_item",
        "set item_id = #{itemId,jdbcType=VARCHAR},",
          "order_id = #{orderId,jdbcType=VARCHAR},",
          "num = #{num,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=BIGINT},",
          "total_fee = #{totalFee,jdbcType=BIGINT},",
          "pic_path = #{picPath,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(OrderItem record);
}