package datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDatabase {

	public static void main(String[] args) throws SQLException {
		//step 1:create an instance of jdbc driver
				Driver dbDriver=new Driver();
				//step 2:register driver
				DriverManager.registerDriver(dbDriver);
				//step 3:Establish database connection
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel","root","root");
				//step 4:create statement
				Statement statement=connection.createStatement();
				//step 5:execute query to update database
				int result=statement.executeUpdate("insert into employees(id,name,salary,phone)"+"values(167,'NNN',45000,'1234567890');");
		        if(result==1)
		        	System.out.println("database updated successfully");
		        else
		        	System.out.println("Database not updated");
		        //close the connection
		        connection.close();
	}

}
