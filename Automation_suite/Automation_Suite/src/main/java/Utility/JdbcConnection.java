package Utility;
import java.sql.Connection;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnection {
	
  public static void main(String[] args)
    {
	  try {
    String url="jdbc:sqlserver://66.77.5.168;database=accenture";
   
    	String username="myl.build";
    	String password="myLearning##SA";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection(url,username,password);
                if (conn != null) {
        		    System.out.println("Connected");
        		}
        		String sql="select * from tblemp where emp_pk=1337088";
        		Statement st=conn.createStatement();
        		ResultSet rs=st.executeQuery(sql);
        		while(rs.next()){
        			String empname=rs.getString("Emp_fname");
        			System.out.println(empname);
    } 
        		}
        		catch (Exception e) {
               
                e.printStackTrace();
    }
    }}
  


	/*public static void main(String[] args) throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String dbURL = "jdbc:sqlserver://66.77.5.168//accenture;user=myl.build;password=myLearning##SA";

		Connection conn=DriverManager.getConnection(dbURL);
		if (conn != null) {
		    System.out.println("Connected");
		}
		String sql="select Emp_fname from tblemp";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()){
			String empname=rs.getString("Emp_fname");
			System.out.println(empname);
		}
		rs.close();
		*/
		
		
	


