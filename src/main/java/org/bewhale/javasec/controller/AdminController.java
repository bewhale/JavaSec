package org.bewhale.javasec.controller;

import com.wf.captcha.utils.CaptchaUtil;
import org.bewhale.javasec.model.Admin;
import org.bewhale.javasec.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    @SuppressWarnings("all")
    AdminService adminService;

    @RequestMapping({"/", "/index", "/login", "/admin"})
    public String index(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return "redirect:/home";
        }
        return "redirect:/admin/login";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        model.addAttribute("results", session.getAttribute("username"));
        return "/admin/home";
    }

    @GetMapping("/admin/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.invalidate();
        return "注销成功，请重新登录！";
    }

    @RequestMapping("/admin/login")
    public String login(String username, String password,
//                        @RequestParam(name = "password", required = true) String password,
                        String captcha, String path,
                        HttpSession session, HttpServletRequest request, Model model) {

        if (request.getMethod().equals("GET"))
            return "login";

        if (!CaptchaUtil.ver(captcha, request)) {
            CaptchaUtil.clear(request);
            model.addAttribute("msg", "验证码不正确");
            return "login";
        }
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            session.setAttribute("username", username);
            if (path != null) {
                return "redirect:" + path;
            }
            return "redirect:/home";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }

    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }

    @GetMapping("/admin/password")
    public String chPwdView() {
        return "/admin/password";
    }

    @PostMapping("/admin/chpwd")
    @ResponseBody
    public String changePassword(@RequestBody Map<String, String> map, HttpSession session) {
        String old_password = map.get("old_password");
        String new_password = map.get("new_password");
        String again_password = map.get("again_password");
        String username = (String) session.getAttribute("username");
        if (old_password == null || new_password == null || again_password == null) {
            return "输入不能为空!";
        }
        if (old_password.equals(new_password)) {
            return "新密码不能与旧密码一致!";
        }
        if (!new_password.equals(again_password)) {
            return "新密码两次输入不一致!";
        }
        Admin admin = adminService.login(username, old_password);
        if (admin != null) {
            if (adminService.updatePWD(username, new_password) != 0) {
                session.invalidate();
                return "密码修改成功!";
            } else {
                return "密码修改失败!";
            }
        } else {
            return "旧密码输入错误!";
        }
    }

    @RequestMapping("/admin/index")
    public String adminIndex(Model model , HttpSession session) {
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("date",  df.format(day));
        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("os",  System.getProperty("os.name"));
        model.addAttribute("java",   System.getProperty("java.version"));
        return "admin/index";
    }
}
