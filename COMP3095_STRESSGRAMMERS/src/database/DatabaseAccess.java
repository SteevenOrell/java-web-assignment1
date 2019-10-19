package database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



	

public class DatabaseAccess {
	static private final String username ="admin";
	static private final String password = "P@ssword1";
	static private final String database = "COMP3095";

private static Connection connect = null;

public static Connection connectDataBase() throws Exception {
  try {
    // This will load the MySQL driver, each DB has its own driver
    
	  Class.forName("com.mysql.jdbc.Driver");
     //Setup the connection with the DB
   connect = DriverManager
	          .getConnection("jdbc:mysql://localhost:3306/"+database,username,password);
    return connect;
  } catch (Exception e) {
    throw e;
  } 
}

public boolean Insert(String fName,String lName, String mail, String address,String password) throws Exception {

	  
	
	if(connectDataBase() != null) {
		String cmd = "INSERT INTO users (firstname, lastname, email, role, password) VALUES(?,?,?,?,?)";
			
	PreparedStatement statm = connectDataBase().prepareStatement(cmd);
	statm.setString(1, fName);
	statm.setString(2, lName);
	statm.setString(3, mail);
	//statm.setString(4, address);
	statm.setString(4,"client");
	statm.setString(5, password);
	statm.executeUpdate();
	statm.close();
	connectDataBase().close();
	return true;
	}
		
	return false;
		
	
	
}

public boolean Check(String mail) throws Exception {

	  //Class.forName("com.mysql.jdbc.Driver");
	    // Setup the connection with the DB
	   // Connection connect = DriverManager
		 //         .getConnection("jdbc:mysql://localhost:3306/"+database,username,password);
	
	if(connectDataBase() != null) {
		
	String cmd = "SELECT * from users where email=?";
	PreparedStatement statm = connectDataBase().prepareStatement(cmd);
	statm.setString(1, mail);
	ResultSet r = statm.executeQuery();
	
	if(r.next()) {
		
		statm.close();
		connectDataBase().close();
		return true;
	}
	
	statm.close();
	connectDataBase().close();
	return false;
	}
		
	return false;
		
	
	
}

}
