package ua.kiev.andersen.andrey.swing.project.dbadd.window;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JPopupMenu;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JScrollBar;

/**
 * LOL For King
 */
public class view extends JFrame{
	
	private JPanel jPanel = new JPanel();
	
	private JTextField txtPort;
	private JTextField txtDB;
	private JTextField txtLogin;
	private JTextField txtPass;
	private JTextField txtTable;

	private JLabel jLable;
	
	private JButton jButton;
	
	private JComboBox jComboBox;
	
	private JMenu jMenu;
	
	private JMenuBar jMenuBar;
	
	private JMenuItem jMenuItem;
	
	private ArrayList<JComboBox> jb = new ArrayList<JComboBox>();
	
	private String[] forColum = {"NULL","INT","NAME","LNAME","AGE","DATE","NUMB"};
	private String[] dbString = {"2","3","4","5"};
	private String[] countObject = {"10","25","50","100","250"};
	private String[] sqlJDBC = {"MySql","PostgreSQL"};
	
	private String forFormDBConnection;
	private String sqlJDBCOne;
	
	private int ct = 2;
	
	public view() {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setSize(200, 300);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
			
		menuWork();
		panelConfig();
	
		jPanel.repaint(); 
		setVisible(true);		
	}
	
	/**
	 * This is method for build menu panel
	 * 
	 * @author hitek
	 * 
	 * @param Null
	 * @return Menu Panel
	 * @see view#menuWork()
	 */
	void panelMenu(){
		jPanel = new JPanel();
		
		jPanel.setBounds(0, 0, 194, 271);
		getContentPane().add(jPanel);
		menuWork();	
	}
	
	/**
	 * This method for build Add panel, show fields what we shod add to database table
	 * 
	 * @author hitek
	 * 
	 * @param Null
	 * @return Add Panel
	 * 
	 * @see {https://www.linkedin.com/feed/}
	 */
	void panelAdd(){
		
		jPanel = new JPanel();
		jPanel.setBounds(0, 0, 194, 271);
		getContentPane().add(jPanel);
		jPanel.setLayout(null);	
		
		jLable = new JLabel("ColumGet");
		jLable.setBounds(10, 30, 70, 20);
		jPanel.add(jLable);
		
		jComboBox = new JComboBox(dbString);
		jComboBox.setSelectedItem(dbString[ct - 2]);
		jComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String columAdd = (String)jComboBox.getSelectedItem();
				System.out.println(columAdd);
				ct = Integer.parseInt(columAdd);
				getContentPane().remove(jPanel);
				panelAdd();
				System.out.println("Once");
				jPanel.repaint(); 
				setVisible(true);
				jb.clear();
				for(int i = 0; i < ct+1; i++){
					if(i < ct){
					jLable = new JLabel((i + 1) + " colum");
					jLable.setBounds(10, 61 + (i*30), 50, 14);
					jPanel.add(jLable);
					
					jComboBox = new JComboBox(forColum);
					jComboBox.setBounds(100, 61 + (i*30), 70, 20);
					jPanel.add(jComboBox);
					}else{
						jLable = new JLabel("AddNew");
						jLable.setBounds(10, 61 + (i*30), 50, 14);
						jPanel.add(jLable);
						 
						jComboBox = new JComboBox(countObject);
						jComboBox.setBounds(100, 61 + (i*30), 70, 20);
						jPanel.add(jComboBox);
					}
					jb.add(jComboBox);
				}
				
				jPanel.repaint(); 
				setVisible(true);
			}
		});
		
		ct = 2;
		
		jComboBox.setBounds(84, 30, 100, 20);
		jPanel.add(jComboBox);
		
		jButton = new JButton("Ok");
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < jb.size(); i++){
					System.out.println((String)jb.get(i).getSelectedItem());
				}
			}
		});
		jButton.setBounds(111, 237, 73, 23);
		jPanel.add(jButton);
		
		jButton = new JButton("Clear");
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		jButton.setBounds(10, 237, 73, 23);
		jPanel.add(jButton);
		
		menuWork();
		
	}
	
	/**
	 * We get Configuration panel
	 */
	
	void panelConfig(){
		
		jPanel = new JPanel();
		jPanel.setBounds(0, 0, 194, 271);
		getContentPane().add(jPanel);
		jPanel.setLayout(null);
		
		jComboBox = new JComboBox(sqlJDBC);
		jComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlJDBCOne = (String)jComboBox.getSelectedItem();
				System.out.println(sqlJDBCOne);
			}
		});
		
		jComboBox.setBounds(66, 30, 100, 20);
		jPanel.add(jComboBox);
		
		jLable = new JLabel("SQL");
		jLable.setBounds(20, 30, 50, 20);
		jPanel.add(jLable);
		
		txtPort = new JTextField();
		txtPort.setBounds(80, 60, 86, 20);
		jPanel.add(txtPort);
		txtPort.setColumns(10);
		
		txtDB = new JTextField();
		txtDB.setBounds(80, 91, 86, 20);
		jPanel.add(txtDB);
		txtDB.setColumns(10);
				
		txtTable = new JTextField();
		txtTable.setColumns(10);
		txtTable.setBounds(80, 122, 86, 20);
		jPanel.add(txtTable);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(80, 153, 86, 20);
		jPanel.add(txtLogin);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(80, 184, 86, 20);
		jPanel.add(txtPass);
		
		jLable = new JLabel("PORT");
		jLable.setBounds(20, 63, 46, 14);
		jPanel.add(jLable);
		
		jLable = new JLabel("DB");
		jLable.setBounds(20, 93, 46, 14);
		jPanel.add(jLable);
		
		jLable = new JLabel("Login");
		jLable.setBounds(20, 156, 56, 14);
		jPanel.add(jLable);

		jLable = new JLabel("Pass");
		jLable.setBounds(20, 187, 56, 14);
		jPanel.add(jLable);
		
		jLable = new JLabel("Table");
		jLable.setBounds(20, 125, 56, 14);
		jPanel.add(jLable);
		
		jButton = new JButton("Ok");
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forFormDBConnection = txtPort.getText();
				System.out.println(forFormDBConnection);
				forFormDBConnection = txtDB.getText();
				System.out.println(forFormDBConnection);
				forFormDBConnection = txtTable.getText();
				System.out.println(forFormDBConnection);
				forFormDBConnection = txtLogin.getText();
				System.out.println(forFormDBConnection);
				forFormDBConnection = txtPass.getText();
				System.out.println(forFormDBConnection);
			}
		});
		
		jButton.setBounds(111, 237, 73, 23);
		jPanel.add(jButton);
		
		jButton = new JButton("Clear");
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelConfig();
				forFormDBConnection = null;
			}
		});
		
		jButton.setBounds(10, 237, 73, 23);
		jPanel.add(jButton);
		getContentPane().add(jPanel);
		
		menuWork();
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////

	void menuWork(){
		
		jMenuBar = new JMenuBar();
		jMenuBar.setBounds(0, 0, 194, 27);
		getContentPane().add(jMenuBar);
		
		jMenu = new JMenu("Select Menu");
		jMenuBar.add(jMenu);
		
		jMenuItem = new JMenuItem("Main");
		jMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(jPanel);
				panelMenu();
				jPanel.repaint(); 
				setVisible(true);
				System.out.println("Main");
			}
		});
		
		jMenu.add(jMenuItem);
		System.gc();
		
		jMenuItem = new JMenuItem("AddNewFild");
		jMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(jPanel);
				panelAdd();
				jPanel.repaint(); 
				setVisible(true);
				System.out.println("AddNewFild");
			}
		});
		
		jMenu.add(jMenuItem);
		System.gc();
		
		jMenuItem = new JMenuItem("Config");
		jMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(jPanel);
				panelConfig();
				jPanel.repaint();
				setVisible(true);
				System.out.println("Config");
			}
		});
		
		jMenu.add(jMenuItem);
		System.gc();
		
		repaint();
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////

}
