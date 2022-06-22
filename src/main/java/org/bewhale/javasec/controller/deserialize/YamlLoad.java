package org.bewhale.javasec.controller.deserialize;

import org.yaml.snakeyaml.Yaml;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/deserialize")
public class YamlLoad {

    @RequestMapping("/yaml")
    public String  yaml(String content, Model model) {
        try {
            Yaml y = new Yaml();
            y.load(content);
            model.addAttribute("results", "执行成功！");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("results", e.toString());
        }
        return "deserialize/yaml";
    }
}
