package org.sergey.ans.interceptor;

import org.sergey.ans.controller.user.RegistrationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static org.sergey.ans.controller.user.AuthenticationController.ATTRIBUTE_AUTH_USER;
import static org.sergey.ans.controller.user.AuthenticationController.URL_AUTHENTICATION_CONTROLLER;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session != null) {
            if (session.getAttribute(ATTRIBUTE_AUTH_USER) != null) {
                logger.info(this.getClass().getName() + ": authenticated user in session.");
                return true;
            } else {
                logger.info(this.getClass().getName() + ": authenticated user not in session.");
                response.sendRedirect(URL_AUTHENTICATION_CONTROLLER);
                return false;
            }
        } else {
            response.sendRedirect(URL_AUTHENTICATION_CONTROLLER);
            logger.info(this.getClass().getName() + ": session is null.");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
