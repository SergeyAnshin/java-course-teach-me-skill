package com.ans.serg.calculatorspringboot.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.ans.serg.calculatorspringboot.controller.UserController.ATTRIBUTE_AUTHENTICATED_USER;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    public static final String URL_LOGIN_PAGE = "/user/login";
    private final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute(ATTRIBUTE_AUTHENTICATED_USER) != null) {
            logger.info("AUTHENTICATION INTERCEPTOR - PRE HANDLE: authenticated user in session");
            return true;
        } else {
            logger.info("AUTHENTICATION INTERCEPTOR - PRE HANDLE: authenticated user not in session.");
            response.sendRedirect(URL_LOGIN_PAGE);
            return false;
        }
    }
}
