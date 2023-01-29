import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteJDBC {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection con = null;
		Statement stmt = null;
		try {
			String driverName = new BufferedReader(new FileReader("c:\\config\\db.txt")).readLine();
			Class.forName(driverName);

			con = DriverManager.getConnection(url, "scott", "tiger");
			stmt = con.createStatement();
			String sql1 = "DELETE FROM firstJDBC WHERE no=3";

			int n = stmt.executeUpdate(sql1);
			System.out.println("DELETE된 RECORD의 수는 : " + n + "개의 행이 삭제 됐습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println("\n==>Driver Loading시 Exception 발생\n");
			e.getStackTrace();
		} catch (SQLException e) {
			System.out.println("\n==>JDBC 절차중 Exception 발생\n");
			e.getStackTrace();
		} catch (IOException e) {
			System.out.println("\n==>File Reading중 Exception 발생\n");
			e.getStackTrace();
		} catch (Exception e) {
			System.out.println("\n==>예상외의 Exception 발생\n");
			e.getStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("\n==>JDBC 절차중 Exception 발생\n");
				e.getStackTrace();
			}
		}
	}

}
