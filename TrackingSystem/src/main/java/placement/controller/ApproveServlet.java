package placement.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.service.ApplicationService;
import placement.service.ApplicationServiceImpl;

@WebServlet("/approve")
public class ApproveServlet extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        ApplicationService service = new ApplicationServiceImpl();
        service.updateStatus(id, "Selected");

        resp.sendRedirect("viewApplications");
    }
}