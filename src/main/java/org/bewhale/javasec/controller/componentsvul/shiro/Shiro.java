package org.bewhale.javasec.controller.componentsvul.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;


@RestController
@RequestMapping("/home/shiro")
public class Shiro {
    @PostMapping("/login")
    public String login(String username, String password, String rememberMe) {
        if (username.equals("") || password.equals(""))
            return "请输入用户名和密码";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if (rememberMe.equals("true")) {
            System.out.println(rememberMe);
            token.setRememberMe(true);
        }
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return "用户名不存在";
        } catch (AuthenticationException e) {
            return "认证失败";
        }
        return "登录成功";
    }

    @GetMapping("/getUser")
    public Object getUser() {
        return SecurityUtils.getSubject().toString();
    }

    @GetMapping("/notics")
    public String notics() {
        return "通知";
    }


    @RequestMapping(value = "/getkey")
    public String  getShiroKey() {
        try {
            byte[] key = new CookieRememberMeManager().getCipherKey();
            return "shiro key: \n" + new String(Base64.getEncoder().encode(key));
        } catch (Exception e) {
            return e.toString();
        }
    }

}