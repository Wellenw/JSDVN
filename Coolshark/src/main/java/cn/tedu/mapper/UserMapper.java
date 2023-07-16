package cn.tedu.mapper;

import cn.tedu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select id,username,password,nickname from user where username=#{username}")
    User selectByUsername(String username);
}
