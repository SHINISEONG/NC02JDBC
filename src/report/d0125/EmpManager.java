package report.d0125;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class EmpManager {
	public static void printEmployee(String name, int salary) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException{
		Connection con = SqlCmd.getConnection();
		PreparedStatement pStmt = con.prepareStatement("SELECT"
				+ "	employee_id eid, first_name fn, salary sal"
				+ "	FROM"
				+ "	employees"
				+ "	WHERE"
				+ "	upper(first_name) LIKE upper(?)"
				+ "	AND salary >= ?");
		pStmt.setString(1, "%"+name+"%");
		pStmt.setInt(2, salary);
		ResultSet rs = pStmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getInt(3));
		}
	}
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		EmpManager.printEmployee("al", 4000);
	}
}
