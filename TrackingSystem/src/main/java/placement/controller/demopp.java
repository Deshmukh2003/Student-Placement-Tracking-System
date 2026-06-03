package placement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.db.DBConnection;

/**
 * Servlet implementation class demopp
 */
@WebServlet("/demopp")
public class demopp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String gender = request.getParameter("gender");
		String qualification = request.getParameter("qualification");
		String branch = request.getParameter("branch");
		String passoutYear = request.getParameter("passoutYear");
		String skills = request.getParameter("skills");

		System.out.println("name=" + name);

		try {

			Connection conn = DBConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO student(name,email,password,mobile,gender,qualification,branch,passoutYear,skills) VALUES(?,?,?,?,?,?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, mobile);
			ps.setString(5, gender);
			ps.setString(6, qualification);
			ps.setString(7, branch);
			ps.setString(8, passoutYear);
			ps.setString(9, skills);

			int result = ps.executeUpdate();

			if (result > 0) {

				response.sendRedirect("student-login.html");

			} else {

				response.getWriter().println("Registration Failed");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
