package cn.whitetown.utils;

import cn.whitetown.pojo.CusJsonToObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GrainRain
 * @date 2020/03/29 11:22
 **/
@Component
public class JSONUtil {

    public <T> T getAsObject(String json, Class<T> clazz){
        return JSON.parseObject(json,clazz);
    }

    //获取json的某个String类型属性值
    public String getField(String json,String field){
        String[] fields = field.split("\\.");
        JSONObject preResult = getPreJsonObject(json,fields);
        return preResult.getString(fields[fields.length-1]);
    }

    //获取json某个array或list属性并封装为list返回
    public <T> List<T> getListFields(String json,String field,Class<T> clazz){
        String[] fields = field.split("\\.");
        JSONObject preResult = getPreJsonObject(json,fields);
        JSONArray resultJsonArray = preResult.getJSONArray(fields[fields.length-1]);
        List<T> resultList = new ArrayList<>();
        for (int i = 0; i < resultJsonArray.size(); i++) {
            T t = resultJsonArray.getJSONObject(i).toJavaObject(clazz);
            resultList.add(t);
        }
        return resultList;
    }

    //按自定义的需求解析json并返回数据
    public List<? extends CusJsonToObject> getListFields(String json,String field,CusJsonToObject cusJsonToObject){
        String[] fields = field.split("\\.");
        JSONObject preResult = getPreJsonObject(json,fields);
        JSONArray resultJsonArray = preResult.getJSONArray(fields[fields.length-1]);
        List<CusJsonToObject> list = new ArrayList<>();
        for (int i = 0; i < resultJsonArray.size(); i++) {
            CusJsonToObject instance = cusJsonToObject.getInstance(resultJsonArray.get(i));
            list.add(instance);
        }
        return list;
    }

    private JSONObject getPreJsonObject(String json,String[] fields){
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject result = jsonObject;
        for(int i =0; i< fields.length-1;i++){
            result = result.getJSONObject(fields[i]);
        }
        return result;
    }

    public JSONObject getJsonObject(String json,String[] fields){
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject result = jsonObject;
        for(int i =0; i< fields.length;i++){
            result = result.getJSONObject(fields[i]);
        }
        return result;
    }
}
