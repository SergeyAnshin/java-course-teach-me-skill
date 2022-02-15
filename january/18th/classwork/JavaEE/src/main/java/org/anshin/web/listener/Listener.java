package org.anshin.web.listener;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.enums.Operation;
import org.anshin.handler.EntityListHandler;
import org.anshin.handler.ValueListIterator;
import org.anshin.mapper.repository.RepositoryEntityMapper;
import org.anshin.mapper.repository.impl.RepositoryCalculationResultMapper;
import org.anshin.mapper.repository.impl.RepositoryUserMapper;
import org.anshin.repository.CalculationResultRepository;
import org.anshin.repository.ConnectionPool;
import org.anshin.repository.UserRepository;
import org.anshin.repository.impl.jdbcstorage.CalculationResultJDBCRepository;
import org.anshin.repository.impl.jdbcstorage.UserJDBCRepository;
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
    private static final String DRIVER_NAME = "org.postgresql.Driver";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName(DRIVER_NAME).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RepositoryEntityMapper<User> repositoryUserMapper = new RepositoryUserMapper();
        UserRepository userRepository = new UserJDBCRepository(repositoryUserMapper);
        UserService userService = new UserServiceImpl(userRepository);

        RepositoryEntityMapper<CalculationResult> calculationResultMapper = new RepositoryCalculationResultMapper();
        CalculationResultRepository resultRepository = new CalculationResultJDBCRepository(calculationResultMapper);
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
        ValueListIterator<User> valueListIterator = new EntityListHandler<>(new UserJDBCRepository());
        se.getSession().setAttribute(ATTRIBUTE_USER_VALUE_LIST_ITERATOR, valueListIterator);
    }
}
