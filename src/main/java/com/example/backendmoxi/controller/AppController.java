package com.example.backendmoxi.controller;

import com.example.backendmoxi.model.ResObject;
import com.example.backendmoxi.model.User;
import com.example.backendmoxi.util.Constant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend-moxi
 * User: quent
 * Date: 2018/6/24
 * Time: 9:10
 */
@RestController
public class AppController {

    @GetMapping("/app/login")
    public ResObject<Object> login(User user){
        System.out.println("UserName:" + user.getUserName());
        System.out.println("Password:" + user.getPassword());
        ResObject<Object> object = new ResObject<Object>(Constant.Code01, Constant.Msg01, user, null);
        return object;
    }

    @PostMapping("/app/register")
    public ResObject<Object> register(User user){
        System.out.println("UserName:" + user.getUserName());
        System.out.println("Password:" + user.getPassword());
        ResObject<Object> object = new ResObject<Object>(Constant.Code01, Constant.Msg01, user, null);
        return object;
    }
}
