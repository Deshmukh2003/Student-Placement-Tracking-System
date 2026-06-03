package placement.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student-drives")
public class StudentPlacementDrivesServlet extends HttpServlet {

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
            "<h2>🚀 Placement Drives</h2>" +

            "<h3>🔥 Ongoing Drives</h3>" +
            "<ul>" +
            "<li>TCS - Software Engineer (Last Date: 20 May)</li>" +
            "<li>Infosys - System Engineer (Last Date: 22 May)</li>" +
            "</ul>" +

            "<h3>📅 Upcoming Drives</h3>" +
            "<ul>" +
            "<li>Wipro - Java Developer (25 May)</li>" +
            "<li>Accenture - Analyst (30 May)</li>" +
            "</ul>" +

            "<br><a href='student-dashboard'>⬅ Back</a>"
        );
    }
}