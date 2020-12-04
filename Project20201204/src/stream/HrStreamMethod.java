package stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db2.EmployeeVO;

public class HrStreamMethod {
	Connection conn = HrStream.getConnection();
	PreparedStatement pstm;
	ResultSet rs;
	String sql;
	
	
	//salary:10000이상인 사원 출력
		//사원번호, 이름, 메일, 급여
	public List<EmployeeVO> getDeptList(String dept) {
		sql = "SELECT employee_id, first_name, email, salary\r\n"
				+ "FROM emp1\r\n"
				+ "WHERE salary > 10000"; //전체가지고 와서 stream으로 필터링
		List<EmployeeVO> list = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				EmployeeVO vo= new EmployeeVO();
				vo.setEmployeeId(rs.getInt("employee_id"));
				vo.setFirstName(rs.getString("first_name"));
				vo.seteMail(rs.getString("email"));
				vo.setSalary(rs.getInt("salary"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			return list;
		}
		
		return list;
		
	}
	
	//선적부서:급여합계(평균)
	
	
	
	
	//급여(5000~10000)
	//사원번호, 이름, 메일, 급여
}
	