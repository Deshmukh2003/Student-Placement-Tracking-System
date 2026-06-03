package placement.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.model.CompanyPojo;
import placement.service.CompanyService;
import placement.service.CompanyServiceImpl;

@WebServlet("/addCompany")
public class AddCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        CompanyPojo c = new CompanyPojo();

        c.setName(req.getParameter("name"));
        c.setRole(req.getParameter("role"));
        c.setPackageName(req.getParameter("companyPackage"));
        c.setLocation(req.getParameter("location"));
        c.setEligibility(req.getParameter("eligibility"));
        c.setDriveDate(req.getParameter("date"));

        CompanyService service = new CompanyServiceImpl();
        service.addCompany(c);

        resp.sendRedirect("viewCompany");
    }
}