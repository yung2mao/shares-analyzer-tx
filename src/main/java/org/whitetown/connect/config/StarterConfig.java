package org.whitetown.connect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.whitetown.pojo.SharesDailyData;
import org.whitetown.utils.FileUtil;

import java.io.IOException;
import java.util.List;

/**
 * @author GrainRain
 * @date 2020/03/27 11:02
 **/
@Configuration
public class StarterConfig {
    @Bean
    public FileUtil fileUtil(){
        try {
            return FileUtil.getInstance("/Users/taixian/Documents/static/data/sh000001.xlsx");
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
