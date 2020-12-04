package stream;

public class EmployeeVO {
	private int employeeId; 
	private String firstName;
	private String eMail;
	private int salary;
	
	public EmployeeVO() {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.eMail = eMail;
		this.salary = salary;
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


}
