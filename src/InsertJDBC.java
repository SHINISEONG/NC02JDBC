import java.sql.*;
import java.io.*;

public class InsertJDBC {

	public static void InsertValue(String createSql) throws FileNotFoundException, IOException, SQLException, Exception {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		// try {
		String driverName = new BufferedReader(new FileReader("c:\\config\\db.txt")).readLine();
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		Statement stmt = con.createStatement();
		stmt.executeUpdate(createSql);
		System.out.println("TABLE DATA INSERT");

	}

}
