package org.ictkerala.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudDeletion {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		  Scanner sc=new Scanner(System.in);
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usecase_schema","root","Soji@123");
		  System.out.println("Enter the Employeeid: ");
		  int id=sc.nextInt();
		  String sql = "DELETE FROM employee_table WHERE empid = ?";
		  PreparedStatement st=con.prepareStatement(sql);
		  st.setInt(1,id);
		  int rowsDelete=st.executeUpdate();
			if(rowsDelete>0)
			{
				System.out.println(" Deleted Successfully");
			}
			
			st.close();
			con.close();


	}

}
