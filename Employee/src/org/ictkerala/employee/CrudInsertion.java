package org.ictkerala.employee;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudInsertion {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
       Class.forName("com.mysql.cj.jdbc.Driver");
	   Scanner sc=new Scanner(System.in);
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usecase_schema","root","Soji@123");
	   System.out.print("Enter the Employeeid: ");
	   int empid=sc.nextInt();
	   sc.nextLine();
	   System.out.print("Enter the Name: ");
	   String name=sc.nextLine();
	   System.out.print("Enter the Department: ");
	   String department=sc.nextLine();
	   System.out.print("Enter the Designation: ");
	   String designation=sc.nextLine();
	   System.out.print("Enter the Date_Of_Joining: ");
	   String date_of_joining=sc.nextLine();
	   System.out.print("Enter the Salary: ");
	   int salary=sc.nextInt();
	   sc.nextLine();
	   System.out.print("Enter the City: ");
	   String city=sc.nextLine();
	   System.out.print("Enter Active");
	   String active=sc.nextLine();
	   String sql = "INSERT INTO employee_table (empid, name, department, designation, date_of_joining, salary, city, active) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	   PreparedStatement st=con.prepareStatement(sql);
	   st.setInt(1,empid);
	   st.setString(2,name);
	   st.setString(3, department);
	   st.setString(4, designation);
	   st.setString(5, date_of_joining);
	   st.setInt(6, salary);
	   st.setString(7, city);
	   st.setString(8, active);
	   int rowsInserted=st.executeUpdate(); 
	   if(rowsInserted>0)
		{
			System.out.println("A new employee added Successfully");
		}

    
		st.close();
		con.close();

	}

}
