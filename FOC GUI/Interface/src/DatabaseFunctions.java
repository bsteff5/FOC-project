import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseFunctions {

DatabaseFunctions(){
  
}

public void connect (String[] args) throws Exception{
    // Accessing Driver From Jar File
    Class.forName("com.mysql.jdbc.Driver");
    }

public void addFaculty(String Fac){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	PreparedStatement statement= con.prepareStatement("INSERT INTO Faculty(name) VALUES (?)");
	statement.setString(1,Fac);
	statement.execute();
	}
	catch(Exception e){
  }
}
public void removeComm(String Comm){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	PreparedStatement statement= con.prepareStatement("DELETE FROM Committee WHERE name = ?");
	statement.setString(1,Comm);
	statement.execute();
	}
	catch(Exception e){
  }
}
public void addCommitte(String Comm){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	PreparedStatement statement= con.prepareStatement("INSERT INTO Committee(name) VALUES (?)");
	statement.setString(1,Comm);
	statement.execute();
	}
	catch(Exception e){
  }
}
public void searchComm(String Comm){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	PreparedStatement statement= con.prepareStatement("SELECT FROM Committee WHERE name LIKE ?");
	statement.setString(1,Comm);
	statement.execute();
	}
	catch(Exception e){
  }
}
public boolean verifyFac(String Fac){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	PreparedStatement statement= con.prepareStatement("SELECT FROM Faculty WHERE name LIKE ?");
	statement.setString(1,Fac);
	statement.execute();
	return(statement.equals("Yes"));
	}
	catch(Exception e){
		return false;
  }
}
}
