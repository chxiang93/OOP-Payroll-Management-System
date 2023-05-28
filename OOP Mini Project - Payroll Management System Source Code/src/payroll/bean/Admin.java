package payroll.bean;

/**
 * This class act as a temporary data storage for the data from
 * DBMS before getting print to the screen or save to DBMS
 */
public class Admin extends Employee {

		//These are the declaration of variable that store data from DBMS
		private int adminId;
		private String username;
		private String password;

		/**
		 * Constructor of Admin class
		 */
		public Admin()
		{
			
		}
		
		/**
		 * This is the getter method for adminId
		 * @return int Admin ID
		 */
		public int getAdminId() 
		{
			return adminId;
		}

		/**
		 * This is the setter method for Admin ID
		 * @param adminId
		 * @return void
		 */
		public void setAdminId(int adminId) 
		{
			this.adminId = adminId;
		}

		/**
		 * This is the getter method for username
		 * @return String Username of admin is returned
		 */
		public String getUsername() 
		{
			return username;
		}

		/**
		 * This is the setter method for username
		 * @param username
		 * @return void
		 */
		public void setUsername(String username) 
		{
			this.username = username;
		}

		/**
		 * This is the getter method for password
		 * @return String Password is returned
		 */
		public String getPassword() 
		{
			return password;
		}

		/**
		 * This is the setter method for password
		 * @param password
		 * @return void
		 */
		public void setPassword(String password) 
		{
			this.password = password;
		}
}
