package org.anshin.filters;

import org.anshin.validators.AbstractValidator;
import org.anshin.validators.ParameterValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "CalculatorServlet")
public class CalculatorServletFilter extends HttpFilter {
    private static final AbstractValidator PARAMETER_VALIDATOR = new ParameterValidator();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String firstValue = req.getParameter("firstValue");
        String secondValue = req.getParameter("secondValue");
        String operation = req.getParameter("operation");

        if (PARAMETER_VALIDATOR.isValidValueForField(firstValue,"number")
                && PARAMETER_VALIDATOR.isValidValueForField(secondValue,"number")
                && PARAMETER_VALIDATOR.isValidValueForField(operation,"operation")) {
            chain.doFilter(req, res);
        } else {
            res.getWriter().write(PARAMETER_VALIDATOR.getErrorMessage());
        }
    }
}
