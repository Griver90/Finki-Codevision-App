/**
 * 
 */
package finki_codevision.db;

import java.sql.*;

/**
 * @author Aleksandar
 *
 */
public class dbConnectionHelper {
	
	public static final String Connection_String = "jdbc:mysql://Codevisionbaza.db.11631695.hostedresource.com:3306/CodeVisionBaza";
	public static final String DB_Username="CodeVisionBaza";
	public static final String DB_Password="Finki@Baza1";
	
	public static Connection getConnection(){
		Connection connection=null;
		try{
			Class.forName("com.mysql.jdbc.Driver").getInterfaces();
			connection= DriverManager.getConnection(Connection_String, DB_Username, DB_Password);
			return connection;
		}
		catch(Exception ex){
			return null;
		}
	}
}
