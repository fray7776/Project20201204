package stream;

public class EmployeeVO {
	private int employeeId;
	private String firstName;
	private String eMail;
	private int salary;
	private int departmentId;
	

	public EmployeeVO() {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.eMail = eMail;
		this.salary = salary;
		this.departmentId = departmentId;
		
	}


	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public void showEmpInfo() {
		System.out.println("사원번호: " + employeeId + " 성: " + firstName + " 이메일: " + eMail + " 급여: " + salary
				+"부서: "+departmentId);

	}
}
