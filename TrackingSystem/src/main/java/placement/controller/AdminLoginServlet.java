////package placement.controller;
////
////import java.io.IOException;
////
////import jakarta.servlet.ServletException;
////import jakarta.servlet.annotation.WebServlet;
////import jakarta.servlet.http.HttpServlet;
////import jakarta.servlet.http.HttpServletRequest;
////import jakarta.servlet.http.HttpServletResponse;
////import jakarta.servlet.http.HttpSession;
////import placement.service.placementservice;
////import placement.service.placementserviceImpl;
////
/////**
//// * Servlet implementation class AdminloginServlet
//// */
////@WebServlet("/Admin")
////public class AdminloginServlet extends HttpServlet {
////
////	@Override
////	protected void doPost(HttpServletRequest request, HttpServletResponse response)
////			throws ServletException, IOException {
////		String username = request.getParameter("username");
////		String password = request.getParameter("password");
////
////		placementservice service = new placementserviceImpl();
////		boolean result = service.AdminCheck(username, password);
////		if (result) {
////			HttpSession session = request.getSession();
////			session.setAttribute("adminUser", username);
////
////			response.sendRedirect("admin-dashboard");
////		} else {
////			response.getWriter().println("Invalid Admin Credentials");
////		}
////	}
////
////}
//
//package placement.controller;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import placement.service.placementservice;
//import placement.service.placementserviceImpl;
//
//@WebServlet("/Admin")
//public class AdminloginServlet extends HttpServlet {
//
//    private placementservice service = new placementserviceImpl();
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        // 1. GET PARAMETERS
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        // 2. BASIC VALIDATION
//        if (username == null || password == null ||
//            username.trim().isEmpty() || password.trim().isEmpty()) {
//
//            response.getWriter().println("Username or Password cannot be empty");
//            return;
//        }
//
//        // 3. SERVICE CALL
//        boolean result = service.AdminCheck(username, password);
//
//        // 4. LOGIN SUCCESS
//        if (result) {
//
//            HttpSession session = request.getSession();
//            session.setAttribute("adminUser", username);
//
//            // IMPORTANT: use proper mapping
//            response.sendRedirect("admin-dashboard");
//
//        }
//        // 5. LOGIN FAIL
//        else {
//            response.getWriter().println("Invalid Admin Credentials");
//        }
//    }
//
//    // OPTIONAL: handle GET safely
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        response.sendRedirect("admin-login.html");
//    }
//}
package placement.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import placement.service.PlacementServiceImpl;

@WebServlet("/Admin")
public class AdminLoginServlet extends HttpServlet {

	private PlacementServiceImpl service = new PlacementServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("result is"+username);
		System.out.println("result is"+password);

		if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {

			response.sendRedirect("admin-login.html?error=empty");
			return;
		}

		boolean result = service.adminCheck(username, password);
		System.out.println("Result in servlet" + result);
		if (result) {

			HttpSession session = request.getSession();
			session.setAttribute("adminUser", username);

			response.sendRedirect("admin-dashboard.html");

		} else {
			response.sendRedirect("admin-login.html?error=invalid");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("admin-login.html");
	}
}