package placement.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.model.ApplicationPojo;
import placement.service.ApplicationService;
import placement.service.ApplicationServiceImpl;

@WebServlet("/apply")
public class ApplyServlet extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int studentId = Integer.parseInt(req.getParameter("sid"));
        int companyId = Integer.parseInt(req.getParameter("cid"));

        ApplicationPojo a = new ApplicationPojo();
        a.setStudentId(studentId);
        a.setCompanyId(companyId);
        a.setStatus("Pending");

        ApplicationService service = new ApplicationServiceImpl();
        service.apply(a);

        resp.sendRedirect("viewCompany");
    }
}