package cn.tedu.dao;

import cn.tedu.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HttpDao {
    @Select("select * from user")
    List<User> getUserAll();

    @Select("select * from user where id = #{id}")
    User getUser(int id);

    @Insert("insert into user values(null,#{username},#{password},#{nickname})")
    void postUser(User user);

    @Update("update user set username=#{username},password=#{password},nickname=#{nickname} where id=#{id}")
    void putUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUser(int id);
}
