import java.sql.*;
import java.util.*;

public class Example02 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		/*
		 * String[] sql = new String[3]; System.out.println("no�� �Է��ϼ��� : "); sql[0] =
		 * scanner.next(); System.out.println("id�� �Է��ϼ��� : "); sql[1] = scanner.next();
		 * System.out.println("pwd�� �Է��ϼ��� : "); sql[2] = scanner.next(); String str =
		 * "INSERT INTO member	VALUES ( " + sql[0] + ",'" + sql[1] + "','" + sql[2] +
		 * "')"; SqlCmd.createExeUpdate(str, "insert");
		 */
		Connection con = SqlCmd.getConnection();
		PreparedStatement prStmt = con.prepareStatement("INSERT INTO member VALUES(?,?,?)");
		System.out.println("no�� �Է��ϼ��� : ");
		prStmt.setInt(1, scanner.nextInt());
		System.out.println("id�� �Է��ϼ��� : ");
		prStmt.setString(2, scanner.next());
		System.out.println("pwd�� �Է��ϼ��� : ");
		prStmt.setString(3, scanner.next());
		int conf = prStmt.executeUpdate();
		if (conf > 0) {
			System.out.println(conf + "�� DATA INSERT �Ϸ�");
		} else {
			System.out.println("������ �Է� ����");
		}

	}
}
