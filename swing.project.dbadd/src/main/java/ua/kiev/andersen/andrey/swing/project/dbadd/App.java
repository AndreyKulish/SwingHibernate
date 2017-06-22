package ua.kiev.andersen.andrey.swing.project.dbadd;

import java.sql.SQLException;

import ua.kiev.andersen.andrey.swing.project.dbadd.dbconfig.DBServise;
import ua.kiev.andersen.andrey.swing.project.dbadd.dbconfig.SQLConection;
import ua.kiev.andersen.andrey.swing.project.dbadd.window.view;

public class App 
{

    public static void main( String[] args ) throws SQLException
    {
        new view();
    }
  
}

