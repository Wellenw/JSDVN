package cn.tedu.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class LombokTests {

    @Test
    public void test(){
        Banner b = new Banner(1,"123");
        System.out.println(b.getId());
        log.info(b.toString());
    }
}
