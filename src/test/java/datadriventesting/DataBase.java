package datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;




public class DataBase {

	public static void main(String[] args) throws SQLException {
		//step 1:create an instance of jdbc driver
		Driver dbDriver=new Driver();
		//step 2:register driver
		DriverManager.registerDriver(dbDriver);
		//step 3:Establish database connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel","root","root");
		//step 4:create statement
		Statement statement=connection.createStatement();
		//step 5 Execute query to fetch the data
		ResultSet result=statement.executeQuery("select * from employees;");
		while(result.next())//---->"/t" is for tab space
		{
			System.out.println(result.getInt("id")+"\t"+result.getString("name")+"\t"+result.getInt("salary")+"\t"+result.getString("phone"));
		}
		//close database connection
		connection.close();

	}

}
