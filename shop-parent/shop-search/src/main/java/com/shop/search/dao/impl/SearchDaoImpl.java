package com.shop.search.dao.impl;

import com.shop.common.utils.CollectionUtils;
import com.shop.search.dao.SearchDao;
import com.shop.search.pojo.ItemSearch;
import com.shop.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SearchDaoImpl implements SearchDao {

    @Autowired
    private SolrServer solrServer;

    @Override
    public SearchResult search(SolrQuery query) throws SolrServerException {

            SearchResult result = new SearchResult();

            QueryResponse queryResponse = solrServer.query(query);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            result.setRecordCount(solrDocumentList.getNumFound());

            Map<String, Map<String , List<String>>> highLighting = queryResponse.getHighlighting();
            List<ItemSearch> itemSearchList = new ArrayList<>();

            solrDocumentList.forEach(solrDocument -> {

                ItemSearch itemSearch = new ItemSearch();
                itemSearch.setId((String)solrDocument.get("id"));

                List<String> highLightingList = highLighting.get(solrDocument.get("id")).get("item_title");
                if(CollectionUtils.listIsNullOrEmpty(highLightingList)){
                    itemSearch.setTitle((String)solrDocument.get("item_title"));
                }else{
                    itemSearch.setTitle(highLightingList.get(0));
                }

                itemSearch.setImage((String)solrDocument.get("item_image"));
                itemSearch.setPrice((Long)solrDocument.get("item_price"));
                itemSearch.setSell_point((String)solrDocument.get("item_sell_point"));
                itemSearch.setCategory_name((String)solrDocument.get("item_category_name"));
                itemSearchList.add(itemSearch);
            });
            result.setItemSearchList(itemSearchList);
        return result;
    }
}
