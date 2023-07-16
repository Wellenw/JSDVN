package cn.tedu.controller;

import cn.tedu.entity.Category;
import cn.tedu.mapper.CategoryMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryMapper mapper;

    @PostMapping("category/insert")
    public void insert(@RequestBody Category category) {
        mapper.insert(category);
    }

    @GetMapping("category/select")
    public List<Category> list(){return mapper.list();}

    @DeleteMapping("category/delete/{id}")
    public void delete(@PathVariable int id){
        mapper.deleteById(id);
    }
}
