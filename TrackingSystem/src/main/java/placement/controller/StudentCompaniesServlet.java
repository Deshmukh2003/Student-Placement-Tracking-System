package placement.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student-companies")
public class StudentCompaniesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("studentUser") == null) {
            response.sendRedirect("student-login.html");
            return;
        }

        response.setContentType("text/html");

        response.getWriter().println(
            "<h2>🏢 Available Companies</h2>" +
            "<ul>" +
            "<li>TCS - Software Engineer (3.5 LPA)</li>" +
            "<li>Infosys - System Engineer (4 LPA)</li>" +
            "<li>Wipro - Java Developer (5 LPA)</li>" +
            "</ul>" +
            "<br><a href='student-dashboard'>⬅ Back</a>"
        );
    }
}