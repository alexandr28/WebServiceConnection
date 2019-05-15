package com.acampdev.webserviceconnection.Parsers;

import com.acampdev.webserviceconnection.POJO.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ItemJSONParser {
    public static List<Item> parse(String content){
        try {
            JSONArray jsonArray= new JSONArray(content);
            List<Item> itemList= new ArrayList<>();
            for(int i=0; i<jsonArray.length();i++){
                JSONObject jsonObject= jsonArray.getJSONObject(i);
                Item item= new Item();
                item.setId(jsonObject.getString("id"));
                item.setName(jsonObject.getString("name"));
                item.setSocialNetwork(jsonObject.getString("socialNetwork"));
                item.setImage(jsonObject.getString("image"));
                itemList.add(item);
            }
            return itemList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
