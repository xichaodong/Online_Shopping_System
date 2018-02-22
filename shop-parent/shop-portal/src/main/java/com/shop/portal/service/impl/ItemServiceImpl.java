package com.shop.portal.service.impl;

import com.shop.common.utils.HttpClientUtil;
import com.shop.common.utils.JsonUtils;
import com.shop.common.utils.ShopResponse;
import com.shop.common.utils.StringUtils;
import com.shop.pojo.Item;
import com.shop.pojo.ItemDesc;
import com.shop.pojo.ItemParam;
import com.shop.pojo.ItemParamItem;
import com.shop.portal.pojo.ItemInfo;
import com.shop.portal.pojo.ItemSearch;
import com.shop.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${ITEM_INFO_URL}")
    private String ITEM_INFO_URL;
    @Value("${ITEM_DESC_URL}")
    private String ITEM_DESC_URL;
    @Value("${ITEM_PARAM_URL}")
    private String ITEM_PARAM_URL;

    @Override
    public ItemInfo getItemById(Long itemId) {
        try {
            String itemInfo = HttpClientUtil.doGet(REST_BASE_URL + ITEM_INFO_URL + itemId);
            if (!StringUtils.isNullOrEmpty(itemInfo)) {
                ShopResponse shopResponse = ShopResponse.formatToPojo(itemInfo, ItemInfo.class);
                if (shopResponse.getStatus() == 200) {
                    return (ItemInfo) shopResponse.getData();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getItemDescById(Long itemId) {
        try {
            String itemDescJson = HttpClientUtil.doGet(REST_BASE_URL + ITEM_DESC_URL + itemId);
            if (!StringUtils.isNullOrEmpty(itemDescJson)) {
                ShopResponse shopResponse = ShopResponse.formatToPojo(itemDescJson, ItemDesc.class);
                if (shopResponse.getStatus() == 200) {
                    ItemDesc itemDesc = (ItemDesc) shopResponse.getData();
                    return itemDesc.getItemDesc();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getItemParamById(Long itemId) {
        try {
            String itemParamJson = HttpClientUtil.doGet(REST_BASE_URL + ITEM_PARAM_URL + itemId);
            if (!StringUtils.isNullOrEmpty(itemParamJson)) {
                ShopResponse shopResponse = ShopResponse.formatToPojo(itemParamJson, ItemParamItem.class);
                if (shopResponse.getStatus() == 200) {
                    ItemParamItem itemParamItem = (ItemParamItem) shopResponse.getData();

                    List<Map> paramMapList = JsonUtils.jsonToList(itemParamItem.getParamData(), Map.class);
                    StringBuffer paramForm = new StringBuffer();

                    paramForm.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
                    paramForm.append("    <tbody>\n");

                    paramMapList.forEach(paramMap -> {
                        paramForm.append("        <tr>\n");
                        paramForm.append("            <th class=\"tdTitle\" colspan=\"2\">").append(paramMap.get("group")).append("</th>\n");
                        paramForm.append("        </tr>\n");
                        if(paramMap.get("params") != null) {
                            List<Map> params = (List<Map>) paramMap.get("params");
                            params.forEach(param -> {
                                paramForm.append("        <tr>\n");
                                paramForm.append("            <td class=\"tdTitle\">" + param.get("k") + "</td>\n");
                                paramForm.append("            <td>" + param.get("v") + "</td>\n");
                                paramForm.append("        </tr>\n");
                            });
                        }
                    });

                    paramForm.append("    </tbody>\n");
                    paramForm.append("</table>");

                    return paramForm.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
