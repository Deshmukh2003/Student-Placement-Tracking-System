package placement.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import placement.model.placementpojo;
import placement.service.PlacementServiceImpl;
import placement.service.Placementservice;

@WebServlet("/student-profile")
public class StudentProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("studentUser") == null) {
            response.sendRedirect("student-login.html");
            return;
        }

        String email = (String) session.getAttribute("studentUser");

        Placementservice service = new PlacementServiceImpl();

        placementpojo student = service.getStudentByEmail(email);

        if (student == null) {
            response.getWriter().println("No student found!");
            return;
        }

        response.setContentType("text/html");

        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>Student Profile</title>");

        // ================= CSS START =================
        response.getWriter().println("<style>");

        response.getWriter().println("*{margin:0;padding:0;box-sizing:border-box;}");

        response.getWriter().println("body{");
        response.getWriter().println("font-family:Arial, sans-serif;");
        response.getWriter().println("background:#eef2f7;");
        response.getWriter().println("display:flex;");
        response.getWriter().println("justify-content:center;");
        response.getWriter().println("align-items:center;");
        response.getWriter().println("height:100vh;");
        response.getWriter().println("}");

        response.getWriter().println(".profile-container{");
        response.getWriter().println("width:700px;");
        response.getWriter().println("background:white;");
        response.getWriter().println("padding:30px;");
        response.getWriter().println("border-radius:15px;");
        response.getWriter().println("box-shadow:0 5px 15px rgba(0,0,0,0.2);");
        response.getWriter().println("}");

        response.getWriter().println("h2{");
        response.getWriter().println("text-align:center;");
        response.getWriter().println("margin-bottom:25px;");
        response.getWriter().println("color:#2c3e50;");
        response.getWriter().println("}");

        response.getWriter().println("table{");
        response.getWriter().println("width:100%;");
        response.getWriter().println("border-collapse:collapse;");
        response.getWriter().println("}");

        response.getWriter().println("table td{");
        response.getWriter().println("padding:15px;");
        response.getWriter().println("border:1px solid #ddd;");
        response.getWriter().println("font-size:16px;");
        response.getWriter().println("}");

        response.getWriter().println(".label{");
        response.getWriter().println("background:#34495e;");
        response.getWriter().println("color:white;");
        response.getWriter().println("font-weight:bold;");
        response.getWriter().println("width:35%;");
        response.getWriter().println("}");

        response.getWriter().println("tr:nth-child(even){background:#f9f9f9;}");

        response.getWriter().println(".btn{");
        response.getWriter().println("display:inline-block;");
        response.getWriter().println("margin-top:25px;");
        response.getWriter().println("padding:12px 25px;");
        response.getWriter().println("background:#3498db;");
        response.getWriter().println("color:white;");
        response.getWriter().println("text-decoration:none;");
        response.getWriter().println("border-radius:8px;");
        response.getWriter().println("font-size:15px;");
        response.getWriter().println("}");

        response.getWriter().println(".btn:hover{");
        response.getWriter().println("background:#2980b9;");
        response.getWriter().println("}");

        response.getWriter().println("</style>");
        // ================= CSS END =================

        response.getWriter().println("</head>");
        response.getWriter().println("<body>");

        response.getWriter().println("<div class='profile-container'>");

        response.getWriter().println("<h2>👤 Student Profile</h2>");

        response.getWriter().println("<table>");

        response.getWriter().println("<tr><td class='label'>Name</td><td>" + student.getName() + "</td></tr>");
        response.getWriter().println("<tr><td class='label'>Email</td><td>" + student.getEmail() + "</td></tr>");
        response.getWriter().println("<tr><td class='label'>Mobile</td><td>" + student.getMobile() + "</td></tr>");
        response.getWriter().println("<tr><td class='label'>Gender</td><td>" + student.getGender() + "</td></tr>");
        response.getWriter().println("<tr><td class='label'>Qualification</td><td>" + student.getQualification() + "</td></tr>");
        response.getWriter().println("<tr><td class='label'>Branch</td><td>" + student.getBranch() + "</td></tr>");
        response.getWriter().println("<tr><td class='label'>Passout Year</td><td>" + student.getPassoutYear() + "</td></tr>");
        response.getWriter().println("<tr><td class='label'>Skills</td><td>" + student.getSkills() + "</td></tr>");

        response.getWriter().println("</table>");

        response.getWriter().println("<center>");
        response.getWriter().println("<a href='edit-profile' class='btn'>Edit Profile</a>");
        response.getWriter().println("<a href='student-dashboard.html' class='btn' style='margin-left:10px;'>Back</a>");
        response.getWriter().println("</center>");

        response.getWriter().println("</div>");

        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}