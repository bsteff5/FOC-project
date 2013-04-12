import java.sql.*;

public class Database_Functions {

Database_Functions(){
  
}

public void connect (String[] args) throws Exception{
    // Accessing Driver From Jar File
    Class.forName("com.mysql.jdbc.Driver");
    }

public void eligible(){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:Users'\'My User'\'Documents'\'GitHub'\'FOC-project","root","");
	Statement s = con.createStatement();
	String toAdd = ("SELECT * FROM members WHERE eligib");
	s.execute(toAdd);
	s.close(); 
	con.close();
	}
	catch(Exception e){
  }
}

public void addFaculty(String FacFirst, String FacLast){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:Users'\'My User'\'Documents'\'GitHub'\'FOC-project","root","");
	Statement s = con.createStatement();
	String toAdd = ("INSERT INTO member(first_name, last_name) VALUES (\"" + FacFirst + "\", \"" + FacLast + "\")");
	s.execute(toAdd);
	s.close(); 
	con.close();
	}
	catch(Exception e){
  }
}
public void removeComm(String Comm){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	Statement s = con.createStatement();
	String toAdd = ("DELETE FROM Committee WHERE name = \"" + Comm + "\"");
	s.execute(toAdd);
	s.close(); 
	con.close();;
	}
	catch(Exception e){
  }
}
public void addCommitte(String Comm){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	PreparedStatement statement= con.prepareStatement("INSERT INTO Committee(name) VALUES ( \"" + Comm + "\")");
	statement.setString(1,Comm);
	statement.execute();
	}
	catch(Exception e){
  }
}
public void searchComm(String Comm){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	PreparedStatement statement= con.prepareStatement("SELECT FROM Committee WHERE name LIKE ");
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
