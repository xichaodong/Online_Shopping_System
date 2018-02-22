package com.shop.search.service.Impl;

import com.shop.common.utils.ExceptionUtil;
import com.shop.common.utils.ShopResponse;
import com.shop.search.mapper.ItemSearchMapper;
import com.shop.search.pojo.ItemSearch;
import com.shop.search.service.ItemImportService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemImportServiceImpl implements ItemImportService {
    @Autowired
    private ItemSearchMapper itemSearchMapper;
    @Autowired
    private SolrServer solrServer;

    @Override
    public ShopResponse importAllItems(){
        List<ItemSearch> itemSearchList = itemSearchMapper.getItemSearchList();
        itemSearchList.forEach(itemSearch -> {
            SolrInputDocument document = new SolrInputDocument();
            document.setField("id", itemSearch.getId());
            document.setField("item_title", itemSearch.getTitle());
            document.setField("item_sell_point", itemSearch.getSell_point());
            document.setField("item_price", itemSearch.getPrice());
            document.setField("item_image", itemSearch.getImage());
            document.setField("item_category_name", itemSearch.getCategory_name());
            document.setField("item_desc", itemSearch.getItem_des());
            try {
                solrServer.add(document);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        try {
            solrServer.commit();
        } catch(Exception e) {
            e.printStackTrace();
            return ShopResponse.build(500, ExceptionUtil.getStackTrace(e));
        }
        return ShopResponse.ok();
    }
}
