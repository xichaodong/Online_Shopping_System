package com.shop.mapper;

import com.shop.pojo.ItemDesc;
import com.shop.pojo.ItemDescExample;
import com.shop.pojo.ItemDescExample.Criteria;
import com.shop.pojo.ItemDescExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ItemDescSqlProvider {

    public String countByExample(ItemDescExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("item_desc");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ItemDescExample example) {
        BEGIN();
        DELETE_FROM("item_desc");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ItemDesc record) {
        BEGIN();
        INSERT_INTO("item_desc");
        
        if (record.getItemId() != null) {
            VALUES("item_id", "#{itemId,jdbcType=BIGINT}");
        }
        
        if (record.getCreated() != null) {
            VALUES("created", "#{created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            VALUES("updated", "#{updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getItemDesc() != null) {
            VALUES("item_desc", "#{itemDesc,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(ItemDescExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("item_id");
        } else {
            SELECT("item_id");
        }
        SELECT("created");
        SELECT("updated");
        SELECT("item_desc");
        FROM("item_desc");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(ItemDescExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("item_id");
        } else {
            SELECT("item_id");
        }
        SELECT("created");
        SELECT("updated");
        FROM("item_desc");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ItemDesc record = (ItemDesc) parameter.get("record");
        ItemDescExample example = (ItemDescExample) parameter.get("example");
        
        BEGIN();
        UPDATE("item_desc");
        
        if (record.getItemId() != null) {
            SET("item_id = #{record.itemId,jdbcType=BIGINT}");
        }
        
        if (record.getCreated() != null) {
            SET("created = #{record.created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getItemDesc() != null) {
            SET("item_desc = #{record.itemDesc,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("item_desc");
        
        SET("item_id = #{record.itemId,jdbcType=BIGINT}");
        SET("created = #{record.created,jdbcType=TIMESTAMP}");
        SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        SET("item_desc = #{record.itemDesc,jdbcType=LONGVARCHAR}");
        
        ItemDescExample example = (ItemDescExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("item_desc");
        
        SET("item_id = #{record.itemId,jdbcType=BIGINT}");
        SET("created = #{record.created,jdbcType=TIMESTAMP}");
        SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        
        ItemDescExample example = (ItemDescExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ItemDesc record) {
        BEGIN();
        UPDATE("item_desc");
        
        if (record.getCreated() != null) {
            SET("created = #{created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            SET("updated = #{updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getItemDesc() != null) {
            SET("item_desc = #{itemDesc,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("item_id = #{itemId,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ItemDescExample example, boolean includeExamplePhrase) {
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