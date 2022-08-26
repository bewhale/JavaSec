package org.bewhale.javasec.controller.componentsvul;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/fastjson")
public class FastJson {

    @RequestMapping("")
    public String fastJson(@RequestBody String content) {
        try {
            // 转换成object
            JSONObject jsonToObject = JSON.parseObject(content);
            return jsonToObject.get("name").toString();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
