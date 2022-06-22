package org.bewhale.javasec.controller.basevul;

import org.bewhale.javasec.model.Xss;
import org.bewhale.javasec.service.XssService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home/xss")
public class XSSVul {
    final XssService xssService;

    public XSSVul(XssService xssService) {
        this.xssService = xssService;
    }

    @RequestMapping("/reflect")
    public String xssReflect(String content, Model model) {
        model.addAttribute("results", content);
        return "/basevul/xss/reflect";
    }

    @RequestMapping("/store")
    public String xssInsert(String content, String clear, Model model) {
        try {
            if (clear != null) {
                xssService.clear();
                model.addAttribute("results", "清除成功");
                return "/basevul/xss/store";
            }
            if (content !=null && !content.equals("")) {
                xssService.setContent(new Xss(content));
                model.addAttribute("results", "添加成功");
            }
            List<String> list = xssService.getContent();
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("results", e.toString());
        }
        return "/basevul/xss/store";
    }
}
