package com.github.design.proxy.mybatis_spring.mapper;

import com.github.design.proxy.mybatis_spring.annotation.Select;

public interface UserMapper {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);



    @Select("select userName from user where aeg = #{age}")
    String queryList(int age);
}
