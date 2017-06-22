package ua.kiev.andersen.andrey.swing.project.dbadd.entity;

import java.sql.Date;



public class ResourcesToAdd {
	private int ID;
	private String NAME;
	private String LNAME;
	private int AGE;
	private Date DATES;
	private String NUMB;
	
	public ResourcesToAdd() {
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getLNAME() {
		return LNAME;
	}
	public void setLNAME(String lNAME) {
		LNAME = lNAME;
	}
	public int getAGE() {
		return AGE;
	}
	public void setAGE(int aGE) {
		AGE = aGE;
	}
	public Date getDATES() {
		return DATES;
	}
	public void setDATES(Date dATES) {
		DATES = dATES;
	}
	public String getNUMB() {
		return NUMB;
	}
	public void setNUMB(String nUMB) {
		NUMB = nUMB;
	}
	
	
	
	

}
