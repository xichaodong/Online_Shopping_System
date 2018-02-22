package com.shop.search.dao;

import com.shop.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

public interface SearchDao {
    SearchResult search(SolrQuery query) throws SolrServerException;
}
