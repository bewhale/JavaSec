package org.bewhale.javasec.filter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String path = request.getRequestURI();

        if (username == null) {
//            request.setAttribute("msg", "请先登录！！！");
            response.sendRedirect("/admin/login?path=" + path);
//            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        } else {
            return true;
        }

    }
}
