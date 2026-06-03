package placement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import placement.db.DBConnection;
import placement.model.ApplicationPojo;

public class ApplicationRepositoryImpl implements ApplicationRepository {

    @Override
    public boolean apply(ApplicationPojo a) {

        boolean status = false;

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO application(student_id, company_id, status) VALUES(?,?,?)"
            );

            ps.setInt(1, a.getStudentId());
            ps.setInt(2, a.getCompanyId());
            ps.setString(3, a.getStatus());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public List<ApplicationPojo> getAll() {

        List<ApplicationPojo> list = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                conn.prepareStatement("SELECT * FROM application");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ApplicationPojo a = new ApplicationPojo();

                a.setId(rs.getInt("id"));
                a.setStudentId(rs.getInt("student_id"));
                a.setCompanyId(rs.getInt("company_id"));
                a.setStatus(rs.getString("status"));

                list.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean updateStatus(int id, String status) {

        boolean result = false;

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                conn.prepareStatement("UPDATE application SET status=? WHERE id=?");

            ps.setString(1, status);
            ps.setInt(2, id);

            result = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // ✅ TOTAL APPLICATIONS
    @Override
    public int getTotalApplications() {

        int count = 0;

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                conn.prepareStatement("SELECT COUNT(*) FROM application");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ✅ COUNT BY STATUS (Pending / Selected / Rejected)
    @Override
    public int getCountByStatus(String status) {

        int count = 0;

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                conn.prepareStatement("SELECT COUNT(*) FROM application WHERE status=?");

            ps.setString(1, status);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}