package org.ictkerala.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataactiveValidation {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usecase_schema", "root", "Soji@123");
        
        
        String sql = "SELECT empid, active FROM employee_table";
        
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        
        boolean isValid = true;

  
        while (rs.next()) {
            
            String active = rs.getString("active");
            int empid = rs.getInt("empid");  // Corrected column name to 'empid'
            
            
            if (!"Yes".equalsIgnoreCase(active) && !"No".equalsIgnoreCase(active)) {
                
                System.out.println("Warning: Invalid 'Active' value found for employee with ID " + empid + ". Invalid value: " + active);
                isValid = false;
            }
        }

       
        if (isValid) {
            System.out.println("Validation Passed: All records have valid 'Active' values (Yes/No).");
        }

        // Close the resources
        st.close();
        con.close();
    }
}