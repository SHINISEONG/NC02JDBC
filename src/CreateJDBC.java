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
		System.out.println("Table �����Ϸ�");
		/*
		 * } catch (ClassNotFoundException e) {
		 * System.out.println("\n==>Driver Loading�� Exception �߻�\n"); e.getStackTrace();
		 * } catch (SQLException e) {
		 * System.out.println("\n==>JDBC ������ Exception �߻�\n"); e.getStackTrace(); }
		 * catch (IOException e) {
		 * System.out.println("\n==>File Reading�� Exception �߻�\n"); e.getStackTrace(); }
		 * catch (Exception e) { System.out.println("\n==>������� Exception �߻�\n");
		 * e.getStackTrace(); } finally { try { if (stmt != null) stmt.close(); if (con
		 * != null) con.close(); } catch (SQLException e) {
		 * System.out.println("\n==>JDBC ������ Exception �߻�\n"); e.getStackTrace(); } }
		 */

	}

}
