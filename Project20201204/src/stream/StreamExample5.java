package stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.stream.Stream;

public class StreamExample5 {
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
		
		//2.선적부서:급여합계(평균)
		System.out.println("40번 부서의 사원>>>");
		OptionalDouble avg = list.stream().filter(t-> t.getDepartmentId()==40)
		.mapToInt((e) -> e.getSalary())
		.average();
		System.out.println("평균: "+ avg.orElse(0.0)); //값이 없으면 ()안에 타입으로 출력해라>>.orElse
		avg.ifPresent(new DoubleConsumer() { //avg값에 값이 있으면 출력해라 >> ifPresent

			@Override
			public void accept(double value) {
				System.out.println("급여평균>>> " + avg.getAsDouble());
				
			}
			
		});
		
	
		
	}
}
