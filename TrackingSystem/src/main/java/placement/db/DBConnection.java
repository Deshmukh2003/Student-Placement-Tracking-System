//package placement.db;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DBConnection {
//
//	public static Connection getConnection() {
//		Connection conn = null;
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement", "root", "root");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return conn;
//	}
//}
package placement.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/placement",
                "root",
                "root"
            );

            System.out.println("DB Connected Successfully ✅");

        } catch (Exception e) {
            System.out.println("DB CONNECTION FAILED ❌");
            e.printStackTrace();   // IMPORTANT
        }

        return conn;
    }
}