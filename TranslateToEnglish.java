
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Try1  
{
	
public static void main ( String args []) throws IOException
{
	
	File file = new File("C:\\Users\\Shaalaka Naidu\\Documents\\MATLAB\\ny.txt");
	 
	  BufferedReader br = new BufferedReader(new FileReader(file));
	 
	  String a;
	  while ((a = br.readLine()) != null)
	    
	
	
	try{  
		//step1 load the driver class  
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
		  
		//step2 create  the connection object  
		  String userName = "sa";
		  String password = "shami1419";

		  String url = "jdbc:sqlserver://localhost\\SHAMITHASQL:1433;databaseName=Final;";
		  Connection con = DriverManager.getConnection(url, userName, password);

		  

		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select English from dbo.Sheet1$ where French= '"+a+"'");
		
		if(rs.next())  
		System.out.println(rs.getString(1));  
		String export =rs.getString(1);
		  
		//step5 close the connection object  
		con.close();  
		
		PrintWriter p = new PrintWriter("C://shami/Mini Project//export.txt");
		    p.println(export);
		  p.close();
		}catch(Exception e){ System.out.println(e);}  
	
	
		}  
	
}