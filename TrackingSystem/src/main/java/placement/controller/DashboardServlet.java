package placement.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.service.ApplicationServiceImpl;
import placement.service.CompanyServiceImpl;
import placement.service.StudentServiceImpl;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        StudentServiceImpl studentService = new StudentServiceImpl();
        CompanyServiceImpl companyService = new CompanyServiceImpl();
        ApplicationServiceImpl appService = new ApplicationServiceImpl();

        int studentCount = studentService.getTotalStudents();
        int companyCount = companyService.getTotalCompanies();
        int applicationCount = appService.getTotalApplications();

        resp.setContentType("text/html");
        var out = resp.getWriter();

        out.println("<html><head>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:#0f172a;color:white;text-align:center;padding:40px;}");
        out.println(".card{background:#111827;padding:20px;margin:15px auto;width:300px;border-radius:12px;box-shadow:0 0 10px rgba(0,255,255,0.2);}");
        out.println("h2{color:#00e5ff;margin-bottom:30px;}");
        out.println("</style>");

        out.println("</head><body>");

        out.println("<h2>Dashboard Overview</h2>");

        out.println("<div class='card'>");
        out.println("<h3>Total Students: " + studentCount + "</h3>");
        out.println("</div>");

        out.println("<div class='card'>");
        out.println("<h3>Total Companies: " + companyCount + "</h3>");
        out.println("</div>");

        out.println("<div class='card'>");
        out.println("<h3>Total Applications: " + applicationCount + "</h3>");
        out.println("</div>");

        out.println("</body></html>");
    }
}