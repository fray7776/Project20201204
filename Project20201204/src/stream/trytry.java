package stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class trytry {
	public static void main(String[] args) {
		Connection conn = DAO.getConnection();
		List<EmployeeVO> list = new ArrayList<>();
		try {
			PreparedStatement psmt = conn.prepareStatement("select * from emp1");
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmployeeId(rs.getInt("Employee_id"));
				emp.setFirstName(rs.getString("First_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.seteMail(rs.getString("email"));
				emp.setDepartmentId(rs.getInt("department_id"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//10000이상인 사람
		list.stream().filter(t -> t.getSalary()>10000).forEach(s->s.showEmpInfo());
		
		//부서 50인 급여합계
		double avg =
		list.stream().filter(t->t.getDepartmentId()==50).mapToInt(t->t.getSalary()).average().getAsDouble();
		System.out.println(avg);
		
//		//급여가 5000~10000사이인 사원
//		list.stream().filter(t->t.getSalary()>5000).filter(t->t.getSalary()<10000).forEach(t->t.showEmpInfo());
		
		list.stream().filter(t->t.getSalary()>5000 && t.getSalary()<10000).forEach(t->t.showEmpInfo());
		
		
	}

}
