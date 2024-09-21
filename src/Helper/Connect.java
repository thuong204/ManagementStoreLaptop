package Helper;

import java.sql.Connection;

import java.sql.DriverManager;

public class Connect {
	public static Connection openConnection() throws Exception {
	    Connection connection =null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionURL ="jdbc:sqlserver://DESKTOP-DB9MFIJ\\SQLEXPRESS:1433;databaseName=QUANLICUAHANGLAPTOP;encrypt=false";
		connection = DriverManager.getConnection(connectionURL, "sa", "anhyeuem123");
		return connection;

	}
	


}
