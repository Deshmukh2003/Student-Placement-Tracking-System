package placement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import placement.db.DBConnection;
import placement.model.CompanyPojo;

public class CompanyRepositoryImpl implements CompanyRepository {

    @Override
    public boolean addCompany(CompanyPojo c) {

        boolean status = false;

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO company(name, role, package, location, eligibility, drive_date) VALUES(?,?,?,?,?,?)"
            );

            ps.setString(1, c.getName());
            ps.setString(2, c.getRole());
            ps.setString(3, c.getPackageName());
            ps.setString(4, c.getLocation());
            ps.setString(5, c.getEligibility());
            ps.setString(6, c.getDriveDate());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public List<CompanyPojo> getAllCompanies() {

        List<CompanyPojo> list = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement("SELECT * FROM company");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                CompanyPojo c = new CompanyPojo();

                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setRole(rs.getString("role"));
                c.setPackageName(rs.getString("package"));
                c.setLocation(rs.getString("location"));
                c.setEligibility(rs.getString("eligibility"));
                c.setDriveDate(rs.getString("drive_date"));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✅ NEW METHOD
    @Override
    public int getTotalCompanies() {

        int count = 0;

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                conn.prepareStatement("SELECT COUNT(*) FROM company");

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