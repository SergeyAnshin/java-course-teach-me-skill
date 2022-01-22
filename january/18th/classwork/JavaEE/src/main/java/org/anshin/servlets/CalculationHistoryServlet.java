package org.anshin.servlets;

import org.anshin.entities.CalculationResult;
import org.anshin.entities.User;
import org.anshin.enums.Operation;
import org.anshin.services.CalculationResultService;
import org.anshin.services.impl.CalculationResultServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/history", name = "CalculationHistoryServlet")
public class CalculationHistoryServlet extends HttpServlet {
    private final CalculationResultService<CalculationResult<String>> calculatorService =
            new CalculationResultServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        User user = (User) req.getSession().getAttribute(User.SESSION_ATTRIBUTE);
        resp.getWriter().write(calculatorService.findAllByUser(user).toString());
    }
}
