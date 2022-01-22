package org.anshin.servlets;

import org.anshin.entities.CalculationResult;
import org.anshin.entities.User;
import org.anshin.services.CalculationResultService;
import org.anshin.services.CalculatorService;
import org.anshin.services.impl.CalculationResultServiceImpl;
import org.anshin.services.impl.CalculatorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calculator", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private final CalculatorService<String> calculatorService = new CalculatorServiceImpl();
    private final CalculationResultService<CalculationResult<String>> resultService =
            new CalculationResultServiceImpl();
    private final String parameters = "calculator?firstValue=1&secondValue=2&operation=sum";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstValue = req.getParameter("firstValue");
        String secondValue = req.getParameter("secondValue");
        String operation = req.getParameter("operation");

        CalculationResult<String> result = calculatorService.calculate(firstValue, secondValue, operation);

        User user = (User) req.getSession().getAttribute(User.SESSION_ATTRIBUTE);
        result.setUser(user);

        resultService.save(result);

        resp.getWriter().write(result.toString());
    }
}
