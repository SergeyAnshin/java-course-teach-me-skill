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

/**
 * need try-catch?
 */
@WebServlet(urlPatterns = URL_DELETE_CALCULATION_RESULT_SERVLET, name = NAME_DELETE_CALCULATION_RESULT_SERVLET)
public class DeleteCalculationHistoryServlet extends HttpServlet {
    private CalculationResultService resultService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        resultService = (CalculationResultServiceImpl) config.getServletContext()
                .getAttribute(ATTRIBUTE_CALCULATION_RESULT_SERVICE);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter(PARAMETER_CALCULATION_RESULT_ID) != null) {
            Long id = Long.parseLong(req.getParameter(PARAMETER_CALCULATION_RESULT_ID));
            resultService.deleteById(id);
        } else {
            String deleteAll = req.getParameter(PARAMETER_CALCULATION_RESULT_DELETE_ALL);
            if (deleteAll != null && !deleteAll.isBlank()) {
                User user = (User) req.getSession().getAttribute(ATTRIBUTE_SESSION_AUTH_USER);
                resultService.deleteAllByUser(user);
            }
        }



        resp.sendRedirect(URL_CALCULATION_HISTORY_SERVLET);
    }
}
