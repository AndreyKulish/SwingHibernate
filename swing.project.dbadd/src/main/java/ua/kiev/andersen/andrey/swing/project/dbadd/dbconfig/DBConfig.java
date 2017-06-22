package ua.kiev.andersen.andrey.swing.project.dbadd.dbconfig;

public class DBConfig {
	
	private static String SQL;
	private static String PORT;
	private static String DB;
	private static String TABLE;
	private static String LOGIN;
	private static String PASS;
	
	public static String getSQL() {
		return SQL;
	}
	public static void setSQL(String sQL) {
		SQL = sQL;
	}
	public static String getPORT() {
		return PORT;
	}
	public static void setPORT(String pORT) {
		PORT = pORT;
	}
	public static String getDB() {
		return DB;
	}
	public static void setDB(String dB) {
		DB = dB;
	}
	public static String getTABLE() {
		return TABLE;
	}
	public static void setTABLE(String tABLE) {
		TABLE = tABLE;
	}
	public static String getLOGIN() {
		return LOGIN;
	}
	public static void setLOGIN(String lOGIN) {
		LOGIN = lOGIN;
	}
	public static String getPASS() {
		return PASS;
	}
	public static void setPASS(String pASS) {
		PASS = pASS;
	}
	
}
