package ua.kiev.andersen.andrey.swing.project.dbadd.dbconfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBServise {


	private Connection conn = SQLConection.getConnection();
	private Statement stmt;
	private ResultSet rs;
	private String result, query;
	
	public String getName(int ID, String tableName) throws SQLException{
		query = "SELECT NAME FROM " + tableName + " WHERE ID = " + ID;
		System.out.println(query);
		stmt = conn.createStatement();
        rs = stmt.executeQuery(query); 
        rs.next();
        result = rs.getString(1);
        closeStmtRs();
		return result;
	}
	
	public String getLName(int ID, String tableName) throws SQLException{
		query = "SELECT LNAME FROM " + tableName + " WHERE ID = " + ID;
		System.out.println(query);
		stmt = conn.createStatement();
        rs = stmt.executeQuery(query); 
        rs.next();
        result = rs.getString(1);
        closeStmtRs();
		return result;
	}
	
	public String getAge(int ID, String tableName) throws SQLException{
		query = "SELECT AGE FROM " + tableName + " WHERE ID = " + ID;
		System.out.println(query);
		stmt = conn.createStatement();
        rs = stmt.executeQuery(query); 
        rs.next();
        result = rs.getString(1);
        closeStmtRs();
		return result;
	}
	
	public String getNumb(int ID, String tableName) throws SQLException{
		query = "SELECT NUMB FROM " + tableName + " WHERE ID = " + ID;
		System.out.println(query);
		stmt = conn.createStatement();
        rs = stmt.executeQuery(query); 
        rs.next();
        result = rs.getString(1);
        closeStmtRs();
		return result;
	}
	
	public String getDates(int ID, String tableName) throws SQLException{
		query = "SELECT DATES FROM " + tableName + " WHERE ID = " + ID;
		System.out.println(query);
		stmt = conn.createStatement();
        rs = stmt.executeQuery(query); 
        rs.next();
        result = rs.getString(1);
        closeStmtRs();
		return result;
	}
	
	private void closeStmtRs() throws SQLException{
		rs.close();
        stmt.close();
	}

}
