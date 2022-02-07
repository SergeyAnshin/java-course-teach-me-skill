package org.anshin.web.listener;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.enums.Operation;
import org.anshin.repository.ConnectionPool;
import org.anshin.service.CalculationResultService;
import org.anshin.service.CalculatorService;
import org.anshin.service.UserService;
import org.anshin.service.impl.CalculationResultServiceImpl;
import org.anshin.service.impl.CalculatorServiceImpl;
import org.anshin.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

import static org.anshin.web.servlet.ServletConstants.*;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    private final UserService userService = new UserServiceImpl();
    private final CalculatorService<Double, Operation> calculatorService = new CalculatorServiceImpl();
    private final CalculationResultService resultService = new CalculationResultServiceImpl();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute(ATTRIBUTE_USER_SERVICE, userService);
        servletContext.setAttribute(ATTRIBUTE_CALCULATOR_SERVICE, calculatorService);
        servletContext.setAttribute(ATTRIBUTE_CALCULATION_RESULT_SERVICE, resultService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
        ConnectionPool.INSTANCE.destroyConnectionPool();
    }
}
