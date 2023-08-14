package com.thatchedcottage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ThatchedCottageApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(ThatchedCottageApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n" );
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
