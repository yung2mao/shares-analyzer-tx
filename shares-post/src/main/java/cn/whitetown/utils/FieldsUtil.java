package cn.whitetown.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GrainRain
 * @date 2020/03/17 20:47
 **/
@Component
public class FieldsUtil {
    private FieldsUtil(){}

    static class GetParam{
        private String api_name;
        private String token;
        private LinkedHashMap<String,String> params;
        private List<String> fields;

        public GetParam() {
        }

        public GetParam(String api_name, String token, LinkedHashMap<String, String> params, List<String> fields) {
            this.api_name = api_name;
            this.token = token;
            this.params = params;
            this.fields = fields;
        }

        public String getApi_name() {
            return api_name;
        }

        public void setApi_name(String api_name) {
            this.api_name = api_name;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Map<String, String> getParams() {
            return params;
        }

        public void setParams(LinkedHashMap<String, String> params) {
            this.params = params;
        }

        public List<String> getFields() {
            return fields;
        }

        public void setFields(List<String> fields) {
            this.fields = fields;
        }

        @Override
        public String toString() {
            return "GetParam{" +
                    "api_name='" + api_name + '\'' +
                    ", token='" + token + '\'' +
                    ", params=" + params +
                    ", fields=" + fields +
                    '}';
        }
    }

    public static GetParam getParam(String api_name, String token,LinkedHashMap<String, String> params, List<String> fields){
        return new GetParam(api_name,token,params,fields);
    }

    public static String getParamJson(String api_name, String token,LinkedHashMap<String, String> params, List<String> fields){
        GetParam getParam = new GetParam(api_name,token,params,fields);
        return JSON.toJSONString(getParam);
    }
}
