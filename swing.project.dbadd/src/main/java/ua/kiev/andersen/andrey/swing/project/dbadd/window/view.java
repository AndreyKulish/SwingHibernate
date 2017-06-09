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
	
	JPanel panel = new JPanel();
	private JTextField txtPort;
	private JTextField txtDB;
	private JTextField txtLogin;
	JButton eer;
	JComboBox comboBox;
	private JTextField txtPass;
	String b;
	final ArrayList<JComboBox> jb = new ArrayList<JComboBox>();
	private JTextField textField;
	
	public view() {	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setSize(200, 300);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		
		menuWork();
		/*panelAdd();
		panelMenu();*/
		panelConfig();
		
		
		panel.repaint(); 
		setVisible(true);		
	}
	
	void panelMenu(){
		getContentPane().remove(panel);
		panel = new JPanel();
		panel.setBounds(0, 0, 194, 271);
		getContentPane().add(panel);
		menuWork();
		panel.repaint(); 
		setVisible(true);
		
	}
	
	void panelAdd(){
		getContentPane().remove(panel);
		panel = new JPanel();
		panel.setBounds(0, 0, 194, 271);
		getContentPane().add(panel);
		panel.setLayout(null);
		menuWork();
		
		JLabel lblColumget = new JLabel("ColumGet");
		lblColumget.setBounds(10, 30, 70, 20);
		panel.add(lblColumget);
		final String[] forColum = {"NULL","INT","NAME","LNAME","AGE","DATE","NUMB"};
		String[] dbString = {"2","3","4","5"};
		final String[] countObject = {"10","25","50","100","250"};
		
		final JComboBox countColum = new JComboBox(dbString);
		countColum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String columAdd = (String)countColum.getSelectedItem();
				System.out.println(columAdd);
				
				int ct = Integer.parseInt(columAdd);
				panelAdd();
				jb.clear();
				for(int i = 0; i < ct+1; i++){
					if(i < ct){
					JLabel lblLogin = new JLabel((i + 1) + " colum");
					lblLogin.setBounds(10, 61 + (i*30), 50, 14);
					panel.add(lblLogin);
					
					comboBox = new JComboBox(forColum);
					comboBox.setBounds(100, 61 + (i*30), 70, 20);
					panel.add(comboBox);
					}else{
						JLabel lblLogin = new JLabel("AddNew");
						lblLogin.setBounds(10, 61 + (i*30), 50, 14);
						panel.add(lblLogin);
						 
						comboBox = new JComboBox(countObject);
						comboBox.setBounds(100, 61 + (i*30), 70, 20);
						panel.add(comboBox);
					}
					jb.add(comboBox);
				}
				
				panel.repaint(); 
				setVisible(true);
			}
		});
		
		countColum.setBounds(84, 30, 100, 20);
		panel.add(countColum);
		
		JButton btnokok = new JButton("Ok");
		btnokok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < jb.size(); i++){
					System.out.println((String)jb.get(i).getSelectedItem());
				}
			}
		});
		btnokok.setBounds(111, 237, 73, 23);
		panel.add(btnokok);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnClear.setBounds(10, 237, 73, 23);
		panel.add(btnClear);
		
		
		panel.repaint(); 
		setVisible(true);
		
	}
	
	void panelConfig(){
		getContentPane().remove(panel);
		panel = new JPanel();
		panel.setBounds(0, 0, 194, 271);
		getContentPane().add(panel);
		panel.setLayout(null);
		menuWork();
		String[] sqlJDBC = {"MySql","PostgreSQL"};
		final JComboBox SQLSelect = new JComboBox(sqlJDBC);
		SQLSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlJDBCOne = (String)SQLSelect.getSelectedItem();
				System.out.println(sqlJDBCOne);
			}
		});
		
		
		
		
		SQLSelect.setBounds(66, 30, 100, 20);
		panel.add(SQLSelect);
		
		JLabel lblSql = new JLabel("SQL");
		lblSql.setBounds(20, 30, 50, 20);
		panel.add(lblSql);
		
		
		txtPort = new JTextField();
		txtPort.setBounds(80, 60, 86, 20);
		panel.add(txtPort);
		txtPort.setColumns(10);
		
		
		txtDB = new JTextField();
		txtDB.setBounds(80, 91, 86, 20);
		panel.add(txtDB);
		txtDB.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(80, 153, 86, 20);
		panel.add(txtLogin);
		
		JLabel lblLogin = new JLabel("PORT");
		lblLogin.setBounds(20, 63, 46, 14);
		panel.add(lblLogin);
		
		JLabel lblPasword = new JLabel("DB");
		lblPasword.setBounds(20, 93, 46, 14);
		panel.add(lblPasword);
		
		JLabel DBLabel = new JLabel("Login");
		DBLabel.setBounds(20, 156, 56, 14);
		panel.add(DBLabel);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b = txtPort.getText();
				System.out.println(b);
				b = txtDB.getText();
				System.out.println(b);
				b = txtLogin.getText();
				System.out.println(b);
				b = txtPass.getText();
				System.out.println(b);
			}
		});
		btnOk.setBounds(111, 237, 73, 23);
		panel.add(btnOk);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelConfig();
				b = null;
			}
		});
		btnClear.setBounds(10, 237, 73, 23);
		panel.add(btnClear);
		
		JLabel lblPort = new JLabel("Pass");
		lblPort.setBounds(20, 187, 56, 14);
		panel.add(lblPort);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(80, 184, 86, 20);
		panel.add(txtPass);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(80, 122, 86, 20);
		panel.add(textField);
		
		JLabel lblName = new JLabel("Table");
		lblName.setBounds(20, 125, 56, 14);
		panel.add(lblName);
		
		menuWork();
		
		panel.repaint(); 
		setVisible(true);
	}
	
	void menuWork(){
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 194, 27);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Select Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmMain = new JMenuItem("Main");
		mntmMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu();
			}
		});
		mnNewMenu.add(mntmMain);
		
		JMenuItem mntmAddnewfild = new JMenuItem("AddNewFild");
		mntmAddnewfild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAdd();
			}
		});
		mnNewMenu.add(mntmAddnewfild);
		
		JMenuItem mntmConfig = new JMenuItem("Config");
		mntmConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelConfig();
			}
		});
		mnNewMenu.add(mntmConfig);
		repaint();
	}
}
