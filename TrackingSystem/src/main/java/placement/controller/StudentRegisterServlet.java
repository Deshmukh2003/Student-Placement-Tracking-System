package placement.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.model.placementpojo;
import placement.service.PlacementServiceImpl;
import placement.service.Placementservice;

@WebServlet("/SRSer")

public class StudentRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
		placementpojo p = new placementpojo();
		p.setName(name);
		p.setEmail(email);
		p.setMobile(mobile);
		p.setPassoutYear(passoutYear);
		p.setConfirmPassword(password);
		p.setGender(gender);
		p.setQualification(qualification);
		p.setBranch(branch);
		p.setPassoutYear(passoutYear);
		p.setSkills(skills);

		Placementservice pserv = new PlacementServiceImpl();
		boolean res = pserv.isAdd(p);

		if (res) {
			System.out.println("login success");
		} else {
			System.out.println("login not");
		}

	}

}