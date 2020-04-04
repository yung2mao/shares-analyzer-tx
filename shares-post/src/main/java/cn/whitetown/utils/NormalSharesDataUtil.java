package cn.whitetown.utils;

import cn.whitetown.commons.utils.CusJsonToObject;
import cn.whitetown.commons.utils.FileUtil;
import cn.whitetown.commons.utils.IDCreateUtil;
import cn.whitetown.commons.utils.JSONUtil;
import cn.whitetown.connect.config.TushareInfo;
import cn.whitetown.pojo.SharesListData;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
        FileUtil fileUtil = FileUtil.getInstance("/Users/taixian/Documents/static/data/basic"+params.get("exchange")+".txt");
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
        fileUtil.close();
    }
}
