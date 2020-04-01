package cn.whitetown.connect.config;

import cn.whitetown.utils.FileUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author GrainRain
 * @date 2020/03/27 11:02
 **/
@Configuration
public class StarterConfig {
    @Bean
    public FileUtil fileUtil(){
        try {
            return FileUtil.getInstance("/Users/taixian/Documents/static/data/sh601398.xlsx");
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


}
