package com.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemberDAO extends DAO {
	// PS, Co, RS, connect(), disconnect()

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
