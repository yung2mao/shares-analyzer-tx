package org.whitetown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.whitetown.connect.config.FieldsUtil;
import org.whitetown.connect.config.TushareInfo;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SharesStarter {
    @Autowired
    private RestTemplate template;
    @Autowired
    private TushareInfo basicInfo;

    public static void main( String[] args ) throws InterruptedException {
        SpringApplication.run(SharesStarter.class);
    }

    @PostConstruct
    public void run(){
        LinkedHashMap<String,String> params = new LinkedHashMap<>();
        params.put("ts_code","000001.SZ,000002.SZ");
        params.put("start_date","20200301");
        params.put("end_date","20200316");
        String request = FieldsUtil.getParamJson("moneyflow", basicInfo.getToken(), params, null);
        System.out.println(request);
        String shares = template.postForObject(basicInfo.getUrl(), request, String.class);
        System.out.println("result:"+shares);
    }
}
