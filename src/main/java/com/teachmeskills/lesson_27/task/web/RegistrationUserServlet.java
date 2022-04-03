package com.teachmeskills.lesson_27.task.web;

import com.teachmeskills.lesson_27.task.entity.User;
import com.teachmeskills.lesson_27.task.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationUserServlet extends HttpServlet {

    private static final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = new User(name, login, password);
        boolean isAdd = userService.add(user);

        if (isAdd) {
            resp.getWriter().println("Completed successfully!");
        } else {
            resp.getWriter().println("Error!!!");
        }
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

}
