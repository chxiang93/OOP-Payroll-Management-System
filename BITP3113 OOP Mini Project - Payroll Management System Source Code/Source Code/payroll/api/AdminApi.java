package payroll.api;

import java.sql.*;
import java.util.ArrayList;

import payroll.bean.Admin;
import payroll.bean.Employee;
import payroll.db.DatabaseConnection;

/**
 * This class is to manage the data of admin in the database
 *
 * 
 */

public class AdminApi {
	
	/**
	 * This is the constructor for class AdminApi
	 */
	public AdminApi()
	{
		
	}
	
	/**
	 * This method check if the user key in correct username and password to log into the system
	 * @param username The string of username is passed in
	 * @param password The string of password is passed in
	 * @return boolean true if the username and password is correct
	 * @throws Exception
	 */
	public boolean login(String username, String password) throws Exception
	{
		DatabaseConnection dc = new DatabaseConnection();
		boolean loginStatus = false;
		
		//Create a connection to the database
		Connection conn = dc.getConnection();
		
		String sql = "SELECT * FROM ADMIN";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet res = pstmt.executeQuery();
		
		while(res.next())
		{
			if(username.equals(res.getString("Username")) && password.equals(res.getString("Password")))
			{
				loginStatus=true;
			}
		}
		
		return loginStatus;
	}
	
	/**
	 * This method add a new admin data into the database
	 * @param admin The admin parameter is an object of Admin class which carry data
	 * @return int The numbers of rows affected
	 * @throws Exception
	 */
	public int addAdmin(Admin admin) throws Exception
	{
		DatabaseConnection dc = new DatabaseConnection();
		
		//Create a connection to the database
		Connection conn = dc.getConnection();
		
		//create a string with a INSERT statement
		String sql = "INSERT INTO ADMIN (Employee_Id, Username, Password) VALUES (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, admin.getEmployeeId());
		pstmt.setString(2, admin.getUsername());
		pstmt.setString(3, admin.getPassword());
		
		//send the insert statement to the DBMS
		int rows = pstmt.executeUpdate();
		
		System.out.println("The data is successfully saved into database");
		
		conn.close();	
		pstmt.close();
		
		return rows;
	}
	
	/**
	 * This method retrieve all the data of admin from the database
	 * @return ArrayList<Admin> An ArrayList of Admin object which contain data is returned
	 * @throws Exception
	 */
	public ArrayList<Admin> getAdmin() throws Exception
	{
		DatabaseConnection dc = new DatabaseConnection();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		
		//Create a connection to the database
		Connection conn = dc.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ADMIN NATURAL JOIN EMPLOYEE");
		ResultSet res = pstmt.executeQuery();	//send the SELECT statement to DBMS
		
		while(res.next())
		{
			//retrieve the data of all admin
			Admin admin = new Admin();
			
			//set the data to admin
			admin.setEmployeeId(res.getInt("Employee_Id"));
			admin.setEmployeeName(res.getString("EmployeeName"));
			admin.setEmployeeIdentificationCardNo(res.getString("EmployeeIC"));
			admin.setEmployeeGender(res.getString("EmployeeGender"));
			admin.setEmployeePhoneNo(res.getString("EmployeePhone"));
			admin.setEmployeeAddress(res.getString("EmployeeAddress"));
			admin.setEmployeeEmail(res.getString("EmployeeEmail"));
			admin.setEmployeeSalary(res.getDouble("EmployeeSalary"));
			admin.setEmployeeDateHired(res.getDate("EmployeeDateHired"));
			admin.setEmployeeOTRatePerHour(res.getDouble("EmployeeOTRate"));
			admin.setAdminId(res.getInt("Admin_Id"));
			admin.setUsername(res.getString("Username"));
			admin.setPassword(res.getString("Password"));
			
			adminList.add(admin);	//add the admin to the ArrayList
		}
		
		conn.close();
		pstmt.close();
		res.close();
		
		return adminList;
	}
	
	/**
	 * This method will delete a admin data using admin ID
	 * @param id This is the admin ID that is used to delete the admin data
	 * @return int The numbers of rows affected is returned
	 * @throws Exception
	 */
	public int deleteAdmin(int id) throws Exception
	{
		DatabaseConnection dc = new DatabaseConnection();
		
		//Create a connection to the database
		Connection conn = dc.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ADMIN WHERE Admin_Id=?");
		pstmt.setInt(1, id);
		int rows = pstmt.executeUpdate();	//send the DELETE statement to DBMS
		
		conn.close();
		pstmt.close();
		
		//return the numbers of rows affected
		return rows;
	}
	
	/**
	 * This method will update the admin data in database
	 * @param admin The admin parameter is an object of Admin class which carry data
	 * @return int The numbers of rows affected is returned
	 * @throws Exception
	 */
	public int updateAdmin(Admin admin) throws Exception
	{
		DatabaseConnection dc = new DatabaseConnection();
		
		//Create a connection to the database
		Connection conn = dc.getConnection();
		
		//create a string with a UPDATE statement
		String sql = "UPDATE ADMIN SET Username=?, Password=? WHERE Admin_Id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, admin.getUsername());
		pstmt.setString(2, admin.getPassword());
		pstmt.setInt(3, admin.getAdminId());
		
		pstmt.executeUpdate();	//send the UPDATE statement to the DBMS
		
		sql = "UPDATE EMPLOYEE SET EmployeeName=? WHERE Employee_Id=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, admin.getEmployeeName());
		pstmt.setInt(2, admin.getEmployeeId());
		
		int rows = pstmt.executeUpdate();
		
		conn.close();
		pstmt.close();
		
		//return the numbers of rows affected
		return rows;
	}
	
	/**
	 * This method will find an admin data using admin ID
	 * @param adminId This is int parameter that contain admin ID
	 * @return Admin An admin object which contains the data of the admin that want to find is returned
	 * @throws Exception
	 * @throws AdminNotFoundException
	 */
	public Admin findAdmin(int adminId) throws AdminNotFoundException,Exception
	{
		DatabaseConnection dc = new DatabaseConnection();
		Admin admin = new Admin();
		
		//Create a connection to the database
		Connection conn = dc.getConnection();
		
		//create a string with SELECT statement
		String sql = "SELECT * FROM ADMIN NATURAL JOIN EMPLOYEE WHERE Admin_Id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, adminId);
		//send the statement to the DBMS
		ResultSet res = pstmt.executeQuery();
		
		if(res.next() == true)
		{
			//retrieve data of admin
			admin.setAdminId(res.getInt("Admin_Id"));
			admin.setEmployeeId(res.getInt("Employee_Id"));
			admin.setEmployeeName(res.getString("EmployeeName"));
			admin.setUsername(res.getString("Username"));
			admin.setPassword(res.getString("Password"));
		}
		else
		{
			//throw exception when the admin is not found
			throw new AdminNotFoundException();
		}
		
		conn.close();
		pstmt.close();
		res.close();
		
		return admin;
	}
	
	/**
	 * This method will find an admin data using admin name
	 * @param adminName This is int parameter that contain admin name
	 * @return Admin An admin object which contains the data of the admin that want to find is returned
	 * @throws Exception
	 * @throws AdminNotFoundException
	 */
	public Admin findAdmin(String adminName) throws AdminNotFoundException,Exception
	{
		DatabaseConnection dc = new DatabaseConnection();
		Admin admin = new Admin();
		
		//Create a connection to the database
		Connection conn = dc.getConnection();
		
		//create a string with SELECT statement
		String sql = "SELECT * FROM ADMIN NATURAL JOIN EMPLOYEE WHERE EmployeeName=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, adminName);
		ResultSet res = pstmt.executeQuery();	//send the statement to the DBMS
		
		if(res.next() == true)
		{
			//retrieve data of admin
			admin.setAdminId(res.getInt("Admin_Id"));
			admin.setEmployeeId(res.getInt("Employee_Id"));
			admin.setEmployeeName(res.getString("EmployeeName"));
			admin.setUsername(res.getString("Username"));
			admin.setPassword(res.getString("Password"));
		}
		else
		{
			//throw exception when the admin is not found
			throw new AdminNotFoundException();
		}
		
		conn.close();
		pstmt.close();
		res.close();
		
		return admin;
	}
}
