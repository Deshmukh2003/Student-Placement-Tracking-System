package placement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.model.StudentPojo;
import placement.service.StudentService;
import placement.service.StudentServiceImpl;

@WebServlet("/viewStudent")
public class ViewStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
                         throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        StudentService ss = new StudentServiceImpl();

        List<StudentPojo> list = ss.getAllStudents();

        out.println("<html>");
        out.println("<head>");

        out.println("<title>View Students</title>");

        out.println("<style>");

        out.println("body{");
        out.println("font-family:Arial;");
        out.println("background:#0f172a;");
        out.println("color:white;");
        out.println("padding:30px;");
        out.println("}");

        out.println("table{");
        out.println("width:100%;");
        out.println("border-collapse:collapse;");
        out.println("background:white;");
        out.println("color:black;");
        out.println("}");

        out.println("th{");
        out.println("background:#00c6ff;");
        out.println("padding:12px;");
        out.println("}");

        out.println("td{");
        out.println("padding:10px;");
        out.println("border:1px solid gray;");
        out.println("text-align:center;");
        out.println("}");

        out.println("a{");
        out.println("padding:8px 14px;");
        out.println("background:red;");
        out.println("color:white;");
        out.println("text-decoration:none;");
        out.println("border-radius:5px;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Student List</h2>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Mobile</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");

        for(StudentPojo s : list) {

            out.println("<tr>");

            out.println("<td>"+s.getId()+"</td>");
            out.println("<td>"+s.getName()+"</td>");
            out.println("<td>"+s.getEmail()+"</td>");
            out.println("<td>"+s.getMobile()+"</td>");

            out.println("<td>");
            out.println("<a href='deleteStudent?id="
                    +s.getId()+
                    "'>Delete</a>");
            out.println("</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}