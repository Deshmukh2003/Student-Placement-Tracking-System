package placement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.model.ApplicationPojo;
import placement.service.ApplicationService;
import placement.service.ApplicationServiceImpl;

@WebServlet("/viewApplications")
public class ViewApplicationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        ApplicationService service = new ApplicationServiceImpl();
        List<ApplicationPojo> list = service.getAll();

        out.println("<html><head>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:#0f172a;color:white;padding:20px;}");
        out.println("h2{color:#00e5ff;text-align:center;}");
        out.println("table{width:100%;border-collapse:collapse;background:white;color:black;margin-top:20px;}");
        out.println("th{background:#00c6ff;color:white;padding:12px;}");
        out.println("td{padding:10px;text-align:center;border:1px solid #ccc;}");
        out.println("tr:hover{background:#f1f5f9;}");
        out.println("a{font-weight:bold;}");
        out.println("</style>");

        out.println("</head><body>");

        out.println("<h2>All Applications</h2>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Student Name</th>");
        out.println("<th>Company Name</th>");
        out.println("<th>Status</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");

        if (list != null && !list.isEmpty()) {

            for (ApplicationPojo a : list) {

                out.println("<tr>");

                out.println("<td>" + a.getId() + "</td>");
                out.println("<td>" + a.getStudentName() + "</td>");
                out.println("<td>" + a.getCompanyName() + "</td>");
                out.println("<td>" + a.getStatus() + "</td>");

                out.println("<td>");
                out.println("<a href='approve?id=" + a.getId() + "' style='color:green'>Approve</a>");
                out.println(" | ");
                out.println("<a href='reject?id=" + a.getId() + "' style='color:red'>Reject</a>");
                out.println("</td>");

                out.println("</tr>");
            }

        } else {
            out.println("<tr><td colspan='5'>No Applications Found</td></tr>");
        }

        out.println("</table>");

        out.println("</body></html>");
    }
}