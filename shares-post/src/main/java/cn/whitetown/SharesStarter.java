package cn.whitetown;

import cn.whitetown.commons.utils.FileUtil;
import cn.whitetown.commons.utils.JSONUtil;
import cn.whitetown.post.utils.FieldsUtil;
import cn.whitetown.post.config.TushareInfo;
import cn.whitetown.post.pojo.SharesDailyData;
import cn.whitetown.post.utils.DailyExcelListener;
import cn.whitetown.post.utils.NormalSharesDataUtil;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * starter
 *
 */
@SpringBootApplication
public class SharesStarter {
    @Autowired
    private RestTemplate template;

    @Autowired
    private TushareInfo basicInfo;

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private JSONUtil jsonUtil;

    @Autowired
    private NormalSharesDataUtil normalSharesDataUtil;

    public static void main( String[] args ) throws InterruptedException {
        SpringApplication.run(SharesStarter.class);
    }

//    @PostConstruct
    public void run() throws IOException {
        LinkedHashMap<String,String> params = new LinkedHashMap<>();
        params.put("ts_code","601398.SH");
        params.put("start_date","20190301");
        params.put("end_date","20200326");
        String request = FieldsUtil.getParamJson("daily", basicInfo.getToken(), params, null);
        String shares = template.postForObject(basicInfo.getUrl(), request, String.class);
      /*  JSONObject allData = JSON.parseObject(shares);
        JSONArray data = allData.getJSONObject("data").getJSONArray("items");
        List<SharesDailyData> sharesDailyDataList = new LinkedList<>();
        data.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                JSONArray row = (JSONArray)o;
                SharesDailyData sharesDailyData = new SharesDailyData();
                sharesDailyData.setAllFields(SharesDailyJsonArray.getInstance(row));
                sharesDailyDataList.add(sharesDailyData);

            }
        });*/
        List<SharesDailyData> sharesDailyDataList = jsonUtil.getListFields(shares, "data.items", new SharesDailyData());
        /*WriteSheet sheet = new WriteSheet();
        sheet.setSheetNo(0);
        sheet.setSheetName("daily");
        sheet.setClazz(SharesDailyData.class);
        fileUtil.writeAsExcel(sharesDailyDataList, sheet);*/
        for(SharesDailyData data:sharesDailyDataList){
            fileUtil.channelWrite(data.writeFormat());
        }
    }

    @PostConstruct
    public void start() throws IOException {
        normalSharesDataUtil.getAllStockBasic();
    }

//    @PostConstruct
    public void read() throws FileNotFoundException {
        DailyExcelListener listener = new DailyExcelListener();
        fileUtil.initExcelReader("/Users/taixian/Documents/static/data/rx.xlsx",listener);
        ReadSheet sheet = new ReadSheet(0,"daily");
        sheet.setClazz(SharesDailyData.class);
        fileUtil.readExcel(sheet);
        List<SharesDailyData> sharesDailyDataList = listener.getSharesDailyDataList();
        System.out.println(sharesDailyDataList);
    }

    @PreDestroy
    public void destroy() throws IOException {
        fileUtil.close();
    }
}
