package org.anshin.web.servlet.calculator;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.enums.Operation;
import org.anshin.service.CalculationResultService;
import org.anshin.service.CalculatorService;
import org.anshin.service.impl.CalculationResultServiceImpl;
import org.anshin.service.impl.CalculatorServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_CALCULATOR_SERVLET, name = NAME_CALCULATOR_SERVLET)
public class CalculatorServlet extends HttpServlet {
    private CalculatorService<Double, Operation> calculatorService;
    private CalculationResultService resultService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        calculatorService = (CalculatorServiceImpl) config.getServletContext()
                .getAttribute(ATTRIBUTE_CALCULATOR_SERVICE);
        resultService = (CalculationResultServiceImpl) config.getServletContext()
                .getAttribute(ATTRIBUTE_CALCULATION_RESULT_SERVICE);
        config.getServletContext().setAttribute(ATTRIBUTE_OPERATION_TYPES, Operation.values());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_CALCULATOR_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double firstValue = Double.parseDouble(req.getParameter(PARAMETER_CALCULATOR_FIRST_VALUE));
        double secondValue = Double.parseDouble(req.getParameter(PARAMETER_CALCULATOR_SECOND_VALUE));
        Operation operationType = Operation.valueOf(req.getParameter(PARAMETER_CALCULATOR_OPERATION_TYPE));

        CalculationResult result = calculatorService.calculate(firstValue, secondValue, operationType);

        User user = (User) req.getSession().getAttribute(ATTRIBUTE_SESSION_AUTH_USER);
        result.setUser(user);

        resultService.save(result);
        req.setAttribute(ATTRIBUTE_CALCULATION_RESULT, result);

        req.getServletContext().getRequestDispatcher(PATH_CALCULATOR_JSP).forward(req, resp);
    }
}
