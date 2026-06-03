package placement.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student-dashboard")
public class StudentDashboardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("studentUser") != null) {
			response.sendRedirect(request.getContextPath() + "/student-dashboard.html");
		} else {
			response.sendRedirect(request.getContextPath() + "/student-login.html");
		}
	}
}
