package polyfive.entities.dao;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class DBConnectionManager {
		public static Connection con;
	    public static String url;
	    public static Statement stmt;
		public static ResultSet rs;
	    public static Connection getConnection() {
	     
	        try {
	            String url = "jdbc:mysql://localhost:8888/PolyFiveCorp";
	            // assuming "DataSource" is your DataSource name

	            Class.forName("com.mysql.jdbc.Driver");

	            try {
	                con = DriverManager.getConnection(url, "root", "");
	            }

	            catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	            
	            
	        }

	        catch (ClassNotFoundException e) {// "logger" prints in to a file;
	           
	            System.out.println(e);
	        }

	        return con;
	    }

	
	public static void connect(){
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:8888/PolyFiveCorp","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			rs = stmt.executeQuery("select * from users");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	/*	try {
			while(rs.next())
			{
				System.out.println(rs.getString("Username") + " " + rs.getString("Password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}
	}
