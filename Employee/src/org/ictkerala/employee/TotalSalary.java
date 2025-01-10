package org.ictkerala.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalSalary {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/usecase_schema";
        String username = "root";
        String password = "Soji@123";
        String sql = "SELECT SUM(salary) AS total_salary FROM employee_table WHERE department = 'HR'";
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        int totalSalary = 0;
        if (rs.next()) {
            totalSalary = rs.getInt("total_salary");
        }

      System.out.println("Total salary paid to employees in the HR department: " + totalSalary);

        
        st.close();
        con.close();
    }
}

	


