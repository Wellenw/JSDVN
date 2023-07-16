package cn.tedu.controller;

import cn.tedu.dao.HttpDao;
import cn.tedu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Http2Controller {
    @Autowired
    HttpDao dao;

    @PutMapping("user")
    public String putUser(@RequestBody User user) {
        dao.putUser(user);
        return "修改成功!";
    }

    @DeleteMapping("user/{id}")
    //@PathVariable表示获取请求路径中参数的值,要求必须同名
    public String deleteUser(@PathVariable int id) {
        dao.deleteUser(id);
        return "删除成功!";
    }
}
