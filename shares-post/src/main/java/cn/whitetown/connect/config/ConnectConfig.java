package cn.whitetown.connect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author GrainRain
 * @date 2020/03/20 16:00
 **/
@Configuration
public class ConnectConfig {
    @Bean
    public RestTemplate getInstance(){
        return new RestTemplate();
    }
}
