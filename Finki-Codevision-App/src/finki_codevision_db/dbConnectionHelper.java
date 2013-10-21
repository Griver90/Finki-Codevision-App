/**
 * 
 */
package finki_codevision_db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Aleksandar
 *
 */
public class dbConnectionHelper {
	
	public static final String Connection_String = "jdbc:mysql://Codevisionbaza.db.11631695.hostedresource.com:3306/CodeVisionBaza";
	public static final String DB_Username="CodeVisionBaza";
	public static final String DB_Password="Finki@Baza1";
	
	public static String getConnection(){
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection(Connection_String, DB_Username, DB_Password); 
			return connection.toString();
		}
		catch(Exception ex){
			return ex.toString();
		}
	}
}
