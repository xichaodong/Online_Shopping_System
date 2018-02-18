package com.shop.mapper;

import com.shop.pojo.OrderShipping;
import com.shop.pojo.OrderShippingExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OrderShippingMapper {
    @SelectProvider(type=OrderShippingSqlProvider.class, method="countByExample")
    int countByExample(OrderShippingExample example);

    @DeleteProvider(type=OrderShippingSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderShippingExample example);

    @Delete({
        "delete from order_shipping",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String orderId);

    @Insert({
        "insert into order_shipping (order_id, receiver_name, ",
        "receiver_phone, receiver_mobile, ",
        "receiver_state, receiver_city, ",
        "receiver_district, receiver_address, ",
        "receiver_zip, created, ",
        "updated)",
        "values (#{orderId,jdbcType=VARCHAR}, #{receiverName,jdbcType=VARCHAR}, ",
        "#{receiverPhone,jdbcType=VARCHAR}, #{receiverMobile,jdbcType=VARCHAR}, ",
        "#{receiverState,jdbcType=VARCHAR}, #{receiverCity,jdbcType=VARCHAR}, ",
        "#{receiverDistrict,jdbcType=VARCHAR}, #{receiverAddress,jdbcType=VARCHAR}, ",
        "#{receiverZip,jdbcType=VARCHAR}, #{created,jdbcType=TIMESTAMP}, ",
        "#{updated,jdbcType=TIMESTAMP})"
    })
    int insert(OrderShipping record);

    @InsertProvider(type=OrderShippingSqlProvider.class, method="insertSelective")
    int insertSelective(OrderShipping record);

    @SelectProvider(type=OrderShippingSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="receiver_name", property="receiverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_phone", property="receiverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_mobile", property="receiverMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_state", property="receiverState", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_city", property="receiverCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_district", property="receiverDistrict", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_address", property="receiverAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_zip", property="receiverZip", jdbcType=JdbcType.VARCHAR),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderShipping> selectByExample(OrderShippingExample example);

    @Select({
        "select",
        "order_id, receiver_name, receiver_phone, receiver_mobile, receiver_state, receiver_city, ",
        "receiver_district, receiver_address, receiver_zip, created, updated",
        "from order_shipping",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="receiver_name", property="receiverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_phone", property="receiverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_mobile", property="receiverMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_state", property="receiverState", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_city", property="receiverCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_district", property="receiverDistrict", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_address", property="receiverAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_zip", property="receiverZip", jdbcType=JdbcType.VARCHAR),
        @Result(column="created", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated", property="updated", jdbcType=JdbcType.TIMESTAMP)
    })
    OrderShipping selectByPrimaryKey(String orderId);

    @UpdateProvider(type=OrderShippingSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderShipping record, @Param("example") OrderShippingExample example);

    @UpdateProvider(type=OrderShippingSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderShipping record, @Param("example") OrderShippingExample example);

    @UpdateProvider(type=OrderShippingSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderShipping record);

    @Update({
        "update order_shipping",
        "set receiver_name = #{receiverName,jdbcType=VARCHAR},",
          "receiver_phone = #{receiverPhone,jdbcType=VARCHAR},",
          "receiver_mobile = #{receiverMobile,jdbcType=VARCHAR},",
          "receiver_state = #{receiverState,jdbcType=VARCHAR},",
          "receiver_city = #{receiverCity,jdbcType=VARCHAR},",
          "receiver_district = #{receiverDistrict,jdbcType=VARCHAR},",
          "receiver_address = #{receiverAddress,jdbcType=VARCHAR},",
          "receiver_zip = #{receiverZip,jdbcType=VARCHAR},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(OrderShipping record);
}