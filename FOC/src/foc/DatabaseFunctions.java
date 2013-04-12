package foc;
import java.sql.*;

public class DatabaseFunctions {

DatabaseFunctions(){
  
}
public void connect (String[] args) throws Exception{
    // Accessing Driver From Jar File
    Class.forName("com.mysql.jdbc.Driver");
    }
public String eligible(){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foc","root","");
	Statement s = con.createStatement();
	String toAdd = ("SELECT first_name, last_name, department FROM member WHERE eligib = '1';");
	s.execute(toAdd);
	s.close(); 
	con.close();
        return toAdd;
	}
	catch(Exception e){
        return null;
  }
}
public void addFaculty(String FacFirst, String FacLast){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foc","root","");
	Statement s = con.createStatement();
	String toAdd = ("INSERT INTO member(first_name, last_name) VALUES (\"" + FacFirst + "\", \"" + FacLast + "\";)");
	s.execute(toAdd);
	s.close(); 
	con.close();
	}
	catch(Exception e){
  }
}
public void addCommittee(String Comm){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foc","root","");
	Statement s = con.createStatement();
	String toAdd = ("INSERT INTO committee(name) VALUES (\"" + Comm + "\";)");
	s.execute(toAdd);
	s.close(); 
	con.close();
	}
	catch(Exception e){
  }
}
public void removeComm(String Comm){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foc","root","");
	Statement s = con.createStatement();
	String toAdd = ("DELETE FROM Committee WHERE name = \"" + Comm + "\";");
	s.execute(toAdd);
	s.close(); 
	con.close();
	}
	catch(Exception e){
  }
}
public void removeFaculty(String Fac){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foc","root","");
	Statement s = con.createStatement();
	String toAdd = ("DELETE FROM member WHERE name = '\"" + Fac + "\"';");
	s.execute(toAdd);
	s.close(); 
	con.close();
	}
	catch(Exception e){
  }
}
public void addMembers(String Fac, String Comm){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foc","root","");
	Statement s = con.createStatement();
	String toAdd =("UPDATE Committee SET members =  '\"" + Fac + "\"' WHERE name = '\"" + Comm + "\"';");
	s.execute(toAdd);
	s.close(); 
	con.close();
	}
	catch(Exception e){
  }
}
public String searchComm(String Comm){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foc","root","");
	Statement s = con.createStatement();
	String toAdd =("SELECT FROM committee WHERE name = '\"" + Comm + "\"';");
	s.execute(toAdd);
        
	s.close(); 
	con.close();
        return toAdd;
	}
	catch(Exception e){
        return null;
  }   
}
public String searchFac(String Fac){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foc","root","");
	Statement s = con.createStatement();
	String toAdd =("SELECT FROM committee WHERE name = '\"" + Fac + "\"';");
	s.execute(toAdd);
        
	s.close(); 
	con.close();
        return toAdd;
	}
	catch(Exception e){
             return null;  
  }
}
public boolean verifyFac(String Fac){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foc","root","");
	PreparedStatement statement= con.prepareStatement("SELECT FROM member WHERE name = '\"" + Fac + "\"';");
	statement.setString(1,Fac);
	statement.execute();
	return(statement.equals("Yes"));
	}
	catch(Exception e){
		return false;
  }
}
public boolean verifyComm(String Comm){
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foc","root","");
	PreparedStatement statement= con.prepareStatement("SELECT FROM committee WHERE name = '\"" + Comm + "\"';");
	statement.setString(1,Comm);
	statement.execute();
	return(statement.equals("Yes"));
	}
	catch(Exception e){
		return false;
  }
}
public void addDepartment(String Fac, String Depart){
    try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foc","root","");
	Statement s = con.createStatement();
	String toAdd =("UPDATE member SET department =  '\"" + Depart + "\"' WHERE name = '\"" + Fac + "\"';");
	s.execute(toAdd);
	s.close(); 
	con.close();
	}
	catch(Exception e){
  }
}
}
