package stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HrStreamMethod {
	public static void main(String[] args) {
		Connection conn = DAO.getConnection();
		PreparedStatement pstm;
		ResultSet rs;
		String sql;

		// salary:10000이상인 사원 출력
		// 사원번호, 이름, 메일, 급여

		sql = "select* from emp1"; // 전체가지고 와서 stream으로 필터링
		List<sql> list = Arrays.asList(); // employeeVO 배열을 list로 편하게 변환
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery("select* from emp1;");
			while (rs.next()) {
				Stream<EmployeeVO> fs = list.stream();
				fs.filter((salary) -> salary.getSalary() > 10000).forEach(
						s -> System.out.println(s.getEmployeeId() + s.getFirstName() + s.geteMail() + s.getSalary()));
				list.add(fs);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		return list;

		// 선적부서:급여합계(평균)

		// 급여(5000~10000)
		// 사원번호, 이름, 메일, 급여
	}

}
