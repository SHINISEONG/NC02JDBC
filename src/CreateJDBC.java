import java.io.*;
import java.sql.*;

public class CreateJDBC {

	public static void createTable(String createSql)
			throws FileNotFoundException, IOException, SQLException, Exception {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		// try {
		String driverName = new BufferedReader(new FileReader("c:\\config\\db.txt")).readLine();
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		Statement stmt = con.createStatement();
		stmt.executeUpdate(createSql);
		System.out.println("Table 생성완료");
		/*
		 * } catch (ClassNotFoundException e) {
		 * System.out.println("\n==>Driver Loading시 Exception 발생\n"); e.getStackTrace();
		 * } catch (SQLException e) {
		 * System.out.println("\n==>JDBC 절차중 Exception 발생\n"); e.getStackTrace(); }
		 * catch (IOException e) {
		 * System.out.println("\n==>File Reading중 Exception 발생\n"); e.getStackTrace(); }
		 * catch (Exception e) { System.out.println("\n==>예상외의 Exception 발생\n");
		 * e.getStackTrace(); } finally { try { if (stmt != null) stmt.close(); if (con
		 * != null) con.close(); } catch (SQLException e) {
		 * System.out.println("\n==>JDBC 절차중 Exception 발생\n"); e.getStackTrace(); } }
		 */

	}

}
