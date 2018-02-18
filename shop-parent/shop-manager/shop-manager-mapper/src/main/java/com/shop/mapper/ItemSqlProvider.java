package com.shop.mapper;

import com.shop.pojo.Item;
import com.shop.pojo.ItemExample;
import com.shop.pojo.ItemExample.Criteria;
import com.shop.pojo.ItemExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ItemSqlProvider {

    public String countByExample(ItemExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("item");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ItemExample example) {
        BEGIN();
        DELETE_FROM("item");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Item record) {
        BEGIN();
        INSERT_INTO("item");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getSellPoint() != null) {
            VALUES("sell_point", "#{sellPoint,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=BIGINT}");
        }
        
        if (record.getNum() != null) {
            VALUES("num", "#{num,jdbcType=INTEGER}");
        }
        
        if (record.getBarcode() != null) {
            VALUES("barcode", "#{barcode,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        if (record.getCid() != null) {
            VALUES("cid", "#{cid,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getCreated() != null) {
            VALUES("created", "#{created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            VALUES("updated", "#{updated,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(ItemExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("title");
        SELECT("sell_point");
        SELECT("price");
        SELECT("num");
        SELECT("barcode");
        SELECT("image");
        SELECT("cid");
        SELECT("status");
        SELECT("created");
        SELECT("updated");
        FROM("item");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Item record = (Item) parameter.get("record");
        ItemExample example = (ItemExample) parameter.get("example");
        
        BEGIN();
        UPDATE("item");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getSellPoint() != null) {
            SET("sell_point = #{record.sellPoint,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{record.price,jdbcType=BIGINT}");
        }
        
        if (record.getNum() != null) {
            SET("num = #{record.num,jdbcType=INTEGER}");
        }
        
        if (record.getBarcode() != null) {
            SET("barcode = #{record.barcode,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            SET("image = #{record.image,jdbcType=VARCHAR}");
        }
        
        if (record.getCid() != null) {
            SET("cid = #{record.cid,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=TINYINT}");
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
        UPDATE("item");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("sell_point = #{record.sellPoint,jdbcType=VARCHAR}");
        SET("price = #{record.price,jdbcType=BIGINT}");
        SET("num = #{record.num,jdbcType=INTEGER}");
        SET("barcode = #{record.barcode,jdbcType=VARCHAR}");
        SET("image = #{record.image,jdbcType=VARCHAR}");
        SET("cid = #{record.cid,jdbcType=BIGINT}");
        SET("status = #{record.status,jdbcType=TINYINT}");
        SET("created = #{record.created,jdbcType=TIMESTAMP}");
        SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        
        ItemExample example = (ItemExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Item record) {
        BEGIN();
        UPDATE("item");
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getSellPoint() != null) {
            SET("sell_point = #{sellPoint,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{price,jdbcType=BIGINT}");
        }
        
        if (record.getNum() != null) {
            SET("num = #{num,jdbcType=INTEGER}");
        }
        
        if (record.getBarcode() != null) {
            SET("barcode = #{barcode,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        if (record.getCid() != null) {
            SET("cid = #{cid,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=TINYINT}");
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

    protected void applyWhere(ItemExample example, boolean includeExamplePhrase) {
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