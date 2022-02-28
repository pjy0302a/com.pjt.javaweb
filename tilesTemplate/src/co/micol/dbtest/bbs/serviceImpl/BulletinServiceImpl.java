package co.micol.dbtest.bbs.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.dbtest.bbs.service.BulletinService;
import co.micol.dbtest.bbs.vo.BulletinVO;
import co.micol.dbtest.common.DAO;

public class BulletinServiceImpl extends DAO implements BulletinService {
	PreparedStatement psmt;
	ResultSet rs;

	@Override
	public List<BulletinVO> bulletinSelectList() {
		String sql = "select * from bbs order by 1";
		List<BulletinVO> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BulletinVO vo = new BulletinVO();
				vo.setBbsContent(rs.getString("bbs_content"));
				vo.setBbsCreateDate(rs.getDate("bbs_create_date"));
				vo.setBbsHit(rs.getInt("bbs_hit"));
				vo.setBbsId(rs.getInt("bbs_id"));
				vo.setBbsImage(rs.getString("bbs_image"));
				vo.setBbsTitle(rs.getString("bbs_title"));
				vo.setBbsWriter(rs.getString("bbs_writer"));

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
	public BulletinVO bulletinSelect(BulletinVO vo) {
		String sql = "select * from bbs where bbs_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBbsId());
			rs = psmt.executeQuery();
			if (rs.next()) {
//				vo = new BulletinVO();
				vo.setBbsContent(rs.getString("bbs_content"));
				vo.setBbsCreateDate(rs.getDate("bbs_create_date"));
				vo.setBbsHit(rs.getInt("bbs_hit"));
				vo.setBbsImage(rs.getString("bbs_image"));
				vo.setBbsTitle(rs.getString("bbs_title"));
				vo.setBbsWriter(rs.getString("bbs_writer"));
				System.out.println("hhh: " + vo.getBbsId());

				addCount(vo.getBbsId());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertBulletin(BulletinVO vo) {
		String sql = "insert into bbs(bbs_id, bbs_title, bbs_content, bbs_writer, bbs_create_date, bbs_hit) values(bbs_id_seq.nextval, ?,?,?,sysdate,0)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBbsTitle());
			psmt.setString(2, vo.getBbsContent());
			psmt.setString(3, vo.getBbsWriter());
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int updateBulletin(BulletinVO vo) {
		String sql = "update bbs set bbs_title=?, bbs_content=? where bbs_id=?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBbsTitle());
			psmt.setString(2, vo.getBbsContent());
			psmt.setInt(3, vo.getBbsId());
			r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int deleteBulletin(BulletinVO vo) {
		// TODO Auto-generated method stub
		String sql = "delete from bbs where bbs_id = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBbsId());

			r = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	public void addCount(int id) {
		System.out.println("id: " + id);
		String sql = "update bbs set bbs_hit = bbs_hit + 1 where bbs_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + " qusrud");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	private void close() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		if (psmt != null)
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
