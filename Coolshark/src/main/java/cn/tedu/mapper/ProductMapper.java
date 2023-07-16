package cn.tedu.mapper;

import cn.tedu.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Insert("insert into product values(null,#{title},#{url},#{price},#{oldPrice},0,#{saleCount},#{created},#{categoryId})")
    void insert(Product product);

    @Select("select id,title,price,old_price,sale_count,url from product")
    List<Product> selectIndex();

    @Select("select id,title,price,sale_count,url from product")
    List<Product> selectAdmin();

    @Select("select id,title,sale_count from product order by sale_count desc limit 6")
    List<Product> selectTop();

//    concat()字符串拼接
    @Select("select id,title,price,old_price,sale_count,url from product where title like concat('%',#{keyWord},'%')")
    List<Product> selectByWd(String keyWord);

    @Select("select id,title,url,price,old_price,sale_count,view_count,created from product where id = #{id}")
    Product selectById();

    @Update("update product set view_count = view_count + 1 where id = #{id}")
    void updateViewCount(Integer id);

    @Select("select id,title,price,old_price,sale_count,url from product where category_id = #{cid}")
    List<Product> selectByCid(Integer cid);

    @Select("select url from product where id = #{id}")
    String selectUrlById(Integer id);

    @Delete("delete from product where id = #{id}")
    void deleteById(Integer id);
}
