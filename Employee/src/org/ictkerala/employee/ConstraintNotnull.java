package org.ictkerala.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ConstraintNotnull {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		   Scanner sc=new Scanner(System.in);
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usecase_schema","root","Soji@123");
		
		   String sql = "INSERT INTO employee_table (empid, name, department, designation, date_of_joining, salary, city, active) "
		            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		   PreparedStatement st=con.prepareStatement(sql);
		   st.setInt(1,118);
		   st.setString(2,null);
		   st.setString(3, null);
		   st.setString(4, "HR");
		   st.setString(5, "2021-12-10");
		   st.setInt(6,700000);
		   st.setString(7, "Delhi");
		   st.setString(8, "Yes");
		
		   int rowsInserted=st.executeUpdate(); 
		   if(rowsInserted>0)
			{
				System.out.println("A new employee added Successfully");
			}
		   else
		   {
			   System.out.println("Error occured");
		   }
		
	    
	   
			st.close();
			con.close();

	

}
}
