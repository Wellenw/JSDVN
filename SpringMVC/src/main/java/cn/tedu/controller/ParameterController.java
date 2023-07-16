package cn.tedu.controller;

import cn.tedu.entity.Emp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController //= @Controller + @ResponseBody
public class ParameterController {

    @RequestMapping("param1")
    public String param1(String name) {
        return "姓名为:"+name;
    }

    @RequestMapping("param2")
    public String param2(String name,int age) {
        return "姓名为:"+name+",年龄为"+age;
    }

    @RequestMapping("param3")
    public String param3(Emp emp) {
        return emp.toString();
    }

    @RequestMapping("param4")
    public String param4(Integer[] ids) {
        return Arrays.toString(ids);
    }
}
