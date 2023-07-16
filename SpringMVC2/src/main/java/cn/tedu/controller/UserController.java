package cn.tedu.controller;

import cn.tedu.dao.UserDao;
import cn.tedu.pojo.JsonResult;
import cn.tedu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao dao;

    /*用户注册*/
    @PostMapping("user/register")
    public JsonResult doRegister(@RequestBody User user) {
        user.setCreatedTime(new Date());
        user.setModifiedTime(new Date());
        dao.insert(user);
        return new JsonResult("注册成功!");
    }

    /*查询注册时间比createdTime晚的用户信息 2020-12-20*/
    @GetMapping("user/list/{createdTime}")
    public JsonResult doList(@PathVariable String createdTime) {
        List<User> list = dao.list(createdTime);
        return new JsonResult(list);
    }

    @PutMapping("user/update")
    public JsonResult doUpdate(@RequestBody User user) {
        user.setModifiedTime(new Date());
        dao.update(user);
        return new JsonResult("update OK!");
    }
}
