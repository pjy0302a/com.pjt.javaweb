package com.edu.comments;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.DAO;

public class commentDAO extends DAO{
	//��ü��ȸ
	public List<Comment> selectAll(){
		List<Comment> list = new ArrayList<Comment>();
		connect();
		try {
			psmt = conn.prepareStatement("select * from comments order by id");
			rs = psmt.executeQuery();
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getString("id"));
				comment.setName(rs.getString("name"));
				comment.setContent(rs.getString("content"));
				list.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	//�Է�ó��
	public Comment insertComment(Comment comment) {
		connect();
		String sql1 = "select value from id_repository where name = 'COMMENT'";
		String sql2 = "insert into comments values(?, ?, ?)";
		String sql3 = "update id_repository set value = ? where name = 'COMMENT'";
		try {
			psmt = conn.prepareStatement(sql1);
			rs = psmt.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt("value");
			}
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, seq);
			psmt.setString(2, comment.getName());
			psmt.setString(3, comment.getContent());
			int r = psmt.executeUpdate();
			System.out.println(r + "�� �Էµ�.");
			comment.setId(String.valueOf(seq));
			
			psmt = conn.prepareStatement(sql3);
			seq++;
			psmt.setInt(1, seq);
			r = psmt.executeUpdate();
			System.out.println(r + "�� ������.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return comment;	
	}
	// ����ó��
	public void updateComment(Comment comment) {
		connect();
		String sql  = "update comments set name=?, content=? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  comment.getName());
			psmt.setString(2, comment.getContent());
			psmt.setString(3, comment.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "�� �����.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// ����ó��
	public boolean deleteComment(String id) {
		connect();
		String sql = "delete from comments where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			
			if(r==1) {
				System.out.println(r+"�� ������.");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
		
	}
	// �ܰ���ȸ
	public Comment selectOne(String id) {
		connect();
		String sql = "select * from comments where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getString("id"));
				comment.setName(rs.getString("name"));
				comment.setContent(rs.getString("content"));
				return comment;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
}
