package payroll.db;

import java.sql.*;

/**
 * 
 * This class will establish a connection between the system and the DBMS
 *
 */
public class DatabaseConnection {
	
	String driver;
	String dbName;
	String connectionURL;
	String username;
	String password;

	/**
	 * This is the constructor that will initialize all the information needed to connect to database
	 */
	public DatabaseConnection()
	{
		driver = "com.mysql.cj.jdbc.Driver";
		connectionURL = "jdbc:mysql://127.0.0.1:3306/";
		dbName = "payrolldb";
		username = "root";
		password = "";
	}
	
	/**
	 * This method will return a connection to the DBMS
	 * @return Connection
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception
	{
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(connectionURL+dbName, username, password);
		
		return connection;
	}
}
