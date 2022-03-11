package com.edu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edu.dao.DAO;

public class listDAO extends DAO{
	public void insertList(String myInput) {
		String sql = "insert into to_do_list values(TO_DO_SEQ.nextval,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, myInput);
			int r = psmt.executeUpdate();
			System.out.println(r + "입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Map<String, String>> AllList(){
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		try {
			String sql = "select * from to_do_list order by 1";
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("ID",rs.getString("DO_ID")); 
				map.put("CONTENT", rs.getString("DO_CONTENT"));
				
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
