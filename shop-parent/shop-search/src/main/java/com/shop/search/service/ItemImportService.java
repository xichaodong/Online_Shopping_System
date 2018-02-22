package com.shop.search.service;

import com.shop.common.utils.ShopResponse;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface ItemImportService {
    ShopResponse importAllItems();
}
