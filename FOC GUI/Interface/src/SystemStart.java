import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SystemStart{

	private static Interface foc_db = new Interface();
	/**
	 * @param 
	 * @author Brent Steffey
	 */
	private static Connection conn;
	public static void main(String[] args) {
		foc_db.start();

/*
		conn = null;
		try{
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost/foc_db";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			conn = DriverManager.getConnection(url, userName, password);
			calltoDB();
		}
		catch(Exception e){
			System.out.println("Exception found");
		}
	}
	public Connection getConnection(){
		return conn;
	}
	public void closeConnection(){
		try{
			conn.close ();
		}
		catch (Exception e) {
			System.out.println ("Connection close error");
		}
	}
	public static void calltoDB(){
		try {
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Connection con = DriverManager.getConnection("jdbc:odbc:Rosemary", "",""); 
			Statement s = conn.createStatement();
			s.execute("SELECT * FROM committee;");
			String userName = "INSERT INTO committee VALUES ('s', 'jonh')";
			ResultSet rs = s.getResultSet();
			System.out.println(rs);
			s.close(); 
			conn.close(); 
		}
		catch (Exception err) {
			System.out.println("ERROR: " + err);
		}*/
	}
}