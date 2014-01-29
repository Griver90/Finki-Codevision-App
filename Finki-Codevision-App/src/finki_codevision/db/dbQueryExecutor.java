package finki_codevision.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import android.os.AsyncTask;

import com.mysql.jdbc.Statement;

import finki_codevision.classes.Code;
import finki_codevision.classes.Generic;
import finki_codevision.classes.Jazik;
import finki_codevision.classes.Predmet;

public class dbQueryExecutor extends AsyncTask<String, Void, ArrayList<Generic>>{

	public static ArrayList<Generic> getElements(String Class){
		Statement stm = null;
		Connection connection = null;
		try
		{
			ArrayList<Generic> array = new ArrayList<Generic>();
			String sql = "SELECT * FROM "+Class;		
			connection = dbConnectionHelper.getConnection();
			stm=(Statement) connection.createStatement();
			ResultSet ts = stm.executeQuery(sql);
			Generic c;
			if(Class.equals("CODE")){
				while(ts.next()){
					c=new Code(ts.getString(3),ts.getString(4),ts.getString(2),ts.getString(5),ts.getString(1),ts.getString(6));
					array.add(c);
				}
			}
			else if(Class.equals("PROG_LANG")){
				while(ts.next()){
					c= new Jazik(ts.getString(2),ts.getString(1));
					array.add(c);
				}
			}
			else if(Class.equals("COURSE")){
				while(ts.next()){
					c= new Predmet(ts.getString(2),ts.getString(3),ts.getString(4),ts.getString(1));
					array.add(c);
				}
			}
			else array.add(new Code());
			return array;
		}
		catch(Exception ex){
			ex.printStackTrace();
			ArrayList<Generic> error = new ArrayList<Generic>();
			error.add(new Code(ex.toString()));
			return error;
		}
		finally{
			if(stm!=null){
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static ResultSet executeQuerry(String query){
		Statement st=null;
		Connection conn=null;
		try {
			conn = dbConnectionHelper.getConnection();
			 st = (Statement) conn.createStatement();
			return st.executeQuery(query);
		} catch (SQLException e) {
			return null;
		}
		finally{
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected ArrayList<Generic> doInBackground(String... params) {
		Statement stm = null;
		Connection connection = null;
		try
		{
			ArrayList<Generic> array = new ArrayList<Generic>();
			String sql = "SELECT * FROM "+params[0];		
			connection = dbConnectionHelper.getConnection();
			stm=(Statement) connection.createStatement();
			ResultSet ts = stm.executeQuery(sql);
			Generic c;
			if(params[0].equals("CODE")){
				while(ts.next()){
					c=new Code(ts.getString(3),ts.getString(4),ts.getString(2),ts.getString(5),ts.getString(1),ts.getString(6));
					array.add(c);
				}
			}
			else if(params[0].equals("PROG_LANG")){
				while(ts.next()){
					c= new Jazik(ts.getString(2),ts.getString(1));
					array.add(c);
				}
			}
			else if(params[0].equals("COURSE")){
				while(ts.next()){
					c= new Predmet(ts.getString(2),ts.getString(3),ts.getString(4),ts.getString(1));
					array.add(c);
				}
			}
			else array.add(new Code());
			return array;
		}
		catch(Exception ex){
			ex.printStackTrace();
			ArrayList<Generic> error = new ArrayList<Generic>();
			error.add(new Code(ex.toString()));
			return error;
		}
		finally{
			if(stm!=null){
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
