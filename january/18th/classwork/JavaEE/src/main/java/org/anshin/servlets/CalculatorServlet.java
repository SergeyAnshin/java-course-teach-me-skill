package org.anshin.servlets;

import org.anshin.services.CalculatorService;
import org.anshin.services.impl.CalculatorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    private final CalculatorService<String> calculatorService = new CalculatorServiceImpl();
    private final String parameters = "calculator?firstValue=1&secondValue=2&operation=add";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstValue = req.getParameter("firstValue");
        String secondValue = req.getParameter("secondValue");
        String operation = req.getParameter("operation");
        String result = calculatorService.calculate(firstValue, secondValue, operation);
        resp.getWriter().write(result);
    }
}
