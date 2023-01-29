package report.d0125;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class EmpManager02 {
	public static void printEmployee(String jobs[]) throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		Connection con = SqlCmd.getConnection();
		PreparedStatement pStmt = con.prepareStatement("SELECT\r\n"
				+ "	e.employee_id, e.first_name, e.salary\r\n"
				+ "	FROM\r\n"
				+ "	employees e, jobs j\r\n"
				+ "	WHERE\r\n"
				+ "	e.job_id = j.job_id\r\n"
				+ "	AND (j.job_title = ? \r\n"
				+ "	OR j.job_title = ?)");
		
		for(int i=0; i<jobs.length; i++) {
			pStmt.setString((i+1), jobs[i]);	
		}
		ResultSet rs = pStmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
		}
	}
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		String[] jobs = {"Accountant", "Stock Clerk"};
		EmpManager02.printEmployee(jobs);
	}

}
