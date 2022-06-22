package org.bewhale.javasec.controller.componentsvul.actuators;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/home/actuators")
public class WEPS {
    @RequestMapping("/weps")
    public String wepsRce(String id) {
        int total = 100;
        String message = String.format("You've read %s books, and there are %d left", id, total - Integer.valueOf(id));
        return message;
    }

}
