import java.io.*;
import java.sql.*;
public class Example04 {
	public static void main(String[] args) throws Exception {
		String driverName = new BufferedReader(new FileReader("c:\\config\\db.txt")).readLine();
		Class.forName(driverName);
		String url =  "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		String sql = "SELECT * FROM member";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println("회원정보 => 번호 : "+rs.getInt(1)+",\tid : "+rs.getString(2)+",\tpwd : "+rs.getString(3));
		}
		
	}
}
