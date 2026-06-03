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

@WebServlet("/update-profile")
public class UpdateStudentProfile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String qualification = request.getParameter("qualification");
        String branch = request.getParameter("branch");
        String skills = request.getParameter("skills");

        placementpojo p = new placementpojo();

        p.setEmail(email);
        p.setName(name);
        p.setMobile(mobile);
        p.setQualification(qualification);
        p.setBranch(branch);
        p.setSkills(skills);

        Placementservice service = new PlacementServiceImpl();

        boolean status = service.updateStudent(p);

        if (status) {
            response.sendRedirect("student-profile");
        } else {
            response.getWriter().println("<h2>Update Failed</h2>");
        }
    }
}