package org.bewhale.javasec.controller.deserialize;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;

@Controller
@RequestMapping("/home/deserialize")
public class ObjectInputStream {

    @RequestMapping("/readobject")
    public String objectInputStream(String content, Model model) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();

            // 坑：读取的base64内容，加号会被转空格
            content = content.replace(" ", "+");

            byte[] bytes = decoder.decodeBuffer(content);

            // 将字节转为输入流
            ByteArrayInputStream stream = new ByteArrayInputStream(bytes);

            // 反序列化流，将序列化的原始数据恢复为对象
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(stream);
            in.readObject();
            in.close();
            model.addAttribute("results", "执行成功！");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("results", e.toString());
        }
        return "/deserialize/readobject";
    }
}
