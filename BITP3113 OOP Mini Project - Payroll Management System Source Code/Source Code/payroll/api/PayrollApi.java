package payroll.api;

import java.sql.*;
import java.util.ArrayList;

import payroll.bean.Payroll;
import payroll.bean.Employee;
import payroll.db.DatabaseConnection;

/**
 * This class is to manage the data of payroll in the database
 *
 */
public class PayrollApi {
	
	/**
	 * This is the constructor for class AdminApi
	 */
	public PayrollApi()
	{
		
	}
	
	/**
	 * This method add a new payroll data into the database
	 * @param payroll The payroll parameter is an object of Payroll class which carry data
	 * @return int The numbers of rows affected
	 * @throws Exception
	 */
	public int addPayroll(Payroll payroll) throws Exception
	{
		int employeeId = payroll.getPayrollEmployeeId();
				
		//Create a connection to the database
		DatabaseConnection dc = new DatabaseConnection();
		
		Connection conn = dc.getConnection();
		
		//create a string with a INSERT statement
		String sql = "INSERT INTO PAYROLL (PayrollTitle, PayrollDate, Deduction, TotalOverTime, OTSalary, TaxPaid, TotalSalary, Employee_Id) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
			
		pstmt.setString(1, payroll.getPayrollTitle());
		pstmt.setDate(2, payroll.getPayrollDate());
		pstmt.setDouble(3, payroll.getDeduction());
		pstmt.setDouble(4, payroll.getTotalOverTime());
		pstmt.setDouble(5, payroll.getOTSalary());
		pstmt.setDouble(6, payroll.getTaxPaid());
		pstmt.setDouble(7, payroll.getTotalSalary());
		pstmt.setInt(8, employeeId);
		
		//send the insert statement to the DBMS
		int rows = pstmt.executeUpdate();
		
		System.out.println("The data is successfully saved into database");
		
		conn.close();	
		pstmt.close();
		
		return rows;
	}
	
	/**
	 * This method retrieve all the data of payroll from the database
	 * @return ArrayList<Payroll> An ArrayList of Payroll object which contain data is returned
	 * @throws Exception
	 */
	public ArrayList<Payroll> getPayroll() throws Exception
	{
		DatabaseConnection dc = new DatabaseConnection();
		ArrayList<Payroll> payrollList = new ArrayList<Payroll>();
		
		//Create a connection to the database
		Connection conn = dc.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM PAYROLL");
		ResultSet res = pstmt.executeQuery();
		
		while(res.next())
		{
			//retrieve the data of all payroll
			Payroll payroll = new Payroll();
			
			//set the data to payroll
			payroll.setPayroll_id(res.getInt("Payroll_Id"));
			payroll.setPayrollTitle(res.getString("PayrollTitle"));
			payroll.setPayrollEmployeeId(res.getInt("Employee_Id"));
			payroll.setPayrollDate(res.getDate("PayrollDate"));
			payroll.setDeduction(res.getDouble("Deduction"));
			payroll.setTotalOverTime(res.getDouble("TotalOverTime"));
			payroll.setOTSalary(res.getDouble("TotalSalary"));
			payroll.setTaxPaid(res.getDouble("TaxPaid"));
			payroll.setTotalSalary(res.getDouble("TotalSalary"));
			
			payrollList.add(payroll);	//add the payroll to the ArrayList
		}
		
		conn.close();
		pstmt.close();
		res.close();	
		
		return payrollList;
	}
	
	/**
	 * This method will find a payroll data using payroll ID
	 * @param id
	 * @return Payroll
	 * @throws PayrollNotFoundException
	 * @throws Exception
	 */
	public Payroll findPayroll(int id) throws PayrollNotFoundException, Exception
	{
		DatabaseConnection dc = new DatabaseConnection();
		Payroll payroll = new Payroll();
		
		//Create a connection to the database
		Connection conn = dc.getConnection();
		
		//create a string with SELECT statement
		String sql = "SELECT * FROM PAYROLL WHERE Payroll_Id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		//send the statement to the DBMS
		ResultSet res = pstmt.executeQuery();
		
		if(res.next() == true)
		{
			//retrieve data of payroll
			payroll.setPayroll_id(res.getInt("Payroll_Id"));
			payroll.setPayrollTitle(res.getString("PayrollTitle"));
			payroll.setPayrollEmployeeId(res.getInt("Employee_Id"));
			payroll.setPayrollDate(res.getDate("PayrollDate"));
			payroll.setDeduction(res.getDouble("Deduction"));
			payroll.setTotalOverTime(res.getDouble("TotalOverTime"));
			payroll.setOTSalary(res.getDouble("OTSalary"));
			payroll.setTaxPaid(res.getDouble("TaxPaid"));
			payroll.setTotalSalary(res.getDouble("TotalSalary"));
		}
		else
		{
			//throw exception when the payroll is not found
			throw new PayrollNotFoundException();
		}
		
		conn.close();
		pstmt.close();
		res.close();
		
		return payroll;
	}
	
	/**
	 * This method will delete a payroll data using payroll ID
	 * @param id
	 * @return int
	 * @throws Exception
	 */
	public int deletePayroll(int id) throws Exception
	{
		DatabaseConnection dc = new DatabaseConnection();
		
		//Create a connection to the database
		Connection conn = dc.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("DELETE FROM PAYROLL WHERE Payroll_Id=?");
		pstmt.setInt(1, id);
		int rows = pstmt.executeUpdate();	//send the DELETE statement to DBMS
		
		conn.close();
		pstmt.close();
		
		//return the numbers of rows affected
		return rows;
	}
	
	/**
	 * This method will update the payroll data in database
	 * @param payroll
	 * @return int 
	 * @throws Exception
	 */
	public int updatePayroll(Payroll payroll) throws Exception
	{	
		DatabaseConnection dc = new DatabaseConnection();
		
		//Create a connection to the database
		Connection conn = dc.getConnection();
		
		//create a string with a UPDATE statement
		String sql = "UPDATE PAYROLL SET PayrollTitle=?, PayrollDate=?, Deduction=?, TotalOverTime=?, OTSalary=?, TaxPaid=?, TotalSalary=? WHERE Payroll_Id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, payroll.getPayrollTitle());
		pstmt.setDate(2, payroll.getPayrollDate());
		pstmt.setDouble(3, payroll.getDeduction());
		pstmt.setDouble(4, payroll.getTotalOverTime());
		pstmt.setDouble(5, payroll.getOTSalary());
		pstmt.setDouble(6, payroll.getTaxPaid());
		pstmt.setDouble(7, payroll.getTotalSalary());
		pstmt.setInt(8, payroll.getPayroll_id());
		
		int rows = pstmt.executeUpdate();	//send the UPDATE statement to the DBMS
		
		conn.close();
		pstmt.close();
		
		//return the numbers of rows affected
		return rows;
	}
}
