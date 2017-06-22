package ua.kiev.andersen.andrey.swing.project.dbadd;

import java.sql.SQLClientInfoException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ua.kiev.andersen.andrey.swing.project.dbadd.dbconfig.SQLConection;
import ua.kiev.andersen.andrey.swing.project.dbadd.entity.ResourcesToAdd;
import ua.kiev.andersen.andrey.swing.project.dbadd.window.view;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Session session = new SQLConection().getSessionFactory().openSession();
    	 session.beginTransaction();
    	 ResourcesToAdd G = session.get(ResourcesToAdd.class,1);
    	 System.out.println(G.getAGE());
    	 session.getTransaction().commit();
    	 session.close();
        new view();
    }
}
