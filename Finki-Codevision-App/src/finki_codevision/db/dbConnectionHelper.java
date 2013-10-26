/**
 * 
 */
package finki_codevision.db;

import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import finki_codevision.classes.Code;

/**
 * @author Aleksandar
 *
 */
public class dbConnectionHelper {
	
	public static final String Connection_String = "jdbc:mysql://Codevisionbaza.db.11631695.hostedresource.com:3306/CodeVisionBaza";
	public static final String DB_Username="CodeVisionBaza";
	public static final String DB_Password="Finki@Baza1";
	
	public static ArrayList<Code> getConnection(){
		Statement stm = null;
		Connection connection = null;
		try
		{
			String sql = "SELECT * FROM CODE";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(Connection_String, DB_Username, DB_Password);
			stm=(Statement) connection.createStatement();
			ArrayList<Code> array = new ArrayList<Code>();
			ResultSet ts = stm.executeQuery(sql);
			Code c;
			while(ts.next()){
				c=new Code(ts.getString(3),ts.getString(4),ts.getString(2),ts.getString(5),ts.getString(1));
				array.add(c);
			}
			return array;
		}
		catch(Exception ex){
			return null;
		}
		finally{
			if(stm!=null){
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/*public static String getData(){
		
		Connection conn = getConnection();
		
		if(conn!=null)
		{
			conn.get
			return "";
		}
		else return "No connection avviable!";
	}*/
}
