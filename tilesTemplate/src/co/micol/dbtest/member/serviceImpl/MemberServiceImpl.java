package co.micol.dbtest.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.dbtest.common.DAO;
import co.micol.dbtest.member.service.MemberService;
import co.micol.dbtest.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> selectMemberList() {
		
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "SELECT * FROM MEMBERS";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_Id"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberAddress(rs.getString("member_address"));
				members.add(vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return members;
		
	}

	@Override
	public MemberVO selectMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		String sql = "insert into members values(?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberPassword());
			psmt.setString(4, vo.getMemberAddress());
			r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		String sql = "select * from members where member_id=? and member_password=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberName(rs.getString("member_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public boolean idCheck(String id) {
		boolean isId = false; // 초기값을 존재하지 않는것을 기준으로 한다.
		String sql = "select member_id from members where member_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next())
				isId = true; // 레코드에 값이 존재하면
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return isId;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
