package payroll.api;

/**
 * Class for exception of employee not found
 *
 */
public class EmployeeNotFoundException extends Exception{
	
	private static final String message = "The employee is not found in the database";
	
	/**
	 * The constructor will pass the error message to the superclass
	 */
	public EmployeeNotFoundException()
	{
		super(message);
	}

}
