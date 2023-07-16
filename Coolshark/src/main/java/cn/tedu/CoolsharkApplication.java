package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //此注解的作用是在当前类所在的包以及子包下扫描过滤器
@SpringBootApplication
public class CoolsharkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoolsharkApplication.class, args);
    }

}
