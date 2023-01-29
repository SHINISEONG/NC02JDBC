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
			System.out.println("DELETE�� RECORD�� ���� : " + n + "���� ���� ���� �ƽ��ϴ�.");

		} catch (ClassNotFoundException e) {
			System.out.println("\n==>Driver Loading�� Exception �߻�\n");
			e.getStackTrace();
		} catch (SQLException e) {
			System.out.println("\n==>JDBC ������ Exception �߻�\n");
			e.getStackTrace();
		} catch (IOException e) {
			System.out.println("\n==>File Reading�� Exception �߻�\n");
			e.getStackTrace();
		} catch (Exception e) {
			System.out.println("\n==>������� Exception �߻�\n");
			e.getStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("\n==>JDBC ������ Exception �߻�\n");
				e.getStackTrace();
			}
		}
	}

}
