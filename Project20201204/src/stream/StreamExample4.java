package stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class StreamExample4 {
	public static void main(String[] args) {
		Connection conn = DAO.getConnection();
		List<EmployeeVO> list = new ArrayList<>(); //예전에 만들었던 employeeVO를 가져와도됨! 나는 이미 만듬..
		try {
			PreparedStatement psmt =
			conn.prepareStatement("select* from emp1"); //쿼리가 길지 않으면 바로 적으면됨
			ResultSet rs = psmt.executeQuery();
		    while(rs.next()) {
		    	EmployeeVO emp = new EmployeeVO(); //인스턴스 선언, 지금은 전혀 뭐가 들어있지 않은상태
		    	//EmployeeVO에다가 값 담기
		    	emp.setEmployeeId(rs.getInt("employee_id"));
		    	emp.setFirstName(rs.getString("first_name"));
		    	emp.seteMail(rs.getString("email"));
		    	emp.setSalary(rs.getInt("salary"));
		    	emp.setDepartmentId(rs.getInt("department_Id"));
		    	list.add(emp);
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Stream<EmployeeVO> stream = list.stream(); //리스트로 stream만들기
		stream.forEach(s -> s.showEmpInfo());
		
		System.out.println("======================================================");
		
		//1.salary가 10000이상인 사람 도출
		System.out.println("salary가 10,000이상인 사원.>>>");
		list.stream().filter((t)-> t.getSalary()>10000)
		             .forEach(s->s.showEmpInfo());
		
		System.out.println("======================================================");
		
		//2.선적부서:급여합계(평균)
		System.out.println("선적부서의 급여합계>>>");
		double avg = list.stream().filter(t-> t.getDepartmentId()==40)
		.mapToInt(new ToIntFunction<EmployeeVO>() {

			@Override
			public int applyAsInt(EmployeeVO e) {
				return e.getSalary() ;
			}
			
		}).average().getAsDouble();
		System.out.println("급여합계: "+avg);
		
		System.out.println("======================================================");
		
		
		System.out.println("급여가 5000~10,000인 사원list>>>");
		list.stream().filter((t)->t.getSalary()>5000).filter((t)->t.getSalary()<10000)
		.forEach(t->t.showEmpInfo());
		
		System.out.println("40인 부서의 list>>>");
		
	
	}
}
