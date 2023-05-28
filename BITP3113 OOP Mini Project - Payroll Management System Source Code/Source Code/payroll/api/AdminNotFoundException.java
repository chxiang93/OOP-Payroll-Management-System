package payroll.api;

/**
 * This class is exception of admin not found
 * 
 */
public class AdminNotFoundException extends Exception {
	
	private static final String message = "The admin is not found in the database";
	
	/**
	 * The constructor will pass the error message to the superclass
	 * @param message
	 */
	public AdminNotFoundException()
	{
		super(message);
	}
}
