package com.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDAO extends DAO{
	public List<Map<String, String>> getMemberList(){
		connect();
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		try {
			psmt = conn.prepareStatement("SELECT * FROM MEMBER");
			rs = psmt.executeQuery(); //
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("name", rs.getString("name"));	
				map.put("age", rs.getString("age"));
				map.put("score", rs.getString("score"));
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return list;
		
	}
	public void insertMember(Map<String, String>map) {
		connect();
		String sql = "INSERT INTO MEMBER VALUES(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, map.get("name"));
			psmt.setString(2, map.get("age"));
			psmt.setString(3, map.get("score"));
			int r = psmt.executeUpdate();
			System.out.println(r + " 건 입력함");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} 
	}
}

