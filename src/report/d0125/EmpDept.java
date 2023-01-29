package report.d0125;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class EmpDept {
	public static void printEmpDept(int deptId) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection con = SqlCmd.getConnection();
		PreparedStatement pr = con.prepareStatement("	SELECT\r\n"
				+ "	e.employee_id, d.department_name, e.salary, iv.avgsal\r\n"
				+ "	FROM\r\n"
				+ "	employees e, departments d, (\r\n"
				+ "					SELECT\r\n"
				+ "					department_id, AVG(NVL(salary,0)) avgsal\r\n"
				+ "					FROM\r\n"
				+ "					employees\r\n"
				+ "					GROUP BY department_id\r\n"
				+ "					) iv\r\n"
				+ "	WHERE\r\n"
				+ "	e.department_id = d.department_id\r\n"
				+ "	AND e.department_id = iv.department_id\r\n"
				+ "	AND e.department_id = ?");
		pr.setInt(1, deptId);
		ResultSet rs = pr.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		for(int i = 0; i<rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i+1)+"\t");
		}
		System.out.println();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
		}
		if (con != null) con.close();
		if (rs != null) rs.close();
		if (pr != null) pr.close();
		
	}
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("부서 아이디를 입력하세요.");
		EmpDept.printEmpDept(scanner.nextInt());
		scanner.close();
	}

}
