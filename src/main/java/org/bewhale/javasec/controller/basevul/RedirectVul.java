package org.bewhale.javasec.controller.basevul;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/redirect")
public class RedirectVul {
    @RequestMapping("")
    public String redirect(String url) {
        return "redirect:" + url;
    }

////    public ModelAndView redirect(String url) {
////        return new ModelAndView("redirect://" + url);
////    }
//
//    public void redirect(String url, HttpServletResponse response) throws IOException {
//        response.sendRedirect(url);
//    }
}
