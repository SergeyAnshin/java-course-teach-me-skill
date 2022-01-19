package org.anshin.servlets;

import org.anshin.services.CalculatorService;
import org.anshin.services.impl.CalculatorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/history")
public class CalculationHistoryServlet extends HttpServlet {
    private final CalculatorService<String> calculatorService = new CalculatorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write(calculatorService.getCalculationHistory().toString());
    }
}
