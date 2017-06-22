package ua.kiev.andersen.andrey.swing.project.dbadd.dbconfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import ua.kiev.andersen.andrey.swing.project.dbadd.Exception.ResultSetAppException;



public class DBServise {

	private static final Logger LOGGER = Logger.getLogger("MyLogger");
	
	private Connection conn = SQLConection.getConnection();
	private Statement stmt;
	private static ResultSet rs, rsClone;
	private String result, query;
	
	public String getName(int ID, String tableName) throws SQLException{
		query = "SELECT NAME FROM " + tableName + " WHERE ID = " + ID;
		System.out.println(query);
		stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        try{
        isResultOk(rs.isBeforeFirst());
        }catch(Exception ex){
        	LOGGER.error("Select by NAME",ex);
        }
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
        try{
            isResultOk(rs.isBeforeFirst());
            }catch(Exception ex){
            	LOGGER.error("Select by LNAME",ex);
            }
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
        try{
            isResultOk(rs.isBeforeFirst());
            }catch(Exception ex){
            	LOGGER.error("Select by AGE",ex);
            }
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
        try{
            isResultOk(rs.isBeforeFirst());
            }catch(Exception ex){
            	LOGGER.error("Select by NUMB",ex);
            }
        rs.next();
        result = rs.getString(1);
        closeStmtRs();
		
        return result;
	}
	
	public String getDates(int ID, String tableName) {
        try (
        		Connection conn = SQLConection.getConnection();
        		Statement stmt = conn.createStatement();
        		ResultSet rs = null;
        		){
        	query = "SELECT DATES FROM " + tableName + " WHERE ID = " + ID;
    		System.out.println(query);
    		stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            
            isResultOk(rs.isBeforeFirst());
            
            rs.next();
            result = rs.getString(1);
        
        } catch(ResultSetAppException ex) {
            LOGGER.error("Select by DATES", ex);
        } catch (SQLException sqlEx) {
        	LOGGER.error("...", sqlEx);
        }
		
        return result;
	}
	
	private void closeStmtRs() throws SQLException{
		rs.close();
        stmt.close();
	}
	
	private void isResultOk(boolean isResultEmpty) throws ResultSetAppException {
		if(!isResultEmpty){
			throw new ResultSetAppException();
		}
	}

}
