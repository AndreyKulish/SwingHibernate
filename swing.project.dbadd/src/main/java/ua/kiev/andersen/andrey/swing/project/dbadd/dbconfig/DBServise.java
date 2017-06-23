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
	
	public String getResult(int ID,String SOBJ, String tableName) {
		String query = "SELECT " + SOBJ + " FROM " + tableName + " WHERE ID = " + ID;
		 LOGGER.info("Query : " + query);
		
		 try (Statement stmt = conn.createStatement();
        	ResultSet rs =  stmt.executeQuery(query)){
        	
    		System.out.println(query);
            isResultOk(rs.isBeforeFirst());
            
            rs.next();
            result = rs.getString(1);
        	
        } catch(ResultSetAppException ex) {
            LOGGER.error("Select by " + SOBJ, ex);
        } catch (SQLException sqlEx) {
        	LOGGER.error("...", sqlEx);
        }
		
        return result;
	}
	
	private void isResultOk(boolean isResultEmpty) throws ResultSetAppException {
		if(!isResultEmpty){
			throw new ResultSetAppException();
		}
	}

}
