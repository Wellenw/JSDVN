package cn.tedu.controller;

import cn.tedu.entity.Product;
import cn.tedu.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductMapper mapper;

    @PostMapping("product/insert")
    public void insert(@RequestBody Product product){
        mapper.insert(product);
    }

    @GetMapping("product/list/index")
    public List<Product> list(){
        return mapper.selectIndex();
    }

    @GetMapping("product/list/admin")
    public List<Product> selectAdmin() {
        return mapper.selectAdmin();
    }

    @GetMapping("product/list/top")
    public List<Product> doSelectTop(){
        List<Product> list = mapper.selectTop();
        for (Product product : list) {
            if(product.getTitle().length()>3){
                String title = product.getTitle().substring(0,3)+"...";
                product.setTitle(title);
            }
        }
        return list;
    }

    /**基于关键字查询某个商品*/
    @GetMapping("product/selectByWd/{keyWord}")
    public List<Product> doSelectByWd(@PathVariable String keyWord) {
        return mapper.selectByWd(keyWord);
    }

    /**基于id查询某个商品*/
    @GetMapping("product/select/{id}")
    public Product doSelectById(@PathVariable Integer id){
        mapper.updateViewCount(id);
        return mapper.selectById();
    }
    /**基于商品分类id查询商品信息*/
    @GetMapping("product/selectByCid/{cid}")
    public List<Product> doSelectByCid(@PathVariable Integer cid) {
        return mapper.selectByCid(cid);
    }

    @DeleteMapping("product/delete/{id}")
    public void doDeleteById(@PathVariable Integer id){
        String url = mapper.selectUrlById(id);
        String filePath = "d:/file/"+url;
        new File(filePath).delete();
        mapper.deleteById(id);
    }
}
