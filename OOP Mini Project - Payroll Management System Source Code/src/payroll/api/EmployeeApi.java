package payroll.api;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import payroll.bean.Employee;
import payroll.db.DatabaseConnection;

/**
 * This class is to manage the data of employee in the database
 *
 */
public class EmployeeApi {
	
	/**
	 * This is the constructor for class EmployeeApi
	 */
	public EmployeeApi() {
		
	}
	
	/**
	 * This method add a new employee data into the database
	 * @param employee The employee parameter is an object of Employee class which carry data
	 * @return int The numbers of rows affected
	 * @throws Exception
	 */
	public int addEmployee(Employee employee) throws Exception
	{
		DatabaseConnection db = new DatabaseConnection();
		
		//Create a connection to the database
		Connection con = db.getConnection();
		
		//Create a string with a INSERT statement
		String sql = "INSERT INTO Employee (EmployeeName,EmployeeIC,EmployeeGender,EmployeePhone, EmployeeAddress,EmployeeEmail,EmployeeSalary,EmployeeDateHired,EmployeeOTRate) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, employee.getEmployeeName());
		ps.setString(2, employee.getEmployeeIdentificationCardNo());
		ps.setString(3, employee.getEmployeeGender());
		ps.setString(4, employee.getEmployeePhoneNo());
		ps.setString(5, employee.getEmployeeAddress());
		ps.setString(6, employee.getEmployeeEmail());
		ps.setDouble(7, employee.getEmployeeSalary());
		ps.setDate(8, employee.getEmployeeDateHired());
		ps.setDouble(9, employee.getEmployeeOTRatePerHour());
		
		//send the insert statement to the DBMS
		int status = ps.executeUpdate();
		
		System.out.println("The data is successfully added into database");
		
		ps.close();
		con.close();
		
		return status;
	}
	
	/**
	 * This method retrieve all the data of employee from the database
	 * @return ArrayList<Employee> An ArrayList of Employee object which contain data is returned
	 * @throws Exception
	 */
	public ArrayList<Employee> getEmployee() throws Exception
	{
		ArrayList<Employee> listemployee = new ArrayList<Employee>();
		DatabaseConnection db = new DatabaseConnection();
		
		//Create a connection to the database
		Connection con = db.getConnection();
		
		//Create a string with a SELECT statement
		String sql = "SELECT * FROM Employee";
		PreparedStatement ps = con.prepareStatement(sql);
		
		//send the SELECT statement to DBMS
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			//retrieve all the data of employee
			Employee employee = new Employee();
			
			//set the data to employee
			employee.setEmployeeId(rs.getInt("Employee_Id"));
			employee.setEmployeeName(rs.getString("EmployeeName"));
			employee.setEmployeeIdentificationCardNo(rs.getString("EmployeeIC"));
			employee.setEmployeeGender(rs.getString("EmployeeGender"));
			employee.setEmployeePhoneNo(rs.getString("EmployeePhone"));
			employee.setEmployeeAddress(rs.getString("EmployeeAddress"));
			employee.setEmployeeEmail(rs.getString("EmployeeEmail"));
			employee.setEmployeeSalary(rs.getDouble("EmployeeSalary"));
			employee.setEmployeeDateHired(rs.getDate("EmployeeDateHired"));
			employee.setEmployeeOTRatePerHour(rs.getDouble("EmployeeOTRate"));
			
			//add the employee to the ArrayList
			listemployee.add(employee);
		}
		
		ps.close();
		con.close();
		rs.close();
		
		return listemployee;
	}
	
	/**
	 * This method will get return a set of pair data with contain
	 * employee id and employee name
	 * @return HashMap<Integer,String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> getEmployeeIdName() throws Exception 
	{
		HashMap<Integer, String> mapemployee = new HashMap<Integer, String>();
		DatabaseConnection db = new DatabaseConnection();
		
		//Create a connection to the database
		Connection con = db.getConnection();
		
		//Create a string with a SELECT statement
		String sql = "SELECT Employee_Id, EmployeeName FROM Employee";
		PreparedStatement ps = con.prepareStatement(sql);
		
		//Send the SELECT statement to DBMS
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			mapemployee.put(rs.getInt("Employee_Id"), rs.getString("EmployeeName"));
		}
		ps.close();
		con.close();
		rs.close();
		
		return mapemployee;
		
	}
	
	/**
	 * This method will find an employee data using employee name
	 * @param employeeName This is String parameter that contain employee name
	 * @return Employee An employee object which contains the data of the employee that want to find is returned
	 * @throws EmployeeNotFoundException
	 * @throws Exception
	 */
	public Employee findEmployee(String employeeName) throws EmployeeNotFoundException, Exception
	{
		Employee employee = new Employee();
		DatabaseConnection db = new DatabaseConnection();
		
		//Create a connection to the database
		Connection con = db.getConnection();
		
		//Create a string with SELECT statement
		String sql = "SELECT * FROM Employee WHERE EmployeeName = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		//to set ? with value
		ps.setString(1, employeeName);
		
		//send the statement to the DBMS
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()==true) {
			//retrieve data of employee
			employee.setEmployeeId(rs.getInt("Employee_Id"));
			employee.setEmployeeName(rs.getString("EmployeeName"));
			employee.setEmployeeIdentificationCardNo(rs.getString("EmployeeIC"));
			employee.setEmployeeGender(rs.getString("EmployeeGender"));
			employee.setEmployeePhoneNo(rs.getString("EmployeePhone"));
			employee.setEmployeeAddress(rs.getString("EmployeeAddress"));
			employee.setEmployeeEmail(rs.getString("EmployeeEmail"));
			employee.setEmployeeSalary(rs.getDouble("EmployeeSalary"));
			employee.setEmployeeDateHired(rs.getDate("EmployeeDateHired"));
			employee.setEmployeeOTRatePerHour(rs.getDouble("EmployeeOTRate"));
		}else {
			//throw exception when the employee is not found
			throw new EmployeeNotFoundException();
		}
		ps.close();
		con.close();
		rs.close();
		
		return employee;
	}
	
	/**
	 * This method will find an employee data using employee id
	 * @param employeeId This is String parameter that contain employee id
	 * @return Employee An employee object which contains the data of the employee that want to find is returned
	 * @throws EmployeeNotFoundException
	 * @throws Exception
	 */
	public Employee findEmployee(int employeeId) throws EmployeeNotFoundException, Exception
	{
		Employee employee = new Employee();
		DatabaseConnection db = new DatabaseConnection();
		
		//Create a connection to the database
		Connection con = db.getConnection();
		
		//Create a string with SELECT statement
		String sql = "SELECT * FROM Employee WHERE Employee_Id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		//to set ? with value
		ps.setInt(1, employeeId);
		
		//Send the statement to the DBMS
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()==true) {
			employee.setEmployeeId(rs.getInt("Employee_Id"));
			employee.setEmployeeName(rs.getString("EmployeeName"));
			employee.setEmployeeIdentificationCardNo(rs.getString("EmployeeIC"));
			employee.setEmployeeGender(rs.getString("EmployeeGender"));
			employee.setEmployeePhoneNo(rs.getString("EmployeePhone"));
			employee.setEmployeeAddress(rs.getString("EmployeeAddress"));
			employee.setEmployeeEmail(rs.getString("EmployeeEmail"));
			employee.setEmployeeSalary(rs.getDouble("EmployeeSalary"));
			employee.setEmployeeDateHired(rs.getDate("EmployeeDateHired"));
			employee.setEmployeeOTRatePerHour(rs.getDouble("EmployeeOTRate"));
		}else {
			//throw exception when the employee is not found
			throw new EmployeeNotFoundException();
		}
		
		ps.close();
		con.close();
		rs.close();
		
		return employee;
	}
		
	/**
	 * This method will delete a employee data using employee ID
	 * @param employeeId This is the employee ID that is used to delete the employee data
	 * @return int The numbers of rows affected is returned
	 * @throws Exception
	 */
	public int deleteEmployee(int employeeId) throws Exception
	{
		DatabaseConnection db = new DatabaseConnection();
		
		//Create a connection to the database
		Connection con = db.getConnection();
		
		//Create a string with a DELETE statement
		String sql = "DELETE FROM ADMIN WHERE Employee_Id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
				
		//to set ? with value
		ps.setInt(1, employeeId);
				
		ps.executeUpdate();
				
		//Create a string with a DELETE statement
		String sql2 = "DELETE FROM Employee WHERE Employee_Id = ?";
		ps = con.prepareStatement(sql2);
		
	    //to set ? with value
		ps.setInt(1, employeeId);
		
		int status = ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return status;
		
	}
	
	/**
	 * This method will update the employee data in database
	 * @param employee The employee parameter is an object of Employee class which carry data
	 * @return int The numbers of rows affected is returned
	 * @throws Exception
	 */
	public int updateEmployee(Employee employee) throws Exception
	{
		DatabaseConnection db = new DatabaseConnection();
		
		//Create a connection to the database
		Connection con = db.getConnection();
		
		//Create a string with a UPDATE statement
		String sql = "UPDATE EMPLOYEE SET EmployeeName=?, EmployeePhone=?, EmployeeEmail=?, EmployeeSalary=?, EmployeeDateHired=?, EmployeeOTRate=? WHERE Employee_Id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, employee.getEmployeeName());
		ps.setString(2, employee.getEmployeePhoneNo());
		ps.setString(3, employee.getEmployeeEmail());
		ps.setDouble(4, employee.getEmployeeSalary());
		ps.setDate(5, employee.getEmployeeDateHired());
		ps.setDouble(6, employee.getEmployeeOTRatePerHour());
		ps.setInt(7, employee.getEmployeeId());
		
		int status = ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return status;
	}	
}
