package com.shop.service.impl;

import com.shop.common.utils.JsonUtils;
import com.shop.common.utils.ShopResponse;
import com.shop.mapper.ItemParamItemMapper;
import com.shop.pojo.ItemParamExample;
import com.shop.pojo.ItemParamItem;
import com.shop.pojo.ItemParamItemExample;
import com.shop.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author: chaodong.xi
 * @since: 2018/2/8
 */

@Service
public class ItemParamItemServiceImpl implements ItemParamItemService{
    @Autowired
    private ItemParamItemMapper itemParamItemMapper;

    @Override
    public String getItemParamByItemId(Long itemId) {
        ItemParamItemExample itemParamExample = new ItemParamItemExample();
        ItemParamItemExample.Criteria criteria = itemParamExample.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<ItemParamItem> itemList = itemParamItemMapper.selectByExampleWithBLOBs(itemParamExample);
        if(CollectionUtils.isEmpty(itemList)){
            return "";
        }

        List<Map> paramMapList = JsonUtils.jsonToList(itemList.get(0).getParamData(), Map.class);
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
