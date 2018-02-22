package com.shop.search.service.Impl;

import com.shop.search.dao.SearchDao;
import com.shop.search.pojo.SearchResult;
import com.shop.search.service.ItemSearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemSearchServiceImpl implements ItemSearchService {

    @Autowired
    private SearchDao searchDao;

    @Override
    public SearchResult search(String queryString, int page, int rows) throws SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery(queryString);
        solrQuery.setStart((page - 1) * rows);
        solrQuery.setRows(rows);
        solrQuery.set("df", "item_keywords");
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("item_title");
        solrQuery.setHighlightSimplePre("<em style=\"color:red\">");
        solrQuery.setHighlightSimplePost("</em>");

        SearchResult searchResult = searchDao.search(solrQuery);
        long recordCount = searchResult.getRecordCount();
        searchResult.setPageCount((long)Math.ceil(recordCount * 1.0 / rows));
        searchResult.setCurPage(page);

        return searchResult;
    }
}
