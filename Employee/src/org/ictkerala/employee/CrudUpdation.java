package org.ictkerala.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudUpdation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
       Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usecase_schema","root","Soji@123");
		
		System.out.println("Enter the empid: ");
		int id=sc.nextInt();
		System.out.println("Enter the new salary: ");
		int salary=sc.nextInt();
		String sql="UPDATE employee_table SET Salary= ? WHERE empid = ?";

		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,salary);
		st.setInt(2, id);
		int rowsUpdate=st.executeUpdate();
		if(rowsUpdate>0)
		{
			System.out.println(" Updated Successfully");
		}
		
		st.close();
		con.close();
	}

}
