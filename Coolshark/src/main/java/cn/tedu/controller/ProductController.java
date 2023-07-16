package cn.tedu.controller;

import cn.tedu.entity.Product;
import cn.tedu.mapper.ProductMapper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
@Api(tags = "3.商品处理类")
@ApiSupport(author = "吴伟浪")
@RestController
public class ProductController {
    @Autowired
    private ProductMapper mapper;

    @PostMapping("product/insert")
    public void insert(@RequestBody @ApiParam("商品") Product product){
        mapper.insert(product);
    }

    @ApiOperation("查询所有商品")
    @ApiOperationSupport(order = 1)
    @GetMapping("product/list/index")
    public List<Product> list(){
        return mapper.selectIndex();
    }


    @GetMapping("product/list/admin")
    public List<Product> selectAdmin() {
        return mapper.selectAdmin();
    }

    @ApiOperation("查询排行榜商品")
    @ApiOperationSupport(order = 2)
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

    @ApiOperation("基于关键字查询商品")
    @ApiOperationSupport(order = 4)
    /**基于关键字查询某个商品*/
    @GetMapping("product/selectByWd/{keyWord}")
    public List<Product> doSelectByWd(@PathVariable String keyWord) {
        return mapper.selectByWd(keyWord);
    }

    /**基于id查询某个商品*/
    @ApiOperation("基于id查询商品")
    @ApiOperationSupport(order = 3)
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

    @ApiImplicitParam(name = "id",value = "商品id",example = "1",required = true,dataType = "int")
    @DeleteMapping("product/delete/{id}")
    public void doDeleteById(@PathVariable Integer id){
        String url = mapper.selectUrlById(id);
        String filePath = "d:/file/"+url;
        new File(filePath).delete();
        mapper.deleteById(id);
    }
}
