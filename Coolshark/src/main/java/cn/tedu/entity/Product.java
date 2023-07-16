package cn.tedu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "商品类", description = "用于描述商品信息")
public class Product {
    @ApiModelProperty(value = "商品id",position = 1)
    private Integer id;
    @ApiModelProperty(value = "商品标题",position = 2)
    private String title;
    @ApiModelProperty(value = "商品图片",position = 3)
    private String url;
    @ApiModelProperty(value = "商品价格",position = 4)
    private Double price;
    @ApiModelProperty(value = "商品原价",position = 5)
    private Double oldPrice;
    @ApiModelProperty(value = "商品浏览量",position = 6)
    private Integer viewCount; //浏览量
    @ApiModelProperty(value = "商品销量",position = 7)
    private Integer saleCount;
    @ApiModelProperty(value = "商品发布时间",position = 8)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date created;  //发布时间  导包java.util
    @ApiModelProperty(value = "商品分类",position = 9)
    private Integer categoryId; //商品分类id


}
