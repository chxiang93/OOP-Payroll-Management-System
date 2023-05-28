package payroll.bean;
import java.sql.Date;

/**
 * This class act as a temporary data storage for the data admin from
 * DBMS before getting print to the screen or save to DBMS
 */
public class Payroll implements Taxable {
	
	//These are the declaration of variable that store data from DBMS
	private int payroll_id;
	private String payrollTitle;
	private int payrollEmployeeId;
	private Date payrollDate;
	private double deduction;
	private double totalOverTime;
	private double OTSalary;
	private double taxPaid;
	private double totalSalary;
	
	/**
	 * Constructor of Payroll class
	 */
	public Payroll()
	{
		
	}
	
	/**
	 * This method will calculate overtime salary
	 * @param employee
	 * @return double
	 */
	public double calculateOTSalary(Employee employee)
	{
		double OTRate = employee.getEmployeeOTRatePerHour();
		OTSalary = OTRate * totalOverTime;
		
		return OTSalary;
	}
	
	/**
	 * This method will calculate total salary before tax
	 * @param employee
	 * @return double
	 */
	public double calculateSalary(Employee employee)
	{
		double baseSalary = employee.getEmployeeSalary();
		
		double salary = baseSalary + calculateOTSalary(employee) - deduction;
		
		return salary;
	}
	
	/**
	 * This method will calculate tax paid
	 * @param employee
	 * @return double
	 */
	@Override
	public double calculateTax(Employee employee)
	{
		taxPaid = calculateSalary(employee)*0.06;
		
		return taxPaid;
	}
	
	/**
	 * This method will calculate total salary of employee after taxed
	 * @param employee
	 * @return double
	 */
	public double calculateTotalSalary(Employee employee)
	{
		totalSalary = calculateSalary(employee) - calculateTax(employee);
		
		return totalSalary;
	}

	/**
	 * This is the getter method for payroll_Id
	 * @return int 
	 */
	public int getPayroll_id() 
	{
		return payroll_id;
	}

	/**
	 * This is the setter method for payroll_Id
	 * @param payroll_id
	 */
	public void setPayroll_id(int payroll_id) 
	{
		this.payroll_id = payroll_id;
	}

	/**
	 * This is the getter method for payroll title
	 * @return String
	 */
	public String getPayrollTitle() 
	{
		return payrollTitle;
	}

	/**
	 * This is the setter method for payroll title
	 * @param payrollTitle
	 */
	public void setPayrollTitle(String payrollTitle) 
	{
		this.payrollTitle = payrollTitle;
	}

	/**
	 * This is the getter method for employee id of payroll
	 * @return int
	 */
	public int getPayrollEmployeeId() 
	{
		return payrollEmployeeId;
	}

	/**
	 * This is the setter method for employee id of payroll
	 * @param payrollEmployeeId
	 */
	public void setPayrollEmployeeId(int payrollEmployeeId) 
	{
		this.payrollEmployeeId = payrollEmployeeId;
	}

	/**
	 * This is the getter method for payroll date
	 * @return Date
	 */
	public Date getPayrollDate() 
	{
		return payrollDate;
	}

	/**
	 * This is the setter method for payroll date
	 * @param payrollDate
	 */
	public void setPayrollDate(Date payrollDate) 
	{
		this.payrollDate = payrollDate;
	}

	/**
	 * This is the getter method for payroll deduction
	 * @return double
	 */
	public double getDeduction() 
	{
		return deduction;
	}

	/**
	 * This is the setter method for payroll deduction
	 * @param deduction
	 */
	public void setDeduction(double deduction) 
	{
		this.deduction = deduction;
	}

	/**
	 * This is the getter method for total overtime
	 * @return double
	 */
	public double getTotalOverTime() 
	{
		return totalOverTime;
	}

	/**
	 * This is the setter method for total overtime
	 * @param totalOverTime
	 */
	public void setTotalOverTime(double totalOverTime) 
	{
		this.totalOverTime = totalOverTime;
	}

	/**
	 * This is the getter method for OT salary
	 * @return double
	 */
	public double getOTSalary() 
	{
		return OTSalary;
	}

	/**
	 * This is the setter method for OT salary
	 * @param oTSalary
	 */
	public void setOTSalary(double oTSalary) 
	{
		OTSalary = oTSalary;
	}

	/**
	 * This is the getter method for tax paid
	 * @return double
	 */
	public double getTaxPaid() 
	{
		return taxPaid;
	}

	/**
	 * This is the setter method for tax paid
	 * @param taxPaid
	 */
	public void setTaxPaid(double taxPaid) 
	{
		this.taxPaid = taxPaid;
	}

	/**
	 * This is the getter method for total salary
	 * @return double
	 */
	public double getTotalSalary() 
	{
		return totalSalary;
	}

	/**
	 * This is the setter method for total salary
	 * @param totalSalary
	 */
	public void setTotalSalary(double totalSalary) 
	{
		this.totalSalary = totalSalary;
	}

}
