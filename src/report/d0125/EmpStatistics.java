package report.d0125;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
public class EmpStatistics {

	public static void printStatistics(int maxSalary) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection con = SqlCmd.getConnection();
		PreparedStatement pStmt = con.prepareStatement("SELECT "
				+ "	j.job_title jt, AVG(NVL(e.salary,0)) avgsal "
				+ "	FROM "
				+ "	employees e, jobs j "
				+ "	WHERE "
				+ "	e.job_id = j.job_id "
				+ "	AND e.salary >= ? "
				+ "	GROUP BY "
				+ "	j.job_title "
				+ "	ORDER BY avgsal DESC");
		pStmt.setInt(1, maxSalary);
		
		
		
		System.out.println("===================================");
		System.out.println("Max Salary : "+ maxSalary);
		System.out.println("===================================");
		ResultSet rs = pStmt.executeQuery();
		while(rs.next()) {
			System.out.println("["+rs.getString(1)+"]\t"+rs.getInt(2));
		}
		if (pStmt != null) pStmt.close();
		if (rs != null) rs.close();
	}
	
	public static void main(String[] args) throws Exception {
		EmpStatistics.printStatistics(10000);
		EmpStatistics.printStatistics(15000);
	}
}
