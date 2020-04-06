package cn.whitetown.post.utils;

import cn.whitetown.commons.pojo.SharesInfo;
import cn.whitetown.commons.utils.CusJsonToObject;
import cn.whitetown.commons.utils.FileUtil;
import cn.whitetown.commons.utils.IDCreateUtil;
import cn.whitetown.commons.utils.JSONUtil;
import cn.whitetown.post.config.TushareInfo;
import cn.whitetown.post.mappers.PostMapper;
import cn.whitetown.post.pojo.SharesListData;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import sun.awt.image.ImageWatched;
import sun.java2d.pipe.SpanIterator;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author GrainRain
 * @date 2020/04/01 17:48
 **/
@Configuration
public class NormalSharesDataUtil {
    @Autowired
    private TushareInfo info;

    @Autowired
    private RestTemplate template;

    @Autowired
    private JSONUtil jsonUtil;

    @Autowired
    private PostMapper mapper;

    public void getAllStockBasic() throws IOException {
        LinkedHashMap<String,String> params = new LinkedHashMap<>();
        List<String> fields = new ArrayList<>();
        params.put("is_hs","");
        params.put("list_status","L");
        params.put("exchange","SZSE");
        fields.add("ts_code");
        fields.add("symbol");
        fields.add("name");
        fields.add("area");
        fields.add("industry");
        fields.add("list_date");
        String request = FieldsUtil.getParamJson("stock_basic", info.getToken(), params, fields);
        String basicData = template.postForObject(info.getUrl(), request, String.class);
        List<SharesListData> basicList = jsonUtil.getListFields(basicData, "data.items", new CusJsonToObject<SharesListData>() {
            @Override
            public SharesListData getInstance(Object json) {
                JSONArray jsonArray = (JSONArray) json;
                SharesListData data = new SharesListData();
                data.setId(IDCreateUtil.getBasicId(jsonArray.getString(0).split("\\.")[1]));
                data.setTsCode(jsonArray.getString(1));
                data.setName(jsonArray.getString(2));
                data.setArea(jsonArray.getString(3));
                data.setIndustry(jsonArray.getString(4));
                data.setListDate(jsonArray.getString(5));
                return data;
            }
        });
        /*FileUtil fileUtil = FileUtil.getInstance("/Users/taixian/Documents/static/data/basic"+params.get("exchange")+".txt");
        basicList.forEach(new Consumer<SharesListData>() {
            @Override
            public void accept(SharesListData sharesListData) {
                try {
                    fileUtil.channelWrite(sharesListData.writeFormat());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        fileUtil.close();*/
        mapper.insertBasicSharesList(basicList);
    }

    public void getSharesInfo(){
        LinkedHashMap<String, String> params = getParams("ts_code:000002.SZ", "exchange:SZSE");
        List<String> fields = getFields("ts_code","exchange","chairman","manager","secretary","reg_capital",
                "setup_date","province","city","website","email","office","main_business","employees","business_scope");
        String request = FieldsUtil.getParamJson("stock_company",info.getToken(),params,fields);
        String data = template.postForObject(info.getUrl(),request,String.class);
        List<SharesInfo> sharesInfoList = jsonUtil.getListFields(data, "data.items", new CusJsonToObject<SharesInfo>() {
            @Override
            public SharesInfo getInstance(Object json) {
                JSONArray jsonArray = (JSONArray)json;
                SharesInfo info = new SharesInfo();
                info.setId(IDCreateUtil.getBasicId(jsonArray.getString(0).split("\\.")[1]));
                info.setTsCode(jsonArray.getString(0).split("\\.")[0]);
                info.setExchange(jsonArray.getString(1));
                info.setChairman(jsonArray.getString(2));
                info.setManager(jsonArray.getString(3));
                info.setRegCapital(jsonArray.getDouble(5)*10000);
                info.setSetupDate(jsonArray.getString(6));
                info.setProvince(jsonArray.getString(7));
                info.setCity(jsonArray.getString(8));
                info.setWebsite(jsonArray.getString(9));
                info.setEmail(jsonArray.getString(10));
                info.setOffice(jsonArray.getString(11));
                info.setMainBusiness(jsonArray.getString(12));
                info.setEmployeesNum(jsonArray.getInteger(13));
                info.setBusinessScope(jsonArray.getString(14));
                return info;
            }
        });

    }

    public LinkedHashMap<String,String> getParams(String ... params) throws IllegalArgumentException{
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        for(String param:params){
            String[] ps = param.split(":");
            if(ps.length<2)
                map.put(ps[0],"");
            else
                map.put(ps[0],ps[1]);
        }
        return map;
    }

    public List<String> getFields(String ... fields){
        List<String> list = new LinkedList<>();
        if(fields.length > 0){
            for(String field:fields) {
                list.add(field);
            }
            return list;
        }else
            return null;
    }
}
