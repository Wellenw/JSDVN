package cn.tedu.dao;

import cn.tedu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {
    //添加新的用户信息
    @Insert("insert into tb_users values(null,#{username},#{nickname},#{password},#{mobile},#{status},#{createdTime},#{modifiedTime})")
    void insert(User user);

    /**查询注册时间比createdTime晚的用户记录*/
    @Select("select * from tb_users where created_time > #{createdTime}")
    List<User> list(String createdTime);

    @Update("update tb_users set username=#{username},password=#{password},nickname=#{nickname},mobile=#{mobile},modified_time=#{modifiedTime} where id = #{id}")
    void update(User user);
}
