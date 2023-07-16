package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //标识此类为一个controller层,并创建对象交给Spring容器管理
public class HelloController {

    @RequestMapping("hello")
    public String doHelloUI() {
        //返回给调用方,就是前端控制器,前端控制器会将hello字符串交给视图解析器,
        //视图解析器会对hello字符串添加前缀和后缀
        return "hello";
    }

    @RequestMapping("doSayHello")
    @ResponseBody //告诉SpringMVC框架返回值不是view,而是具体数据
    public String doSayHello() {
        return "hello Spring MVC";
    }
}
