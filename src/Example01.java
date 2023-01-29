import java.sql.*;
import java.io.*;
public class Example01 {

	public static void main(String[] args) {
		String sqlStr = "CREATE TABLE member(" + "no		NUMBER," + "id		VARCHAR2(10),"
				+ "pwd		VARCHAR2(10))";
		try {
			SqlCmd.createExeUpdate(sqlStr, "table");
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
		}
	}
}
