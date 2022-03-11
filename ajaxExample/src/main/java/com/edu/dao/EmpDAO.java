package com.edu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDAO extends DAO{
	
	public void insertEmp(String firstName, int salary) {
		String sql = "insert into employees(employee_id, last_name, email, hire_date,job_id,first_name,salary)\r\n"
				+ "values(EMPLOYEES_SEQ.nextval, 'last', 'email.com'||employees_seq.currval,sysdate,'IT_PROG',?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, firstName);
			psmt.setInt(2, salary);
			int r = psmt.executeUpdate();
			System.out.println(r + "입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Map<String, String>> empList(){
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		try {
			String sql = "select first_name, salary from employees\r\n"
					+ "where salary is not null ORDER BY 1 DESC";
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("name",rs.getString("first_name")); 
				map.put("age", rs.getString("salary"));
				
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
