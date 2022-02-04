package org.anshin.web.servlet.calculator;

import org.anshin.entity.User;
import org.anshin.service.CalculationResultService;
import org.anshin.service.impl.CalculationResultServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_CALCULATION_HISTORY_SERVLET, name = NAME_CALCULATION_HISTORY_SERVLET)
public class CalculationHistoryServlet extends HttpServlet {
    private CalculationResultService resultService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        resultService = (CalculationResultServiceImpl) config.getServletContext()
                .getAttribute(ATTRIBUTE_CALCULATION_RESULT_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(ATTRIBUTE_SESSION_AUTH_USER);
        req.setAttribute(ATTRIBUTE_CALCULATION_HISTORY, resultService.findAllByUser(user));
        req.getServletContext().getRequestDispatcher(PATH_CALCULATION_HISTORY_JSP).forward(req, resp);
    }
}
