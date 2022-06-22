package org.bewhale.javasec.controller.componentsvul;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/log4j")
public class Log4j {
    private static final Logger logger = LogManager.getLogger(Log4j.class);

    @RequestMapping("")
    public String log4j(String content) {
        logger.error(content);
        return "Log4j2 JNDI Injection";
    }
}
