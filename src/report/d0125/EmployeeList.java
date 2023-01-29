package report.d0125;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class EmployeeList {
	public static void printEmployeeList(String cityName, String deptName) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		Connection con = SqlCmd.getConnection();
		PreparedStatement pr = con.prepareStatement("	SELECT\r\n"
				+ "	l.city, d.department_name, e.first_name, e.salary\r\n"
				+ "	FROM\r\n"
				+ "	employees e, departments d, locations l\r\n"
				+ "	WHERE\r\n"
				+ "	e.department_id = d.department_id\r\n"
				+ "	AND d.location_id = l.location_id\r\n"
				+ "	AND upper(l.city) LIKE upper(?)\r\n"
				+ "	AND upper(d.department_name) LIKE upper(?)");
		pr.setString(1, "%"+cityName+"%");
		pr.setString(2, "%"+deptName+"%");
		
		ResultSet rs = pr.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		printEmployeeList("lon","resource");
	}

}
