package org.bewhale.javasec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @RequestMapping("/test")
    public String index() {
        return "hello springboot";
    }
}
