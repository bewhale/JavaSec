package org.bewhale.javasec.controller.basevul;

import org.bewhale.javasec.util.HTTP;
import org.bewhale.javasec.util.Security;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/ssrf")
public class SSRFVul {

    @RequestMapping("")
    public String urlConnection(@RequestParam String url, String isHttp, String isIntranet) {
        if (url.equals("")) {
            return "请输入url";
        }

        if (isHttp != null && isHttp.equals("true")) {
            if (!Security.isHttp(url)) {
                return "不允许非http/https协议!!!";
            }
        }
        if (isIntranet != null && isIntranet.equals("true")) {
            if (Security.isIntranet(url)) {
                return "不允许访问内网!!!";
            }
        }

        String results = HTTP.URLConnection(url);

        return results;
    }
}
