package com.zyq.account.mapper;


import Serach.Serachvo;
import entity.user;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface userMapper {
    @Insert("Insert into user(create_date,password,user_img,user_name) values (#{createDate},#{password},#{userImg},#{userName})")
    int insert(user record);
    @Select("SELECT * from user where user_name=#{userName}")
    user selectByPrimaryKey(String name);

    @Select("<script>" +
            "select * from user" +
            "<where>" +
            "<if test='keyWord!=null and keyWord!=\"\"'>" +
            "user_name like '%${keyWord}%'" +
            "</if>" +
            "</where>" +
            "<choose>" +
            "<when test=' orderBy!=null and orderBy!=\"\"'>" +
            "ORDER BY  ${orderBy}  ${sort}" +
            "</when>" +
            "<otherwise>" +
            "ORDER BY user_id desc" +
            "</otherwise>" +
            "</choose>" +
            "</script>")
    List<user> getusersBySerchvo(Serachvo serachvo);

    @Delete("delete from user where user_id=userId")
    int delete(int userId);
    @Update("UPDATE user SET password=#{password},user_img=#{userImg},user_name=#{userName}")
    void update(user user);
    @Select("SELECT * FROM user where user_id=#{userId}")
    user getuserById(int userId);
}