package report.d0125;
import java.io.*;
import java.sql.*;

public class SqlCmd {

	public static Connection getConnection()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		//String driverName = new BufferedReader(new FileReader("c:\\config\\db.txt")).readLine();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "hr", "hr");
		return con;
	}

	public static void createExeUpdate(String createSql, String str)
			throws FileNotFoundException, IOException, SQLException, Exception {

		Connection con = SqlCmd.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(createSql);
		if (str == "table") {
			System.out.println("Table 생성완료");
		} else if (str == "insert") {
			System.out.println("Table Data Insert 완료");
		} else if (str == "delete") {
			System.out.println("Table Data Delete 완료");
		}
		try {
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
		}
	}
	
	
}// end of class
