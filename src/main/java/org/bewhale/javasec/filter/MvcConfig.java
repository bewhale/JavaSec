package org.bewhale.javasec.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/error", "/login", "/index", "/captcha", "/admin/login", "/admin/logout", "/api/*", "/css/*", "/images/*", "/upload/*", "/js/*", "/lib/*", "/page/*", "/unauth/*", "/shiro", "/home/shiro/*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/resources/static/upload/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("xss/reflect").setViewName("/basevul/xss/reflect");
        registry.addRedirectViewController("xss/store", "/home/xss/store");
        registry.addViewController("rce/runtime").setViewName("/basevul/rce/runtime");
        registry.addViewController("rce/loadjs").setViewName("/basevul/rce/loadjs");
        registry.addViewController("rce/groovy").setViewName("/basevul/rce/groovy");
        registry.addViewController("rce/processbuilder").setViewName("/basevul/rce/processbuilder");
        registry.addViewController("rce/processimpl").setViewName("/basevul/rce/processimpl");
        registry.addViewController("spel").setViewName("/basevul/spel/spel");
        registry.addViewController("ssti/thymeleaf").setViewName("/basevul/ssti/thymeleaf");
        registry.addViewController("ssti/noreturn").setViewName("/basevul/ssti/noreturn");
        registry.addViewController("sqli/jdbc_int_based").setViewName("/basevul/sqli/jdbc_int_based");
        registry.addViewController("sqli/jdbc_error_based").setViewName("/basevul/sqli/jdbc_error_based");
        registry.addViewController("sqli/jdbc_blind_time_based").setViewName("/basevul/sqli/jdbc_blind_time_based");
        registry.addViewController("sqli/mybatis_orderby").setViewName("/basevul/sqli/mybatis_orderby");
        registry.addViewController("sqli/mybatis_like").setViewName("/basevul/sqli/mybatis_like");
        registry.addViewController("sqli/mybatis_in").setViewName("/basevul/sqli/mybatis_in");
        registry.addViewController("ssrf").setViewName("/basevul/ssrf");
        registry.addViewController("xxe/xmlreader").setViewName("basevul/xxe/xmlreader");
        registry.addViewController("xxe/saxreader").setViewName("basevul/xxe/saxreader");
        registry.addViewController("xxe/saxbuilder").setViewName("basevul/xxe/saxbuilder");
        registry.addViewController("xxe/documentbuilder").setViewName("basevul/xxe/documentbuilder");
        registry.addViewController("xxe/unmarshaller").setViewName("basevul/xxe/unmarshaller");
        registry.addViewController("deserialize/readobject").setViewName("/deserialize/readobject");
        registry.addViewController("deserialize/xmldecoder").setViewName("/deserialize/xmldecoder");
        registry.addViewController("deserialize/yaml").setViewName("/deserialize/yaml");
        registry.addViewController("deserialize/rmi").setViewName("/deserialize/rmi");
        registry.addViewController("redirect").setViewName("basevul/redirect");
        registry.addViewController("file/upload").setViewName("/basevul/file/upload");
        registry.addViewController("file/download").setViewName("/basevul/file/download");
        registry.addViewController("xff").setViewName("/basevul/xff");
        registry.addViewController("unauth/info").setViewName("/basevul/unauth");
        registry.addViewController("cors").setViewName("/basevul/cors");
        registry.addViewController("xstream").setViewName("/components/xstream");
        registry.addViewController("fastjson").setViewName("/components/fastjson");
        registry.addViewController("jackson").setViewName("/components/jackson");
        registry.addViewController("shiro").setViewName("/components/shiro");
        registry.addViewController("actuators/index").setViewName("/components/actuators/index");
        registry.addViewController("actuators/jolokialogback").setViewName("/components/actuators/jolokialogback");
        registry.addViewController("log4j").setViewName("/components/log4j");
    }

}
