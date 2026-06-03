package placement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import placement.model.placementpojo;
import placement.service.PlacementServiceImpl;
import placement.service.Placementservice;

@WebServlet("/edit-profile")
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("studentUser") == null) {
            response.sendRedirect("student-login.html");
            return;
        }

        String email = (String) session.getAttribute("studentUser");

        Placementservice service = new PlacementServiceImpl();

        placementpojo student = service.getStudentByEmail(email);

        if (student == null) {
            out.println("<h2>Student Not Found</h2>");
            return;
        }

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Edit Profile</title>");

        out.println("<style>");
        out.println("body{font-family:Poppins;background:#eef2f7;}");
        out.println(".box{width:500px;margin:40px auto;background:white;padding:30px;border-radius:10px;box-shadow:0 5px 15px rgba(0,0,0,0.2);}");
        out.println("h2{text-align:center;margin-bottom:20px;color:#2c3e50;}");
        out.println("input{width:100%;padding:12px;margin:10px 0;border:1px solid #ccc;border-radius:6px;}");
        out.println("input:focus{border-color:#3498db;outline:none;}");
        out.println("button{width:100%;padding:12px;background:#3498db;color:white;border:none;border-radius:6px;}");
        out.println("button:hover{background:#2980b9;}");
        out.println(".back{text-align:center;display:block;margin-top:10px;color:#3498db;text-decoration:none;}");
        out.println("</style>");

        out.println("</head><body>");

        out.println("<div class='box'>");
        out.println("<h2>Edit Profile</h2>");

        out.println("<form action='update-profile' method='post'>");

        // ONLY ONE EMAIL FIELD (FIXED)
        out.println("<input type='hidden' name='email' value='" + student.getEmail() + "'>");

        out.println("<input type='text' name='name' value='" + student.getName() + "' required>");
        out.println("<input type='text' name='mobile' value='" + student.getMobile() + "' required>");
        out.println("<input type='text' name='qualification' value='" + student.getQualification() + "'>");
        out.println("<input type='text' name='branch' value='" + student.getBranch() + "'>");
        out.println("<input type='text' name='skills' value='" + student.getSkills() + "'>");

        out.println("<button type='submit'>Save Profile</button>");

        out.println("</form>");

        out.println("<a class='back' href='student-profile'>⬅ Back</a>");

        out.println("</div>");

        out.println("</body></html>");
    }
}