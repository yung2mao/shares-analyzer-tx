package cn.whitetown.view;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author GrainRain
 * @date 2020/04/03 17:25
 **/
@SpringBootApplication
@MapperScan("cn.whitetown.view.mappers")
public class ViewStarter {
    public static void main(String[] args) {
        SpringApplication.run(ViewStarter.class);
        System.out.println("view service is started");
    }
}
