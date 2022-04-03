package com.teachmeskills.lesson_27.task.web;

import com.teachmeskills.lesson_27.task.entity.User;
import com.teachmeskills.lesson_27.task.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationUserServlet extends HttpServlet {

    private static final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userService.findUserByLogin(login);

        if (user.getPassword().equals(password)) {
            req.getSession().setAttribute("user", user);
            resp.getWriter().println("Successful authorization!");
        } else {
            resp.getWriter().println("Wrong Password!!!");
        }
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

}
