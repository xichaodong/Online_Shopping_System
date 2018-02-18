package com.shop.mapper;

import com.shop.pojo.ContentCategory;
import com.shop.pojo.ContentCategoryExample;
import com.shop.pojo.ContentCategoryExample.Criteria;
import com.shop.pojo.ContentCategoryExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ContentCategorySqlProvider {

    public String countByExample(ContentCategoryExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("content_category");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ContentCategoryExample example) {
        BEGIN();
        DELETE_FROM("content_category");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ContentCategory record) {
        BEGIN();
        INSERT_INTO("content_category");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getSortOrder() != null) {
            VALUES("sort_order", "#{sortOrder,jdbcType=INTEGER}");
        }
        
        if (record.getIsParent() != null) {
            VALUES("is_parent", "#{isParent,jdbcType=BIT}");
        }
        
        if (record.getCreated() != null) {
            VALUES("created", "#{created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            VALUES("updated", "#{updated,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(ContentCategoryExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("parent_id");
        SELECT("name");
        SELECT("status");
        SELECT("sort_order");
        SELECT("is_parent");
        SELECT("created");
        SELECT("updated");
        FROM("content_category");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ContentCategory record = (ContentCategory) parameter.get("record");
        ContentCategoryExample example = (ContentCategoryExample) parameter.get("example");
        
        BEGIN();
        UPDATE("content_category");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getSortOrder() != null) {
            SET("sort_order = #{record.sortOrder,jdbcType=INTEGER}");
        }
        
        if (record.getIsParent() != null) {
            SET("is_parent = #{record.isParent,jdbcType=BIT}");
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
        UPDATE("content_category");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("sort_order = #{record.sortOrder,jdbcType=INTEGER}");
        SET("is_parent = #{record.isParent,jdbcType=BIT}");
        SET("created = #{record.created,jdbcType=TIMESTAMP}");
        SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        
        ContentCategoryExample example = (ContentCategoryExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ContentCategory record) {
        BEGIN();
        UPDATE("content_category");
        
        if (record.getParentId() != null) {
            SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getSortOrder() != null) {
            SET("sort_order = #{sortOrder,jdbcType=INTEGER}");
        }
        
        if (record.getIsParent() != null) {
            SET("is_parent = #{isParent,jdbcType=BIT}");
        }
        
        if (record.getCreated() != null) {
            SET("created = #{created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            SET("updated = #{updated,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ContentCategoryExample example, boolean includeExamplePhrase) {
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