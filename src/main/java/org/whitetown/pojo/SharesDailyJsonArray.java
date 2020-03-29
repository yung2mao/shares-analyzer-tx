package org.whitetown.pojo;

import com.alibaba.fastjson.JSONArray;

/**
 * @author GrainRain
 * @date 2020/03/27 09:45
 **/
public class SharesDailyJsonArray extends JSONArray {

    private JSONArray jsonArray;

    private SharesDailyJsonArray(JSONArray jsonArray){
        this.jsonArray = jsonArray;
    }

    public static SharesDailyJsonArray getInstance(JSONArray jsonArray){
        return new SharesDailyJsonArray(jsonArray);
    }

    @Override
    public int size() {
        return jsonArray.size();
    }

    @Override
    public Object get(int index) {
        return jsonArray.get(index);
    }

    @Override
    public Object[] toArray() {
        return jsonArray.toArray();
    }
}
