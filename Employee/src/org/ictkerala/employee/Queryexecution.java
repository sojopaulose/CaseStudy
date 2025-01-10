package org.ictkerala.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Queryexecution {

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/usecase_schema";
        String username = "root";
        String password = "Soji@123";

        
        String sql = "SELECT empid, name, department, salary, active FROM employee_table " +
                     "WHERE department = 'IT' AND active = 'Yes' AND salary > 600000";

             Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int empid = rs.getInt("empid");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");
                String active = rs.getString("active");

                
                System.out.println("Employee ID: " + empid);
                System.out.println("Name: " + name);
                System.out.println("Department: " + department);
                System.out.println("Salary: " + salary);
                System.out.println("Active: " + active);
                System.out.println("-----------------------------");
            }

            st.close();
            con.close();
	}
}
