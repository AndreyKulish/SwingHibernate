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

public class view extends JFrame{
	
	private JPanel jPanel = new JPanel();
	private JTextField txtPort;
	private JTextField txtDB;
	private JTextField txtLogin;
	private JButton eer;
	private JComboBox comboBox;
	private JTextField txtPass;
	private String forFormDBConnection;
	private final ArrayList<JComboBox> jb = new ArrayList<JComboBox>();
	private JTextField textField;
	private final String[] forColum = {"NULL","INT","NAME","LNAME","AGE","DATE","NUMB"};
	private String[] dbString = {"2","3","4","5"};
	private final String[] countObject = {"10","25","50","100","250"};
	private JComboBox countColum;
	private JLabel lblColumget;
	private JMenuBar jMenuBar;
	private JMenu jMenu;
	private JMenuItem jMenuItem;
	
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
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	void panelMenu(){
		
		jPanel = new JPanel();
		jPanel.setBounds(0, 0, 194, 271);
		getContentPane().add(jPanel);
		menuWork();
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	void panelAdd(){
		
		jPanel = new JPanel();
		jPanel.setBounds(0, 0, 194, 271);
		getContentPane().add(jPanel);
		jPanel.setLayout(null);	
		
		lblColumget = new JLabel("ColumGet");
		lblColumget.setBounds(10, 30, 70, 20);
		jPanel.add(lblColumget);
		
		countColum = new JComboBox(dbString);
		countColum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String columAdd = (String)countColum.getSelectedItem();
				System.out.println(columAdd);
				
				int ct = Integer.parseInt(columAdd);
				getContentPane().remove(jPanel);
				panelAdd();
				countColum.setSelectedItem(dbString[ct - 2]);
				jPanel.repaint(); 
				setVisible(true);
				jb.clear();
				for(int i = 0; i < ct+1; i++){
					if(i < ct){
					JLabel lblLogin = new JLabel((i + 1) + " colum");
					lblLogin.setBounds(10, 61 + (i*30), 50, 14);
					jPanel.add(lblLogin);
					
					comboBox = new JComboBox(forColum);
					comboBox.setBounds(100, 61 + (i*30), 70, 20);
					jPanel.add(comboBox);
					}else{
						JLabel lblLogin = new JLabel("AddNew");
						lblLogin.setBounds(10, 61 + (i*30), 50, 14);
						jPanel.add(lblLogin);
						 
						comboBox = new JComboBox(countObject);
						comboBox.setBounds(100, 61 + (i*30), 70, 20);
						jPanel.add(comboBox);
					}
					jb.add(comboBox);
				}
				
				jPanel.repaint(); 
				setVisible(true);
			}
		});
		
		countColum.setBounds(84, 30, 100, 20);
		jPanel.add(countColum);
		
		JButton btnokok = new JButton("Ok");
		btnokok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < jb.size(); i++){
					System.out.println((String)jb.get(i).getSelectedItem());
				}
			}
		});
		btnokok.setBounds(111, 237, 73, 23);
		jPanel.add(btnokok);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnClear.setBounds(10, 237, 73, 23);
		jPanel.add(btnClear);
		
		menuWork();
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	void panelConfig(){
		
		jPanel = new JPanel();
		jPanel.setBounds(0, 0, 194, 271);
		getContentPane().add(jPanel);
		jPanel.setLayout(null);
		String[] sqlJDBC = {"MySql","PostgreSQL"};
		final JComboBox SQLSelect = new JComboBox(sqlJDBC);
		SQLSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlJDBCOne = (String)SQLSelect.getSelectedItem();
				System.out.println(sqlJDBCOne);
			}
		});
		
		SQLSelect.setBounds(66, 30, 100, 20);
		jPanel.add(SQLSelect);
		
		JLabel lblSql = new JLabel("SQL");
		lblSql.setBounds(20, 30, 50, 20);
		jPanel.add(lblSql);
		
		txtPort = new JTextField();
		txtPort.setBounds(80, 60, 86, 20);
		jPanel.add(txtPort);
		txtPort.setColumns(10);
		
		txtDB = new JTextField();
		txtDB.setBounds(80, 91, 86, 20);
		jPanel.add(txtDB);
		txtDB.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(80, 153, 86, 20);
		jPanel.add(txtLogin);
		
		JLabel lblLogin = new JLabel("PORT");
		lblLogin.setBounds(20, 63, 46, 14);
		jPanel.add(lblLogin);
		
		JLabel lblPasword = new JLabel("DB");
		lblPasword.setBounds(20, 93, 46, 14);
		jPanel.add(lblPasword);
		
		JLabel DBLabel = new JLabel("Login");
		DBLabel.setBounds(20, 156, 56, 14);
		jPanel.add(DBLabel);

		JLabel lblPort = new JLabel("Pass");
		lblPort.setBounds(20, 187, 56, 14);
		jPanel.add(lblPort);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(80, 184, 86, 20);
		jPanel.add(txtPass);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(80, 122, 86, 20);
		jPanel.add(textField);
		
		JLabel lblName = new JLabel("Table");
		lblName.setBounds(20, 125, 56, 14);
		jPanel.add(lblName);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forFormDBConnection = txtPort.getText();
				System.out.println(forFormDBConnection);
				forFormDBConnection = txtDB.getText();
				System.out.println(forFormDBConnection);
				forFormDBConnection = txtLogin.getText();
				System.out.println(forFormDBConnection);
				forFormDBConnection = txtPass.getText();
				System.out.println(forFormDBConnection);
			}
		});
		
		btnOk.setBounds(111, 237, 73, 23);
		jPanel.add(btnOk);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelConfig();
				forFormDBConnection = null;
			}
		});
		
		btnClear.setBounds(10, 237, 73, 23);
		jPanel.add(btnClear);
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
			}
		});
		
		jMenu.add(jMenuItem);
		
		jMenuItem = new JMenuItem("AddNewFild");
		jMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(jPanel);
				panelAdd();
				jPanel.repaint(); 
				setVisible(true);
			}
		});
		
		jMenu.add(jMenuItem);
		
		jMenuItem = new JMenuItem("Config");
		jMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(jPanel);
				panelConfig();
				jPanel.repaint();
				setVisible(true);
			}
		});
		
		jMenu.add(jMenuItem);
		repaint();
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////

}
