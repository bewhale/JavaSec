package org.bewhale.javasec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("org.bewhale.javasec.dao")
//@SpringBootApplication(scanBasePackages = {"org.bewhale.javasec"})
@SpringBootApplication()
public class JavasecApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavasecApplication.class, args);
    }

}
