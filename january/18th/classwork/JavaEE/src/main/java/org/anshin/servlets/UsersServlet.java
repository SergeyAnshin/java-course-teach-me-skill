package org.anshin.servlets;

import org.anshin.entities.User;
import org.anshin.services.UserService;
import org.anshin.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/users", name = "UsersServlet")
public class UsersServlet extends HttpServlet {
    private final UserService<User> userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(userService.findAll().toString());
    }
}
