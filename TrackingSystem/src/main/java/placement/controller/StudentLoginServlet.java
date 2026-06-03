package placement.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import placement.service.PlacementServiceImpl;
import placement.service.Placementservice;

@WebServlet("/login")
public class StudentLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Servlet called...........");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Placementservice service = new PlacementServiceImpl();

        boolean result = service.loginCheck(email, password);

        System.out.println("result is " + result);

        if (result) {

            HttpSession session = request.getSession();

            session.setAttribute("studentUser", email);

            // temporary logic
            String name = email.split("@")[0];

            session.setAttribute("studentName", name);
            session.setAttribute("studentCourse", "Final Year CSE");

            response.sendRedirect(
                request.getContextPath() + "/student-dashboard.html");

        } else {

            // IMPORTANT FIX
            response.sendRedirect(
                request.getContextPath() + "/student-login.html?error=1");
        }
    }
}