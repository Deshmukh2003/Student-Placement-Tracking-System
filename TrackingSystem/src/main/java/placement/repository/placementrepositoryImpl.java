package placement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import placement.db.DBConnection;
import placement.model.placementpojo;

public class placementrepositoryImpl implements placementrepository {

    // =========================
    // REGISTER STUDENT
    // =========================
    @Override
    public boolean isAdd(placementpojo ps) {

        String sql = "INSERT INTO student(name,email,password,mobile,gender,qualification,branch,passoutYear,skills) "
                   + "VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps1 = conn.prepareStatement(sql)) {

            ps1.setString(1, ps.getName());
            ps1.setString(2, ps.getEmail());
            ps1.setString(3, ps.getPassword());
            ps1.setString(4, ps.getMobile());
            ps1.setString(5, ps.getGender());
            ps1.setString(6, ps.getQualification());
            ps1.setString(7, ps.getBranch());
            ps1.setString(8, ps.getPassoutYear());
            ps1.setString(9, ps.getSkills());

            return ps1.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    // =========================
    // STUDENT LOGIN
    // =========================
    @Override
    public boolean loginCheck(String email, String password) {

        String sql = "SELECT * FROM student WHERE email=? AND password=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    // =========================
    // ADMIN LOGIN
    // =========================
    @Override
    public boolean adminCheck(String username, String password) {

        String sql = "SELECT * FROM admin WHERE trim(username)=? AND trim(password)=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username.trim());
            ps.setString(2, password.trim());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    // =========================
    // PROFILE FEATURE (NEW)
    // =========================
    @Override
    public placementpojo getStudentByEmail(String email) {

        placementpojo p = null;

        String sql = "SELECT * FROM student WHERE email=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                p = new placementpojo();

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));
                p.setMobile(rs.getString("mobile"));
                p.setGender(rs.getString("gender"));
                p.setQualification(rs.getString("qualification"));
                p.setBranch(rs.getString("branch"));
                p.setPassoutYear(rs.getString("passoutYear"));
                p.setSkills(rs.getString("skills"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    // =========================
    // PLACEMENT STATUS (EXISTING)
    // =========================
    @Override
    public List<placementpojo> getByStatus(String status) {

        List<placementpojo> list = new ArrayList<>();

        String sql = "SELECT * FROM student_placement WHERE status=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                placementpojo p = new placementpojo();

                p.setId(rs.getInt("id"));
                p.setStudentId(rs.getInt("student_id"));
                p.setCompanyId(rs.getInt("company_id"));
                p.setStatus(rs.getString("status"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

	@Override
	public boolean updateStudent(placementpojo p) {
		// TODO Auto-generated method stub
		return false;
	}
}