package cn.tedu.controller;

import cn.tedu.dao.HttpDao;
import cn.tedu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HttpController {
    @Autowired
    HttpDao dao;

    //value属性表示访问路径,method表示请求方式
    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    //@GetMapping("getUser")
    public String getUserAll() {
        List<User> list = dao.getUserAll();
        return list.toString();
    }

    @RequestMapping(value = "getUserById",method = RequestMethod.GET)
    public User getUserByid(int id) {
        User user = dao.getUser(id);
        return user;
    }

    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        dao.postUser(user);
        return "添加成功!";
    }
}
