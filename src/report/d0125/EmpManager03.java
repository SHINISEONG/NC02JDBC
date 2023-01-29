package report.d0125;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class EmpManager03 {
	public static void printEmployee(String city, int lo, int hi) throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		Connection con = SqlCmd.getConnection();
		PreparedStatement pr = con.prepareStatement("SELECT\r\n"
				+ "	e.last_name, d.department_name\r\n"
				+ "	FROM\r\n"
				+ "	employees e, departments d, locations l\r\n"
				+ "	WHERE\r\n"
				+ "	e.department_id = d.department_id\r\n"
				+ "	AND d.location_id = l.location_id\r\n"
				+ "	AND l.city = ?\r\n"
				+ "	AND e.salary BETWEEN ? AND ?");
		pr.setString(1, city);
		pr.setInt(2, lo);
		pr.setInt(3, hi);
		ResultSet rs = pr.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t"+rs.getString(2));
		}
		if (con != null) con.close();
		if (pr != null) pr.close();
		if (rs != null) rs.close();
		
	}
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		EmpManager03.printEmployee("South San Francisco", 7000, 10000);
	}

}
