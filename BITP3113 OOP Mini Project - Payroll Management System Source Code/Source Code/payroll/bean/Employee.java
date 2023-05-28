package payroll.bean;
import java.sql.Date;

/**
 * This class act as a temporary data storage for the data employee from
 * DBMS before getting print to the screen or save to DBMS
 */
public class Employee {
	
	//Declaration of variables that store data from DBMS
	private int employeeId;
	private String employeeName;
	private String employeeIdentificationCardNo;
	private String employeeGender;
	private String employeePhoneNo;
	private String employeeAddress;
	private String employeeEmail;
	private double employeeSalary;
	private Date employeeDateHired;
	private double employeeOTRatePerHour;
	
	/**
	 * Constructor for class Employee
	 */
	public Employee(){
	}
	
	/**
	 * Setter method for employeeId
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId=employeeId;
	}
	
	/**
	 * Getter method for employeeId
	 * @return int Employee ID
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * Setter method for employeeName
	 * @param employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName=employeeName;
	}
	
	/**
	 * Getter method for employeeName
	 * @return String name
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	
	/**
	 * Setter method for employeeIdentificationCardNo
	 * @param employeeIdentificationCardNo
	 */
	public void setEmployeeIdentificationCardNo(String employeeIdentificationCardNo) {
		this.employeeIdentificationCardNo=employeeIdentificationCardNo;
	}
	
	/**
	 * Getter method for employeeIdentificationCardNo
	 * @return String IC Number
	 */
	public String getEmployeeIdentificationCardNo() {
		return employeeIdentificationCardNo;
	}
	
	/**
	 * Setter method for employeeGender
	 * @param employeeGender
	 */
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender=employeeGender;
	}
	
	/**
	 * Getter method for employeeGender
	 * @return String Gender
	 */
	public String getEmployeeGender() {
		return employeeGender;
	}
	
	/**
	 * Setter method for employeePhoneNo
	 * @param employeePhoneNo
	 */
	public void setEmployeePhoneNo(String employeePhoneNo) {
		this.employeePhoneNo=employeePhoneNo;
	}
	
	/**
	 * Getter method for employeePhoneNo
	 * @return String Phone number
	 */
	public String getEmployeePhoneNo() {
		return employeePhoneNo;
	}
	
	/**
	 * Setter method for employeeAddress
	 * @param employeeAddress
	 */
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress=employeeAddress;
	}
	
	/**
	 * Getter method for employeeAddress
	 * @return String Employee address
	 */
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	
	/**
	 * Setter method for employeeEmail
	 * @param employeeEmail
	 */
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail=employeeEmail;
	}
	
	/**
	 * Getter method for employeeEmail
	 * @return String Employee email
	 */
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	
	/**
	 * Setter method for employeeSalary
	 * @param employeeSalary
	 */
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary=employeeSalary;
	}
	
	/**
	 * Getter method for employeeSalary
	 * @return double Employee salary
	 */
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	
	/**
	 * Setter method for employeeDateHired
	 * @param employeeEmployeeDateHired
	 */
	public void setEmployeeDateHired(Date employeeEmployeeDateHired) {
		this.employeeDateHired=employeeEmployeeDateHired;
	}
	
	/**
	 * Getter method for employeeDateHired
	 * @return Date Date hired
	 */
	public Date getEmployeeDateHired() {
		return employeeDateHired;
	}
	
	/**
	 * Setter method for employeeOTRatePerHour
	 * @param employeeOTRatePerHour
	 */
	public void setEmployeeOTRatePerHour(double employeeOTRatePerHour) {
		this.employeeOTRatePerHour=employeeOTRatePerHour;
	}
	
	/**
	 * Getter method for employeeOTRatePerHour
	 * @return double OT rate
	 */
	public double getEmployeeOTRatePerHour() {
		return employeeOTRatePerHour;
	}
	
}
