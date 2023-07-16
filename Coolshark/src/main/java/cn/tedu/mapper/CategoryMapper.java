package cn.tedu.mapper;

import cn.tedu.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("insert into category values(null,#{name})")
    void insert(Category category);

    @Select("select id,name from category")
    List<Category> list();

    @Delete("delete from category where id = #{id}")
    void deleteById(int id);
}
