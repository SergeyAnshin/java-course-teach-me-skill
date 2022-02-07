package org.anshin.web.servlet.user;

import org.anshin.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_LOGOUT_SERVLET, name = NAME_LOGOUT_SERVLET)
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(URL_HOME_SERVLET);

    }


}
