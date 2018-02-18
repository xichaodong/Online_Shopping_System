package com.shop.mapper;

import com.shop.pojo.Content;
import com.shop.pojo.ContentExample;
import com.shop.pojo.ContentExample.Criteria;
import com.shop.pojo.ContentExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ContentSqlProvider {

    public String countByExample(ContentExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("content");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ContentExample example) {
        BEGIN();
        DELETE_FROM("content");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Content record) {
        BEGIN();
        INSERT_INTO("content");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getCategoryId() != null) {
            VALUES("category_id", "#{categoryId,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getSubTitle() != null) {
            VALUES("sub_title", "#{subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getTitleDesc() != null) {
            VALUES("title_desc", "#{titleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            VALUES("pic", "#{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getPic2() != null) {
            VALUES("pic2", "#{pic2,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated() != null) {
            VALUES("created", "#{created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            VALUES("updated", "#{updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(ContentExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("category_id");
        SELECT("title");
        SELECT("sub_title");
        SELECT("title_desc");
        SELECT("url");
        SELECT("pic");
        SELECT("pic2");
        SELECT("created");
        SELECT("updated");
        SELECT("content");
        FROM("content");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(ContentExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("category_id");
        SELECT("title");
        SELECT("sub_title");
        SELECT("title_desc");
        SELECT("url");
        SELECT("pic");
        SELECT("pic2");
        SELECT("created");
        SELECT("updated");
        FROM("content");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Content record = (Content) parameter.get("record");
        ContentExample example = (ContentExample) parameter.get("example");
        
        BEGIN();
        UPDATE("content");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCategoryId() != null) {
            SET("category_id = #{record.categoryId,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getSubTitle() != null) {
            SET("sub_title = #{record.subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getTitleDesc() != null) {
            SET("title_desc = #{record.titleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            SET("url = #{record.url,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            SET("pic = #{record.pic,jdbcType=VARCHAR}");
        }
        
        if (record.getPic2() != null) {
            SET("pic2 = #{record.pic2,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated() != null) {
            SET("created = #{record.created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("content");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("category_id = #{record.categoryId,jdbcType=BIGINT}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("sub_title = #{record.subTitle,jdbcType=VARCHAR}");
        SET("title_desc = #{record.titleDesc,jdbcType=VARCHAR}");
        SET("url = #{record.url,jdbcType=VARCHAR}");
        SET("pic = #{record.pic,jdbcType=VARCHAR}");
        SET("pic2 = #{record.pic2,jdbcType=VARCHAR}");
        SET("created = #{record.created,jdbcType=TIMESTAMP}");
        SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        
        ContentExample example = (ContentExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("content");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("category_id = #{record.categoryId,jdbcType=BIGINT}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("sub_title = #{record.subTitle,jdbcType=VARCHAR}");
        SET("title_desc = #{record.titleDesc,jdbcType=VARCHAR}");
        SET("url = #{record.url,jdbcType=VARCHAR}");
        SET("pic = #{record.pic,jdbcType=VARCHAR}");
        SET("pic2 = #{record.pic2,jdbcType=VARCHAR}");
        SET("created = #{record.created,jdbcType=TIMESTAMP}");
        SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        
        ContentExample example = (ContentExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Content record) {
        BEGIN();
        UPDATE("content");
        
        if (record.getCategoryId() != null) {
            SET("category_id = #{categoryId,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getSubTitle() != null) {
            SET("sub_title = #{subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getTitleDesc() != null) {
            SET("title_desc = #{titleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            SET("pic = #{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getPic2() != null) {
            SET("pic2 = #{pic2,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated() != null) {
            SET("created = #{created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            SET("updated = #{updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ContentExample example, boolean includeExamplePhrase) {
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