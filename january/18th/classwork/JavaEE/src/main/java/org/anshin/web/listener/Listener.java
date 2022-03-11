package org.anshin.web.listener;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.enums.Operation;
import org.anshin.valuelisthandler.EntityListHandler;
import org.anshin.valuelisthandler.EntityListIterator;
import org.anshin.mapper.dao.EntityMapperDAO;
import org.anshin.mapper.dao.impl.CalculationResultMapperDAO;
import org.anshin.mapper.dao.impl.UserMapperDAO;
import org.anshin.dao.CalculationResultDAO;
import org.anshin.dao.ConnectionPool;
import org.anshin.dao.UserDAO;
import org.anshin.dao.impl.jdbcstorage.CalculationResultJDBCDAO;
import org.anshin.dao.impl.jdbcstorage.UserJDBCDAO;
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
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import java.lang.reflect.InvocationTargetException;

import static org.anshin.web.servlet.ServletConstants.*;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName(DRIVER_NAME).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        EntityMapperDAO<User> repositoryUserMapper = new UserMapperDAO();
        UserDAO userDAO = new UserJDBCDAO(repositoryUserMapper);
        UserService userService = new UserServiceImpl(userDAO);

        EntityMapperDAO<CalculationResult> calculationResultMapper = new CalculationResultMapperDAO();
        CalculationResultDAO resultRepository = new CalculationResultJDBCDAO(calculationResultMapper);
        CalculationResultService resultService = new CalculationResultServiceImpl(resultRepository);

        CalculatorService<Double, Operation> calculatorService = new CalculatorServiceImpl();

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

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        EntityListIterator<User> entityListIterator = new EntityListHandler<>(new UserJDBCDAO());
        se.getSession().setAttribute(ATTRIBUTE_USER_VALUE_LIST_ITERATOR, entityListIterator);
    }
}
