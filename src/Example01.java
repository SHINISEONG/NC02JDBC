import java.sql.*;
import java.io.*;
public class Example01 {

	public static void main(String[] args) {
		String sqlStr = "CREATE TABLE member(" + "no		NUMBER," + "id		VARCHAR2(10),"
				+ "pwd		VARCHAR2(10))";
		try {
			SqlCmd.createExeUpdate(sqlStr, "table");
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
		}
	}
}
