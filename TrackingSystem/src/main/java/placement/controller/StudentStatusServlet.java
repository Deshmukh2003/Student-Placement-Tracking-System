package placement.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student-status")
public class StudentStatusServlet extends HttpServlet {

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
            "<h2>📊 Application Status</h2>" +
            "<ul>" +
            "<li>TCS → Pending</li>" +
            "<li>Infosys → Selected</li>" +
            "<li>Wipro → Rejected</li>" +
            "</ul>" +
            "<br><a href='student-dashboard'>⬅ Back</a>"
        );
    }
}