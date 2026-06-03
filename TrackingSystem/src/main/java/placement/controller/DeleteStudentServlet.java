package placement.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import placement.service.StudentService;
import placement.service.StudentServiceImpl;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
                         throws ServletException, IOException {

        String idParam = req.getParameter("id");

        // safety check
        if (idParam == null || idParam.trim().isEmpty()) {
            resp.getWriter().println("Invalid ID");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);

            StudentService service = new StudentServiceImpl();
            boolean status = service.deleteStudent(id);

            if (status) {
                System.out.println("Student deleted successfully ID: " + id);
            } else {
                System.out.println("Delete failed for ID: " + id);
            }

            // always go back to list page
            resp.sendRedirect("viewStudent");

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error deleting student");
        }
    }
}