package com.shop.portal.pojo;

import com.shop.pojo.Item;

public class ItemInfo extends Item {

    public String[] getImages(){
        String image = getImage();
        if(image != null){
            return image.split(",");
        }
        return null;
    }
}
