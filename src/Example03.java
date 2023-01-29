import java.util.Scanner;
import java.sql.*;
public class Example03 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		/*
		System.out.println("id를 입력하세요 : ");
		String str = "DELETE FROM member WHERE no=" + scanner.next();
		SqlCmd.createExeUpdate(str, "delete");
		*/
		Connection con = SqlCmd.getConnection();
		PreparedStatement pStmt = con.prepareStatement("DELETE FROM member WHERE id=?");
		System.out.println("id를 입력하세요 : ");
		pStmt.setString(1, scanner.next());
		System.out.println(pStmt.executeUpdate()+"개의 데이터 DELETE");
		if(pStmt != null) pStmt.close();
		scanner.close();
	}
}