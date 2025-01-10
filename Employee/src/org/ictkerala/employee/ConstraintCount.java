package org.ictkerala.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConstraintCount {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	 
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usecase_schema", "root", "Soji@123");
                String sql = "SELECT city, COUNT(*) AS employee_count FROM employee_table GROUP BY city";
		        PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                while (rs.next())
		        { 
		            String city = rs.getString("city"); 
		            int employeeCount = rs.getInt("employee_count"); // Use the alias correctly
		            System.out.println("City: " + city + ", Employee Count: " + employeeCount);
		        }

		        
		        rs.close();
		        st.close();
		        con.close();
		   


}
}
