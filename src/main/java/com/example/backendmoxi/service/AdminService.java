package com.example.backendmoxi.service;

import com.example.backendmoxi.model.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend-moxi
 * User: quent
 * Date: 2018/6/23
 * Time: 10:10
 */
@Mapper
public interface AdminService {

    @Select("SELECT * FROM `moxi`.`admin` WHERE userName = #{userName} and password = #{password} and state = 1;")
    Admin findByNameAndPassword(Admin admin);

    @Insert("INSERT INTO `moxi`.`admin` (`id`, `userName`, `password`, `realName`, `age`, `phoneNumber`, `headPicture`, `addDate`, `updateDate`, `state`) VALUES (null, #{userName}, #{password}, #{realName}, #{age}, #{phoneNumber}, #{headPicture}, now(), now(), 1);")
    int insert(Admin admin);
}
