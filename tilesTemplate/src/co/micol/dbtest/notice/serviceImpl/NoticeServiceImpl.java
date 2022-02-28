package co.micol.dbtest.notice.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.micol.dbtest.common.DAO;
import co.micol.dbtest.notice.service.NoticeService;
import co.micol.dbtest.notice.vo.NoticeVO;

public class NoticeServiceImpl extends DAO implements NoticeService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<NoticeVO> noticeSelectList() {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "select * from notice";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		String sql = "select * from notice where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				hitCount(vo.getId()); // 조회수 증가하는 메소드
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		int n = 0;
		try {
			// 시퀀스 조회
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select notice_seq.nextval from dual");
			rs.next();
			int id = rs.getInt(1);
			vo.setId(id);

			// 등록
			String sql = "insert into notice(id, title, content, wdate) values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setDate(4, vo.getWdate());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		int n = 0;
		String sql = "update notice set  title=?, content=? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	@Override
	public int deleteNotice(NoticeVO vo) {
		int n = 0;
		String sql = "delete notice where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	public List<NoticeVO> selectNoticeListPaging(int page) {
		String sql = "SELECT b.rn\r\n"//
				+ "      ,b.*\r\n"//
				+ "FROM   (SELECT ROWNUM rn\r\n"//
				+ "              ,a.*\r\n"//
				+ "        FROM   (SELECT *\r\n"//
				+ "                FROM   notice\r\n"//
				+ "                ORDER  BY 1) a) b\r\n"//
				+ "WHERE  b.rn BETWEEN ? AND ?";

		List<NoticeVO> list = new ArrayList<>();
		int firstCnt = 0, lastCnt = 0;

		firstCnt = (page - 1) * 10 + 1;
		lastCnt = (page * 10);
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			rs = psmt.executeQuery();
			while (rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setWdate(rs.getDate("wdate"));

				list.add(vo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

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

	private void hitCount(int key) {
		String sql = "update notice set hit = hit + 1 where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, key);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
