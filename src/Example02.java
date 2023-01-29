import java.sql.*;
import java.util.*;

public class Example02 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		/*
		 * String[] sql = new String[3]; System.out.println("no를 입력하세요 : "); sql[0] =
		 * scanner.next(); System.out.println("id를 입력하세요 : "); sql[1] = scanner.next();
		 * System.out.println("pwd를 입력하세요 : "); sql[2] = scanner.next(); String str =
		 * "INSERT INTO member	VALUES ( " + sql[0] + ",'" + sql[1] + "','" + sql[2] +
		 * "')"; SqlCmd.createExeUpdate(str, "insert");
		 */
		Connection con = SqlCmd.getConnection();
		PreparedStatement prStmt = con.prepareStatement("INSERT INTO member VALUES(?,?,?)");
		System.out.println("no를 입력하세요 : ");
		prStmt.setInt(1, scanner.nextInt());
		System.out.println("id를 입력하세요 : ");
		prStmt.setString(2, scanner.next());
		System.out.println("pwd를 입력하세요 : ");
		prStmt.setString(3, scanner.next());
		int conf = prStmt.executeUpdate();
		if (conf > 0) {
			System.out.println(conf + "개 DATA INSERT 완료");
		} else {
			System.out.println("데이터 입력 실패");
		}

	}
}
