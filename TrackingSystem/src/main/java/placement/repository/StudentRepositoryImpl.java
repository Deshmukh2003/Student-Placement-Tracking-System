package placement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import placement.db.DBConnection;
import placement.model.StudentPojo;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public List<StudentPojo> getAllStudents() {

        List<StudentPojo> list = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement("SELECT * FROM student");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                StudentPojo s = new StudentPojo();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setMobile(rs.getString("mobile"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int getTotalStudents() {

        int count = 0;

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement("SELECT COUNT(*) FROM student");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public boolean deleteStudent(int id) {

        boolean status = false;

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement("DELETE FROM student WHERE id=?");

            ps.setInt(1, id);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}