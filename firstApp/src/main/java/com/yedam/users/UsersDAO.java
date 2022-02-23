package com.yedam.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
	// Sqlite 연결정보
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";

		// 각 메서드에서 공통적으로 사용하는 필드
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 싱글톤
		private static UsersDAO instance = new UsersDAO();
		private UsersDAO() {}
		public static UsersDAO getInstance() {
			return instance;
		}

		// JDBC Driver 로딩
		// DB 서버 접속
		// -> connect() 메서드

		public void connect() {
			try {
				Class.forName(jdbc_driver);
				conn = DriverManager.getConnection(jdbc_url, "hr","hr");
			} 
			catch (ClassNotFoundException e) {
				System.out.println("JDBC Driver 로딩 실패");} 
			catch (SQLException e) {
				System.out.println("DB 접속 실패");
			}
		}

		// 자원해제 -> disconnect() 메서드
		public void disconnect() {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("정상적으로 자원이 해제되지 않았습니다.");
			}
		}

		// PreparedStatement 객체 생성
		// SQL 실행
		// 결과값 출력 or 연산
		// -> 각 CRUD 메서드로 반복적으로 사용

		// 전체조회
		public List<Users> selectAll() {
			List<Users> list = new ArrayList<>();
			try {
				connect();
				String select = "SELECT * FROM Users ORDER BY id";
				pstmt = conn.prepareStatement(select);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Users user = new Users();
					user.setId(rs.getString("id"));
					user.setPwd(rs.getString("pwd"));
					user.setName(rs.getString("name"));
					user.setHobby(rs.getString("hobby"));
					user.setGender(rs.getString("gender"));
					user.setReligion(rs.getString("religion"));
					user.setIntroduction(rs.getString("introduction"));
					list.add(user);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}

			return list;
		}

		// 단건조회
		public Users selectOne(int id) {
			Users user = null;
			try {
				connect();
				String select = "SELECT * FROM Users WHERE id = ?";
				pstmt = conn.prepareStatement(select);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					user = new Users();
					user.setId(rs.getString("id"));
					user.setPwd(rs.getString("pwd"));
					user.setName(rs.getString("name"));
					user.setHobby(rs.getString("hobby"));
					user.setGender(rs.getString("gender"));
					user.setReligion(rs.getString("religion"));
					user.setIntroduction(rs.getString("introduction"));
					

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}

			return user;

		}
		
		// 등록
		public void insert(Users user) {
			try {
				connect();
				String insert = "INSERT INTO Users (id,pwd,name,hobby,gender,religion,introduction)"+" VALUES(?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(insert);
				pstmt.setString(1,user.getId());
				pstmt.setString(2,user.getPwd());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getHobby());
				pstmt.setString(5, user.getGender());
				pstmt.setString(6, user.getReligion());
				pstmt.setString(7, user.getIntroduction());
				
				int result = pstmt.executeUpdate();
				
				System.out.println(result + "건이 등록되었습니다.");
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		
		// 수정
		public void update(Users user) {
			try {
				connect();
				String update = "UPDATE Users SET pwd = ? WHERE id = ?";
				pstmt = conn.prepareStatement(update);
				
				pstmt.setString(1, user.getPwd());
				pstmt.setString(2, user.getId());
				
				int result = pstmt.executeUpdate();
				
				System.out.println(result + "건이 수정되었습니다.");
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			
		}
		// 삭제
		public void delete(String id) {
			try {
				connect();
				String delete = "DELETE FROM Users WHERE id";
				pstmt = conn.prepareStatement(delete);
				
				pstmt.setString(1, id);
				
				int result = pstmt.executeUpdate();
				
				System.out.println(result + "건이 삭제 되었습니다.");
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			};
		}
	}