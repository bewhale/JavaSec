package org.bewhale.javasec.controller.basevul;

import org.apache.commons.lang.StringUtils;
import org.bewhale.javasec.model.Admin;
import org.bewhale.javasec.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/unauth")
public class UnauthVul {
    @Autowired
    @SuppressWarnings("all")
    AdminService adminService;

    @RequestMapping("/userinfo")
    public String adminInfo(String username) {
        ArrayList<Admin> userInfo = new ArrayList<>();
        System.out.println(username);
        if (username.equals("")) {
            return "请输入用户名！";
        }
        if (username.equals("all")) {
            userInfo = adminService.getAllInfo();
        } else {
            Admin admin = adminService.getInfoByUserName(username);
            if (admin == null) {
                return "用户不存在!";
            }
            userInfo.add(admin);
        }
        return (StringUtils.strip(userInfo.toString(), "[]")).replace(", ", "");
    }
}
