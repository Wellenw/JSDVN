package cn.tedu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private Integer id;
    private String title;
    private String url;
    private Double price;
    private Double oldPrice;
    private Integer viewCount; //浏览量
    private Integer saleCount;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date created;  //发布时间  导包java.util
    private Integer categoryId; //商品分类id


}
