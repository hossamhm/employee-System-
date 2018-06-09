package application;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
 

public class DBInfo {
	
	// get connection with the DB
	public static Connection getConnection(){
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/javafxdb";
			con = (Connection) DriverManager.getConnection(url, "root","123456789");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return con;

	}
	
	// add new employee
	public static int save(Employee emp){
		
		int st = 0;
		
		try {
			String sql = "INSERT INTO `employee`( `empname`, `emppwd`, `empdept`, `salary`,`address`) VALUES (?,?,?,?,?)";
			Connection con = DBInfo.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			
			preparedStatement.setString(1, emp.getEmpname());
			preparedStatement.setString(2, emp.getPassword());
			preparedStatement.setString(3, emp.getDepartment());
			preparedStatement.setFloat(4, emp.getSalary());
			preparedStatement.setString(5, emp.getAddress());
			
			
			st = preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
		
	}
	
	
	// update existing employee's Info
	public static int update(Employee emp){
		
		int st = 0;
		
		try {
			String sql = "UPDATE `employee` SET `empname`=?,`empdept`=?,`salary`=?,`address`=? WHERE id= ?";
			Connection con = DBInfo.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			
			preparedStatement.setString(1, emp.getEmpname());
			preparedStatement.setString(2, emp.getDepartment());
			preparedStatement.setFloat(3, emp.getSalary());
			preparedStatement.setString(4, emp.getAddress());
			preparedStatement.setInt(5, emp.getId());
			
			st = preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
		
	}
	
	// delete existing Employee
	public static int delete(int id){
	
	int st = 0;
	
	try {
		String sql = "DELETE FROM `employee` WHERE id=?";
		Connection con = DBInfo.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		 
		preparedStatement.setInt(1, id);
		
		st = preparedStatement.executeUpdate();
		
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return st;
	
}
	
	// get Employee from DB using his ID
	public static Employee  getEmployeeId(int id){
	
	Employee emp = new Employee();
	
	try {
		String sql = "SELECT * FROM `employee` WHERE id=?";
		Connection con = DBInfo.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
  			
			emp.setId(resultSet.getInt(1));
			emp.setEmpname(resultSet.getString(2));
			emp.setPassword(resultSet.getString(3));
			emp.setDepartment(resultSet.getString(4));
			emp.setSalary(resultSet.getFloat(5));
			emp.setAddress(resultSet.getString(6));
		}

		
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return emp;
	
}


	// get List of Employees in DB
	public static List<Employee>  getEmployee(){
	
	List<Employee> list = new ArrayList<Employee>();
 
	
	try {
		String sql = "SELECT * FROM `employee` WHERE 1";
		Connection con = DBInfo.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		
		while (resultSet.next()) {
			Employee emp = new Employee();
			
			emp.setId(resultSet.getInt(1));
			emp.setEmpname(resultSet.getString(2));
			emp.setPassword(resultSet.getString(3));
			emp.setDepartment(resultSet.getString(4));
			emp.setSalary(resultSet.getFloat(5));
			emp.setAddress(resultSet.getString(6));
			list.add(emp);
			
		}

		
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
}	
	

}
