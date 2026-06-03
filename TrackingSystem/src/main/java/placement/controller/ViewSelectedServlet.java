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

@WebServlet("/viewSelected")
public class ViewSelectedServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        Placementservice service = new PlacementServiceImpl();

        List<placementpojo> list =
                service.getByStatus("Selected");

        out.println("<html><head>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:#0f172a;color:white;padding:20px;}");
        out.println("table{width:100%;border-collapse:collapse;background:white;color:black;}");
        out.println("th{background:#00c6ff;color:white;padding:12px;}");
        out.println("td{padding:10px;text-align:center;border:1px solid #ccc;}");
        out.println("</style>");

        out.println("</head><body>");

        out.println("<h2 style='color:#00e5ff'>Selected Students</h2>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Student ID</th>");
        out.println("<th>Company ID</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");

        for (placementpojo p : list) {

            out.println("<tr>");

            out.println("<td>" + p.getId() + "</td>");
            out.println("<td>" + p.getStudentId() + "</td>");
            out.println("<td>" + p.getCompanyId() + "</td>");
            out.println("<td>" + p.getStatus() + "</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("</body></html>");
    }
}