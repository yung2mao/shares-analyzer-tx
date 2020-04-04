package cn.whitetown.connect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

/**
 * @author GrainRain
 * @date 2020/03/17 21:22
 **/
@Component
public class TushareInfo {
    @Value("${tushare.token}")
    private String token;
    @Value("${tushare.url}")
    private String url;

    public String getToken() {
        return token;
    }

    public String getUrl() {
        return url;
    }
}
