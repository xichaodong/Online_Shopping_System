package com.shop.service.impl;

import com.shop.common.pojo.EUTreeNode;
import com.shop.common.utils.ShopResponse;
import com.shop.mapper.ContentCategoryMapper;
import com.shop.pojo.Content;
import com.shop.pojo.ContentCategory;
import com.shop.pojo.ContentCategoryExample;
import com.shop.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/9
 */

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService{

    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EUTreeNode> getCategoryList(long parentId) {
        ContentCategoryExample contentCategoryExample = new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria = contentCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<ContentCategory> contentCategoryList = contentCategoryMapper.selectByExample(contentCategoryExample);
        List<EUTreeNode> euTreeNodeList  = new ArrayList<>();
        contentCategoryList.forEach(contentCategory -> {
            EUTreeNode euTreeNode = new EUTreeNode();
            euTreeNode.setId(contentCategory.getId());
            euTreeNode.setText(contentCategory.getName());
            euTreeNode.setState(contentCategory.getIsParent() ? "closed" : "open");
            euTreeNodeList.add(euTreeNode);
        });
        return euTreeNodeList;
    }

    @Override
    public ShopResponse insertContentCategory(long parentId, String name) {
        ContentCategory contentCategory = new ContentCategory();
        contentCategory.setName(name);
        contentCategory.setParentId(parentId);
        contentCategory.setStatus(1);
        contentCategory.setSortOrder(1);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        contentCategory.setIsParent(false);

        boolean childrenInsertResult = contentCategoryMapper.insert(contentCategory) > 0;

        ContentCategory parentContent = contentCategoryMapper.selectByPrimaryKey(parentId);
        boolean parentInsertResult = true;
        if(!parentContent.getIsParent()){
            parentContent.setIsParent(true);
            parentInsertResult = contentCategoryMapper.updateByPrimaryKey(parentContent) > 0;
        }

        if(!childrenInsertResult || !parentInsertResult){
            return ShopResponse.build(999, "插入失败");
        }
        return ShopResponse.ok(contentCategory);
    }

    @Override
    public ShopResponse deleteContentCategory(long id) {


        ContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);

        ContentCategory parentContent = contentCategoryMapper.selectByPrimaryKey(contentCategory.getParentId());

        boolean deleteResult = deleteChildrenContent(id);

        ContentCategoryExample contentExample = new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria = contentExample.createCriteria();
        criteria.andParentIdEqualTo(parentContent.getId());
        List<ContentCategory> contentCategoryList = contentCategoryMapper.selectByExample(contentExample);

        if(contentCategoryList.size() == 0){
            parentContent.setIsParent(false);
            deleteResult = contentCategoryMapper.updateByPrimaryKey(parentContent) > 0;
        }

        return deleteResult ? ShopResponse.ok() : ShopResponse.build(999, "删除失败");
    }

    @Override
    public ShopResponse renameContentCategory(long id, String name) {
        ContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
        contentCategory.setName(name);
        boolean renameResult = contentCategoryMapper.updateByPrimaryKey(contentCategory) > 1;
        return  renameResult ? ShopResponse.ok() : ShopResponse.build(999, "重命名失败");
    }

    private boolean deleteChildrenContent(long id){

        boolean isParent = contentCategoryMapper.selectByPrimaryKey(id).getIsParent();
        if(!isParent){
            return contentCategoryMapper.deleteByPrimaryKey(id) > 0;
        }

        ContentCategoryExample contentExample = new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria = contentExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<ContentCategory> contentCategoryList = contentCategoryMapper.selectByExample(contentExample);
        contentCategoryList.forEach(contentCategory -> {
            deleteChildrenContent(contentCategory.getId());
        });
        return contentCategoryMapper.deleteByPrimaryKey(id) > 0;
    }
}
