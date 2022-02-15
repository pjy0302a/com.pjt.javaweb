package com.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemberDAO extends DAO {
	// PS, Co, RS, connect(), disconnect()
	
	public List<Map<String, String>> getMemberList(){
		connect();
		List<Map<String, String>> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("SELECT * FROM MEMBER");
			rs = psmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("name",rs.getString("name"));
				map.put("age", rs.getString("age"));
				map.put("score", rs.getString("score"));
				list.add(map);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	public void insertMember(Map<String, String> map) {
		connect();
		String sql = "insert into member values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, map.get("name"));
			psmt.setString(2, map.get("age"));
			psmt.setString(3, map.get("score"));

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
