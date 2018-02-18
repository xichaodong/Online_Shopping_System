package com.shop.mapper;

import com.shop.pojo.OrderShipping;
import com.shop.pojo.OrderShippingExample;
import com.shop.pojo.OrderShippingExample.Criteria;
import com.shop.pojo.OrderShippingExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class OrderShippingSqlProvider {

    public String countByExample(OrderShippingExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("order_shipping");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(OrderShippingExample example) {
        BEGIN();
        DELETE_FROM("order_shipping");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(OrderShipping record) {
        BEGIN();
        INSERT_INTO("order_shipping");
        
        if (record.getOrderId() != null) {
            VALUES("order_id", "#{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverName() != null) {
            VALUES("receiver_name", "#{receiverName,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverPhone() != null) {
            VALUES("receiver_phone", "#{receiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverMobile() != null) {
            VALUES("receiver_mobile", "#{receiverMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverState() != null) {
            VALUES("receiver_state", "#{receiverState,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverCity() != null) {
            VALUES("receiver_city", "#{receiverCity,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverDistrict() != null) {
            VALUES("receiver_district", "#{receiverDistrict,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverAddress() != null) {
            VALUES("receiver_address", "#{receiverAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverZip() != null) {
            VALUES("receiver_zip", "#{receiverZip,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated() != null) {
            VALUES("created", "#{created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            VALUES("updated", "#{updated,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(OrderShippingExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("order_id");
        } else {
            SELECT("order_id");
        }
        SELECT("receiver_name");
        SELECT("receiver_phone");
        SELECT("receiver_mobile");
        SELECT("receiver_state");
        SELECT("receiver_city");
        SELECT("receiver_district");
        SELECT("receiver_address");
        SELECT("receiver_zip");
        SELECT("created");
        SELECT("updated");
        FROM("order_shipping");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderShipping record = (OrderShipping) parameter.get("record");
        OrderShippingExample example = (OrderShippingExample) parameter.get("example");
        
        BEGIN();
        UPDATE("order_shipping");
        
        if (record.getOrderId() != null) {
            SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverName() != null) {
            SET("receiver_name = #{record.receiverName,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverPhone() != null) {
            SET("receiver_phone = #{record.receiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverMobile() != null) {
            SET("receiver_mobile = #{record.receiverMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverState() != null) {
            SET("receiver_state = #{record.receiverState,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverCity() != null) {
            SET("receiver_city = #{record.receiverCity,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverDistrict() != null) {
            SET("receiver_district = #{record.receiverDistrict,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverAddress() != null) {
            SET("receiver_address = #{record.receiverAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverZip() != null) {
            SET("receiver_zip = #{record.receiverZip,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated() != null) {
            SET("created = #{record.created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("order_shipping");
        
        SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        SET("receiver_name = #{record.receiverName,jdbcType=VARCHAR}");
        SET("receiver_phone = #{record.receiverPhone,jdbcType=VARCHAR}");
        SET("receiver_mobile = #{record.receiverMobile,jdbcType=VARCHAR}");
        SET("receiver_state = #{record.receiverState,jdbcType=VARCHAR}");
        SET("receiver_city = #{record.receiverCity,jdbcType=VARCHAR}");
        SET("receiver_district = #{record.receiverDistrict,jdbcType=VARCHAR}");
        SET("receiver_address = #{record.receiverAddress,jdbcType=VARCHAR}");
        SET("receiver_zip = #{record.receiverZip,jdbcType=VARCHAR}");
        SET("created = #{record.created,jdbcType=TIMESTAMP}");
        SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        
        OrderShippingExample example = (OrderShippingExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderShipping record) {
        BEGIN();
        UPDATE("order_shipping");
        
        if (record.getReceiverName() != null) {
            SET("receiver_name = #{receiverName,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverPhone() != null) {
            SET("receiver_phone = #{receiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverMobile() != null) {
            SET("receiver_mobile = #{receiverMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverState() != null) {
            SET("receiver_state = #{receiverState,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverCity() != null) {
            SET("receiver_city = #{receiverCity,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverDistrict() != null) {
            SET("receiver_district = #{receiverDistrict,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverAddress() != null) {
            SET("receiver_address = #{receiverAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverZip() != null) {
            SET("receiver_zip = #{receiverZip,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated() != null) {
            SET("created = #{created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            SET("updated = #{updated,jdbcType=TIMESTAMP}");
        }
        
        WHERE("order_id = #{orderId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(OrderShippingExample example, boolean includeExamplePhrase) {
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