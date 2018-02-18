package com.shop.mapper;

import com.shop.pojo.OrderItem;
import com.shop.pojo.OrderItemExample;
import com.shop.pojo.OrderItemExample.Criteria;
import com.shop.pojo.OrderItemExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class OrderItemSqlProvider {

    public String countByExample(OrderItemExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("order_item");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(OrderItemExample example) {
        BEGIN();
        DELETE_FROM("order_item");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(OrderItem record) {
        BEGIN();
        INSERT_INTO("order_item");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getItemId() != null) {
            VALUES("item_id", "#{itemId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderId() != null) {
            VALUES("order_id", "#{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            VALUES("num", "#{num,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=BIGINT}");
        }
        
        if (record.getTotalFee() != null) {
            VALUES("total_fee", "#{totalFee,jdbcType=BIGINT}");
        }
        
        if (record.getPicPath() != null) {
            VALUES("pic_path", "#{picPath,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(OrderItemExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("item_id");
        SELECT("order_id");
        SELECT("num");
        SELECT("title");
        SELECT("price");
        SELECT("total_fee");
        SELECT("pic_path");
        FROM("order_item");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderItem record = (OrderItem) parameter.get("record");
        OrderItemExample example = (OrderItemExample) parameter.get("example");
        
        BEGIN();
        UPDATE("order_item");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getItemId() != null) {
            SET("item_id = #{record.itemId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderId() != null) {
            SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            SET("num = #{record.num,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{record.price,jdbcType=BIGINT}");
        }
        
        if (record.getTotalFee() != null) {
            SET("total_fee = #{record.totalFee,jdbcType=BIGINT}");
        }
        
        if (record.getPicPath() != null) {
            SET("pic_path = #{record.picPath,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("order_item");
        
        SET("id = #{record.id,jdbcType=VARCHAR}");
        SET("item_id = #{record.itemId,jdbcType=VARCHAR}");
        SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        SET("num = #{record.num,jdbcType=INTEGER}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("price = #{record.price,jdbcType=BIGINT}");
        SET("total_fee = #{record.totalFee,jdbcType=BIGINT}");
        SET("pic_path = #{record.picPath,jdbcType=VARCHAR}");
        
        OrderItemExample example = (OrderItemExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderItem record) {
        BEGIN();
        UPDATE("order_item");
        
        if (record.getItemId() != null) {
            SET("item_id = #{itemId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderId() != null) {
            SET("order_id = #{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            SET("num = #{num,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{price,jdbcType=BIGINT}");
        }
        
        if (record.getTotalFee() != null) {
            SET("total_fee = #{totalFee,jdbcType=BIGINT}");
        }
        
        if (record.getPicPath() != null) {
            SET("pic_path = #{picPath,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(OrderItemExample example, boolean includeExamplePhrase) {
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