package org.bewhale.javasec.controller.componentsvul;

import com.thoughtworks.xstream.XStream;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/xstream")
public class Xstream {
    @RequestMapping("")
    public String vul(@RequestBody String content) {
        try {
            XStream xs = new XStream();
            xs.fromXML(content);
            return "XStream Vul";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
