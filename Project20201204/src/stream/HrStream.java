package stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class HrStream {
	
}
	
	Connection conn = getConnection();
	PreparedStatement pstm;
	ResultSet rs;
	String sql;
	
	public static void main(String[] args) {
		List<HrStreamMethod> employees = Arrays.asList();
		employees.stream().map(new Function<String,String>() {

			@Override
			public String apply(String t) {
				return null;
			}
			
		});
				
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try { // try catch는 예외상황이 발행할때 구문이 나오게 하는함수
			String user = "hr";
			String pw = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // xe(database 아이디)

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database에 연결되었습니다.\n");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
		return conn;

}
