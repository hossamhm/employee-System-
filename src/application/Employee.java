package application;

 
public class Employee {

	private int id;
	private   String  empname;
	private String password;
	private   float  salary;
	private   String department;
	private   String address;
	 
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String empname, String password, float salary, String department, String address) {
		super();
		this.id = id;
		this.empname = empname;
		this.password = password;
		this.salary = salary;
		this.department = department;
		this.address = address;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmpname() {
		return empname;
	}


	public void setEmpname(String empname) {
		this.empname = empname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public float getSalary() {
		return salary;
	}


	public void setSalary(float salary) {
		this.salary = salary;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



	
	
	
	
	
	 
	
}
