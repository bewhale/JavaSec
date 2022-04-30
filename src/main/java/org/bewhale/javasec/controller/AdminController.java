package org.bewhale.javasec.controller;

import org.bewhale.javasec.model.Admin;
import org.bewhale.javasec.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @GetMapping("")
    public String index() {
        return "admin/adminlogin";
    }

    @Autowired
    @SuppressWarnings("all")
    AdminService adminService;

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam(name="username", required =true) String username,
                        @RequestParam(name="password", required = true) String password){

        Admin admin = adminService.login(username, password);//调用service层抽象类方法,返回一个承接了数据库返回值的实体类
        if (admin != null) {//很简单的逻辑,返回的只要不是空值就说明是存在的,ok
            return "welcome adminster!" + admin;//返回一段文本
        }
        return "/err";//返回到另一个界面,但是目前还没做
    }
}
