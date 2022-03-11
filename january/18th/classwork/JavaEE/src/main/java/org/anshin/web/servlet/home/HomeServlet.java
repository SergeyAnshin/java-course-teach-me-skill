package org.anshin.web.servlet.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.anshin.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_HOME_SERVLET, name = NAME_HOME_SERVLET)
public class HomeServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(HomeServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Logger work!");
        req.getServletContext().getRequestDispatcher(PATH_HOME_JSP).forward(req, resp);
    }
}
