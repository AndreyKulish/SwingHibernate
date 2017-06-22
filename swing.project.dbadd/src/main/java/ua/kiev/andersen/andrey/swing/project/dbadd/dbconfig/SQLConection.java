package ua.kiev.andersen.andrey.swing.project.dbadd.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConection {

	private static Connection conn = null;
	private static String connectionString;
	
	public static void setConnection(String portName, String dataBaseName, String userName, String passWord){
		connectionString = "jdbc:mysql://" + portName + "/" + dataBaseName + "?user=" + userName + "&password=" + passWord;
		    try {
				conn =
				   DriverManager.getConnection(connectionString);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Ошибка подключения");
			}
	}
	
	public static Connection getConnection(){
		return conn;
	}
	
	public static void endConnection() throws SQLException{
		conn.close();	
	}
}
