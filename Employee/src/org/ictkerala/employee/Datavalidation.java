package org.ictkerala.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datavalidation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/usecase_schema";
        String username = "root";
        String password = "Soji@123";
        String sql = "SELECT empid, name, salary FROM employee_table WHERE salary < 400000";
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        boolean isValid = true;
        while (rs.next()) {
            int empid = rs.getInt("empid");
            String name = rs.getString("name");
            double salary = rs.getDouble("salary");

            // Log a warning for each employee with invalid salary
            System.out.println("Warning: Employee with ID " + empid + " and name " + name + 
                               " has a salary of " + salary + " which is less than or equal to 400000.");
            isValid = false;
        }

        
        if (isValid) {
            System.out.println("Validation Passed: salary of 1 is not greater than 400000.");
        }

       
        stmt.close();
        con.close();
	}
}