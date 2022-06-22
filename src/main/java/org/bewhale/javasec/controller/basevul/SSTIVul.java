package org.bewhale.javasec.controller.basevul;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/ssti")
public class SSTIVul {

    @RequestMapping("/thymeleaf")
    public String thymeleaf(String content) {
        return "user/" + content + "/welcome"; //template path is tainted
    }

    @RequestMapping("/noreturn/{content}")
    public void noReturn(String content) {
        System.out.println("ok");
    }
}
