package org.anshin.web.servlet.user;

import org.anshin.entity.User;
import org.anshin.service.UserService;
import org.anshin.service.impl.UserServiceImpl;
import org.anshin.validator.AbstractValidator;
import org.anshin.validator.UserValidator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_NEW_KEYWORD_SERVLET, name = NAME_NEW_KEYWORD_SERVLET)
public class NewKeywordServlet extends HttpServlet {
    private AbstractValidator userValidator = new UserValidator();
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserServiceImpl) config.getServletContext().getAttribute(ATTRIBUTE_USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(URL_USER_SETTINGS_SERVLET);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.removeAttribute(ATTRIBUTE_WRONG_VALUE_MESSAGE);
        String keyword = req.getParameter(PARAMETER_KEYWORD);
        if (userValidator.isValidValueForField(keyword, "keyword")) {
            User user = (User) req.getSession().getAttribute(ATTRIBUTE_SESSION_AUTH_USER);
            user.setKeyword(keyword);
            userService.update(user);
            resp.sendRedirect(URL_USER_SETTINGS_SERVLET);
        } else {
            req.setAttribute(ATTRIBUTE_WRONG_VALUE_MESSAGE, userValidator.getErrorMessage());
            req.getServletContext().getRequestDispatcher(PATH_USER_SETTINGS_JSP).forward(req, resp);
        }
    }
}
