//package placement.controller;
//
//import java.io.IOException;
//
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
///**
// * Servlet implementation class AdminDashboardServlet
// */
//@WebServlet("/admin-dashboard")
//public class AdminDashboardServlet extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		HttpSession session = request.getSession(false);
//
//		if (session != null && session.getAttribute("adminUser") != null) {
//			response.sendRedirect("admin-dashboard.html");
//		} else {
//			response.sendRedirect("admin-login.html");
//		}
//	}
//}

package placement.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin-dashboard")
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // CHECK SESSION
        if (session != null && session.getAttribute("adminUser") != null) {

            // FORWARD to dashboard page
            RequestDispatcher rd = request.getRequestDispatcher("admin-dashboard.html");
            rd.forward(request, response);

        } else {

            // NOT LOGGED IN → send to login page
            response.sendRedirect("admin-login.html");
        }
    }
}