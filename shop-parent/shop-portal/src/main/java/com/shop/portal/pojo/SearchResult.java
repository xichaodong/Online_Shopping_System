package com.shop.portal.pojo;

import java.util.List;

public class SearchResult {
    private List<ItemSearch> itemSearchList;
    private long recordCount;
    private long pageCount;
    private long curPage;

    public List<ItemSearch> getItemSearchList() {
        return itemSearchList;
    }

    public void setItemSearchList(List<ItemSearch> itemSearchList) {
        this.itemSearchList = itemSearchList;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getCurPage() {
        return curPage;
    }

    public void setCurPage(long curPage) {
        this.curPage = curPage;
    }
}
