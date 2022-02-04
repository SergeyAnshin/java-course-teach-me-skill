package org.anshin.web.filter;

import org.anshin.validator.AbstractValidator;
import org.anshin.validator.ParameterValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.web.servlet.ServletConstants.*;
import static org.anshin.validator.ParameterValidator.FIELD_NAME_NUMBER;
import static org.anshin.validator.ParameterValidator.FIELD_NAME_OPERATION;

@WebFilter(servletNames = NAME_CALCULATOR_SERVLET)
public class CalculatorServletFilter extends HttpFilter {
    private final AbstractValidator parameterValidator = new ParameterValidator();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equalsIgnoreCase(METHOD_POST)) {
            String firstValue = req.getParameter(PARAMETER_CALCULATOR_FIRST_VALUE);
            String secondValue = req.getParameter(PARAMETER_CALCULATOR_SECOND_VALUE);
            String operationType = req.getParameter(PARAMETER_CALCULATOR_OPERATION_TYPE);

            if (parameterValidator.isValidValueForField(firstValue, FIELD_NAME_NUMBER)
                    && parameterValidator.isValidValueForField(secondValue, FIELD_NAME_NUMBER)
                    && parameterValidator.isValidValueForField(operationType, FIELD_NAME_OPERATION)) {
                chain.doFilter(req, res);
            } else {
                req.setAttribute(ATTRIBUTE_WRONG_PARAMETER_MESSAGE, parameterValidator.getErrorMessage());
                req.getServletContext().getRequestDispatcher(PATH_CALCULATOR_JSP).forward(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}
