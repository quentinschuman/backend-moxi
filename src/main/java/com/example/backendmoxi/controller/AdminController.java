package com.example.backendmoxi.controller;

import com.example.backendmoxi.model.Admin;
import com.example.backendmoxi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend-moxi
 * User: quent
 * Date: 2018/6/23
 * Time: 10:24
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/login")
    public String loginGet(Model model){
        return "login";
    }

    @PostMapping("/admin/login")
    public String loginPost(Admin admin, Model model, HttpSession httpSession){
        Admin adminRes = adminService.findByNameAndPassword(admin);
        if ((adminRes != null)){
            httpSession.setAttribute("admin",adminRes);
            return "redirect:dashboard";
        }else {
            model.addAttribute("error","用户名或密码错误，请重新登录！");
            return "login";
        }
    }

    @GetMapping("/admin/register")
    public String register(Model model){
        return "register";
    }

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model){
        return "dashboard";
    }


}
