package ua.kiev.andersen.andrey.swing.project.dbadd;

import java.sql.SQLException;

import ua.kiev.andersen.andrey.swing.project.dbadd.dbconfig.DBServise;
import ua.kiev.andersen.andrey.swing.project.dbadd.dbconfig.SQLConection;
import ua.kiev.andersen.andrey.swing.project.dbadd.window.view;

public class App 
{

    public static void main( String[] args ) throws SQLException
    {
    	SQLConection.setConnection("localhost", "hitekdada", "root", "root");
    	new DBServise().getName(111, "hitek");
    	new DBServise().getAge(111, "hitek");
    	new DBServise().getLName(111, "hitek");
        //new view();
    }
  
}

