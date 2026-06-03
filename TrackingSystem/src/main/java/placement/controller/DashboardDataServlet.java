package placement.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.service.ApplicationServiceImpl;
import placement.service.CompanyServiceImpl;
import placement.service.StudentServiceImpl;

@WebServlet("/dashboardData")
public class DashboardDataServlet extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        StudentServiceImpl studentService = new StudentServiceImpl();
        CompanyServiceImpl companyService = new CompanyServiceImpl();
        ApplicationServiceImpl appService = new ApplicationServiceImpl();

        int students = studentService.getTotalStudents();
        int companies = companyService.getTotalCompanies();
        int applications = appService.getTotalApplications();

        resp.setContentType("text/plain");

        resp.getWriter().print(
            students + "," + companies + "," + applications
        );
    }
}