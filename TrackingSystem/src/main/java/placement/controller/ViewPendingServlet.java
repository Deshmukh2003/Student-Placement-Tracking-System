package placement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.model.placementpojo;
import placement.service.PlacementServiceImpl;
import placement.service.Placementservice;

@WebServlet("/viewPending")
public class ViewPendingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        Placementservice service = new PlacementServiceImpl();

        List<placementpojo> list =
                service.getByStatus("Pending");

        out.println("<html>");
        out.println("<head>");

        out.println("<style>");

        out.println("body{");
        out.println("font-family:Arial;");
        out.println("background:#0f172a;");
        out.println("color:white;");
        out.println("padding:20px;");
        out.println("}");

        out.println("table{");
        out.println("width:100%;");
        out.println("border-collapse:collapse;");
        out.println("background:white;");
        out.println("color:black;");
        out.println("}");

        out.println("th{");
        out.println("background:#00c6ff;");
        out.println("color:white;");
        out.println("padding:12px;");
        out.println("}");

        out.println("td{");
        out.println("padding:10px;");
        out.println("text-align:center;");
        out.println("border:1px solid #ccc;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<h2 style='color:#00e5ff'>Pending Applications</h2>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Student</th>");
        out.println("<th>Company</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");

        for(placementpojo p : list) {

            out.println("<tr>");

            out.println("<td>"+p.getId()+"</td>");
            out.println("<td>"+p.getStudentId()+"</td>");
            out.println("<td>"+p.getCompanyId()+"</td>");
            out.println("<td>"+p.getStatus()+"</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}