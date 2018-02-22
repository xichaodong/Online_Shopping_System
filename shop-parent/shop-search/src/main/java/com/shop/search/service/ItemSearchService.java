package com.shop.search.service;

import com.shop.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrServerException;

public interface ItemSearchService {
    SearchResult search(String queryString, int page, int rows) throws SolrServerException;
}
