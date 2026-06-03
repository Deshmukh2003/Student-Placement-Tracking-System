package placement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.model.CompanyPojo;
import placement.service.CompanyService;
import placement.service.CompanyServiceImpl;

@WebServlet("/viewCompany")
public class ViewCompanyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        CompanyService service = new CompanyServiceImpl();
        List<CompanyPojo> list = service.getAllCompanies();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Company</title>");

        /* ===== CSS START ===== */
        out.println("<style>");

        out.println("body{");
        out.println("font-family:Arial;");
        out.println("background:linear-gradient(270deg,#0f172a,#1e1b4b,#0b1220,#1f2937);");
        out.println("color:white;");
        out.println("padding:30px;");
        out.println("}");

        out.println("h2{");
        out.println("text-align:center;");
        out.println("color:#00e5ff;");
        out.println("margin-bottom:20px;");
        out.println("}");

        /* ⭐ SCROLL FIX */
        out.println(".table-container{");
        out.println("width:100%;");
        out.println("overflow-x:auto;");
        out.println("}");

        out.println("table{");
        out.println("width:100%;");
        out.println("min-width:900px;");
        out.println("border-collapse:collapse;");
        out.println("background:rgba(255,255,255,0.08);");
        out.println("backdrop-filter:blur(10px);");
        out.println("border-radius:10px;");
        out.println("overflow:hidden;");
        out.println("}");

        out.println("th{");
        out.println("background:#00c6ff;");
        out.println("padding:12px;");
        out.println("color:white;");
        out.println("}");

        out.println("td{");
        out.println("padding:12px;");
        out.println("text-align:center;");
        out.println("border-bottom:1px solid rgba(255,255,255,0.1);");
        out.println("color:#e2e8f0;");
        out.println("}");

        out.println("tr:hover{");
        out.println("background:rgba(0,255,255,0.1);");
        out.println("transition:0.3s;");
        out.println("}");

        out.println("</style>");
        /* ===== CSS END ===== */

        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Company List</h2>");

        /* ⭐ WRAPPER FOR SCROLL */
        out.println("<div class='table-container'>");

        out.println("<table>");

        /* TABLE HEADER */
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Role</th>");
        out.println("<th>Package</th>");
        out.println("<th>Location</th>");
        out.println("<th>Eligibility</th>");
        out.println("<th>Drive Date</th>");
        out.println("</tr>");

        /* DATA ROWS */
        for (CompanyPojo c : list) {

            out.println("<tr>");

            out.println("<td>" + c.getId() + "</td>");
            out.println("<td>" + c.getName() + "</td>");
            out.println("<td>" + c.getRole() + "</td>");
            out.println("<td>" + c.getPackageName() + "</td>");
            out.println("<td>" + c.getLocation() + "</td>");
            out.println("<td>" + c.getEligibility() + "</td>");
            out.println("<td>" + c.getDriveDate() + "</td>");

            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}