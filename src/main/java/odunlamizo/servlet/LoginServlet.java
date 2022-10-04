package odunlamizo.servlet;

import static odunlamizo.util.PasswordUtils.checkPassword;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import odunlamizo.model.User;
import odunlamizo.repository.UserRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserRepository userRepository = UserRepository.getInstance();
        User userWithIdAndPassword = userRepository.findUserWithIdAndPassword(username);
        if(!checkPassword(password, Objects.isNull(userWithIdAndPassword) ? null : userWithIdAndPassword.getPassword())) {
            HttpSession session = request.getSession(false);
            session.setAttribute("attemptedLogin?", true);
            response.sendRedirect("");
        }else {
            HttpSession session = request.getSession(false);
            session.setAttribute("user", userRepository.find(userWithIdAndPassword.getId()));
            response.sendRedirect("dashboard");
        }
    }

}