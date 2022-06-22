package org.bewhale.javasec.controller.basevul;

import org.bewhale.javasec.model.Admin;
import org.bewhale.javasec.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/home/cors")
public class CORSVul {

    @Autowired
    @SuppressWarnings("all")
    AdminService adminService;

    @GetMapping("")
    public String corsVul(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        // origin头可控
        String origin = request.getHeader("origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        String username = (String) httpSession.getAttribute("username");
        Admin admin = adminService.getInfoByUserName(username);
        return "登录用户名: " + admin.getUsername() + ", 密码: " + admin.getPassword();
    }
}
