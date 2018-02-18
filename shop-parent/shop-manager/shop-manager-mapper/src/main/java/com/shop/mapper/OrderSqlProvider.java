package com.shop.mapper;

import com.shop.pojo.Order;
import com.shop.pojo.OrderExample;
import com.shop.pojo.OrderExample.Criteria;
import com.shop.pojo.OrderExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class OrderSqlProvider {

    public String countByExample(OrderExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("order");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(OrderExample example) {
        BEGIN();
        DELETE_FROM("order");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Order record) {
        BEGIN();
        INSERT_INTO("order");
        
        if (record.getOrderId() != null) {
            VALUES("order_id", "#{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getPayment() != null) {
            VALUES("payment", "#{payment,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentType() != null) {
            VALUES("payment_type", "#{paymentType,jdbcType=INTEGER}");
        }
        
        if (record.getPostFee() != null) {
            VALUES("post_fee", "#{postFee,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaymentTime() != null) {
            VALUES("payment_time", "#{paymentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConsignTime() != null) {
            VALUES("consign_time", "#{consignTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseTime() != null) {
            VALUES("close_time", "#{closeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getShippingName() != null) {
            VALUES("shipping_name", "#{shippingName,jdbcType=VARCHAR}");
        }
        
        if (record.getShippingCode() != null) {
            VALUES("shipping_code", "#{shippingCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getBuyerMessage() != null) {
            VALUES("buyer_message", "#{buyerMessage,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerNick() != null) {
            VALUES("buyer_nick", "#{buyerNick,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerRate() != null) {
            VALUES("buyer_rate", "#{buyerRate,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(OrderExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("order_id");
        } else {
            SELECT("order_id");
        }
        SELECT("payment");
        SELECT("payment_type");
        SELECT("post_fee");
        SELECT("status");
        SELECT("create_time");
        SELECT("update_time");
        SELECT("payment_time");
        SELECT("consign_time");
        SELECT("end_time");
        SELECT("close_time");
        SELECT("shipping_name");
        SELECT("shipping_code");
        SELECT("user_id");
        SELECT("buyer_message");
        SELECT("buyer_nick");
        SELECT("buyer_rate");
        FROM("order");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Order record = (Order) parameter.get("record");
        OrderExample example = (OrderExample) parameter.get("example");
        
        BEGIN();
        UPDATE("order");
        
        if (record.getOrderId() != null) {
            SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getPayment() != null) {
            SET("payment = #{record.payment,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentType() != null) {
            SET("payment_type = #{record.paymentType,jdbcType=INTEGER}");
        }
        
        if (record.getPostFee() != null) {
            SET("post_fee = #{record.postFee,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaymentTime() != null) {
            SET("payment_time = #{record.paymentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConsignTime() != null) {
            SET("consign_time = #{record.consignTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseTime() != null) {
            SET("close_time = #{record.closeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getShippingName() != null) {
            SET("shipping_name = #{record.shippingName,jdbcType=VARCHAR}");
        }
        
        if (record.getShippingCode() != null) {
            SET("shipping_code = #{record.shippingCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getBuyerMessage() != null) {
            SET("buyer_message = #{record.buyerMessage,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerNick() != null) {
            SET("buyer_nick = #{record.buyerNick,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerRate() != null) {
            SET("buyer_rate = #{record.buyerRate,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("order");
        
        SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        SET("payment = #{record.payment,jdbcType=VARCHAR}");
        SET("payment_type = #{record.paymentType,jdbcType=INTEGER}");
        SET("post_fee = #{record.postFee,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("payment_time = #{record.paymentTime,jdbcType=TIMESTAMP}");
        SET("consign_time = #{record.consignTime,jdbcType=TIMESTAMP}");
        SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        SET("close_time = #{record.closeTime,jdbcType=TIMESTAMP}");
        SET("shipping_name = #{record.shippingName,jdbcType=VARCHAR}");
        SET("shipping_code = #{record.shippingCode,jdbcType=VARCHAR}");
        SET("user_id = #{record.userId,jdbcType=BIGINT}");
        SET("buyer_message = #{record.buyerMessage,jdbcType=VARCHAR}");
        SET("buyer_nick = #{record.buyerNick,jdbcType=VARCHAR}");
        SET("buyer_rate = #{record.buyerRate,jdbcType=INTEGER}");
        
        OrderExample example = (OrderExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Order record) {
        BEGIN();
        UPDATE("order");
        
        if (record.getPayment() != null) {
            SET("payment = #{payment,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentType() != null) {
            SET("payment_type = #{paymentType,jdbcType=INTEGER}");
        }
        
        if (record.getPostFee() != null) {
            SET("post_fee = #{postFee,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaymentTime() != null) {
            SET("payment_time = #{paymentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConsignTime() != null) {
            SET("consign_time = #{consignTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseTime() != null) {
            SET("close_time = #{closeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getShippingName() != null) {
            SET("shipping_name = #{shippingName,jdbcType=VARCHAR}");
        }
        
        if (record.getShippingCode() != null) {
            SET("shipping_code = #{shippingCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getBuyerMessage() != null) {
            SET("buyer_message = #{buyerMessage,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerNick() != null) {
            SET("buyer_nick = #{buyerNick,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerRate() != null) {
            SET("buyer_rate = #{buyerRate,jdbcType=INTEGER}");
        }
        
        WHERE("order_id = #{orderId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(OrderExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}