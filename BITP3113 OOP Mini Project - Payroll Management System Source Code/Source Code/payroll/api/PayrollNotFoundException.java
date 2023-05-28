package payroll.api;

/**
 * This class is exception of payroll not found
 * 
 */
public class PayrollNotFoundException extends Exception {

	private static final String message = "The payroll is not found in the database";
	
	/**
	 * The constructor will pass the error message to the superclass
	 */
	PayrollNotFoundException()
	{
		super(message);
	}
}
