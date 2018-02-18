package com.shop.mapper;

import com.shop.pojo.Order;
import com.shop.pojo.OrderExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OrderMapper {
    @SelectProvider(type=OrderSqlProvider.class, method="countByExample")
    int countByExample(OrderExample example);

    @DeleteProvider(type=OrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderExample example);

    @Delete({
        "delete from order",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String orderId);

    @Insert({
        "insert into order (order_id, payment, ",
        "payment_type, post_fee, ",
        "status, create_time, ",
        "update_time, payment_time, ",
        "consign_time, end_time, ",
        "close_time, shipping_name, ",
        "shipping_code, user_id, ",
        "buyer_message, buyer_nick, ",
        "buyer_rate)",
        "values (#{orderId,jdbcType=VARCHAR}, #{payment,jdbcType=VARCHAR}, ",
        "#{paymentType,jdbcType=INTEGER}, #{postFee,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{paymentTime,jdbcType=TIMESTAMP}, ",
        "#{consignTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{closeTime,jdbcType=TIMESTAMP}, #{shippingName,jdbcType=VARCHAR}, ",
        "#{shippingCode,jdbcType=VARCHAR}, #{userId,jdbcType=BIGINT}, ",
        "#{buyerMessage,jdbcType=VARCHAR}, #{buyerNick,jdbcType=VARCHAR}, ",
        "#{buyerRate,jdbcType=INTEGER})"
    })
    int insert(Order record);

    @InsertProvider(type=OrderSqlProvider.class, method="insertSelective")
    int insertSelective(Order record);

    @SelectProvider(type=OrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="payment", property="payment", jdbcType=JdbcType.VARCHAR),
        @Result(column="payment_type", property="paymentType", jdbcType=JdbcType.INTEGER),
        @Result(column="post_fee", property="postFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="payment_time", property="paymentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="consign_time", property="consignTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="close_time", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="shipping_name", property="shippingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="shipping_code", property="shippingCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="buyer_message", property="buyerMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyer_nick", property="buyerNick", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyer_rate", property="buyerRate", jdbcType=JdbcType.INTEGER)
    })
    List<Order> selectByExample(OrderExample example);

    @Select({
        "select",
        "order_id, payment, payment_type, post_fee, status, create_time, update_time, ",
        "payment_time, consign_time, end_time, close_time, shipping_name, shipping_code, ",
        "user_id, buyer_message, buyer_nick, buyer_rate",
        "from order",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="payment", property="payment", jdbcType=JdbcType.VARCHAR),
        @Result(column="payment_type", property="paymentType", jdbcType=JdbcType.INTEGER),
        @Result(column="post_fee", property="postFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="payment_time", property="paymentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="consign_time", property="consignTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="close_time", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="shipping_name", property="shippingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="shipping_code", property="shippingCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="buyer_message", property="buyerMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyer_nick", property="buyerNick", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyer_rate", property="buyerRate", jdbcType=JdbcType.INTEGER)
    })
    Order selectByPrimaryKey(String orderId);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update order",
        "set payment = #{payment,jdbcType=VARCHAR},",
          "payment_type = #{paymentType,jdbcType=INTEGER},",
          "post_fee = #{postFee,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "payment_time = #{paymentTime,jdbcType=TIMESTAMP},",
          "consign_time = #{consignTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "close_time = #{closeTime,jdbcType=TIMESTAMP},",
          "shipping_name = #{shippingName,jdbcType=VARCHAR},",
          "shipping_code = #{shippingCode,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "buyer_message = #{buyerMessage,jdbcType=VARCHAR},",
          "buyer_nick = #{buyerNick,jdbcType=VARCHAR},",
          "buyer_rate = #{buyerRate,jdbcType=INTEGER}",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Order record);
}