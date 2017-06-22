package ua.kiev.andersen.andrey.swing.project.dbadd.Exception;

import java.sql.SQLException;

public class ResultSetAppException extends SQLException{
	
	public ResultSetAppException(){
		super("Ошибка: пустой ResultSet!");
	}
}
