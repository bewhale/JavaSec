package org.bewhale.javasec.controller.basevul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/home/xff")
public class XFFVul {

    @RequestMapping("")
    public String xffVul(HttpServletRequest request,String xff) {
        String ip = request.getRemoteAddr();
        if (xff.equals("true")) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip != null && ip.equals("10.0.0.1")) {
            return "你的ip为: " + ip +", 访问成功。";
        }
        return "你的ip为: " + ip +", 本资源仅允许 10.0.0.1 访问。";

    }
}
