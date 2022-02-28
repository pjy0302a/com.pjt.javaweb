package co.micol.dbtest.bbs.service;

import java.util.List;

import co.micol.dbtest.bbs.vo.BulletinVO;
import co.micol.dbtest.notice.vo.NoticeVO;

public interface BulletinService {
	List<BulletinVO> bulletinSelectList();
	BulletinVO bulletinSelect(BulletinVO vo);
	int insertBulletin(BulletinVO vo);
	int updateBulletin(BulletinVO vo);
	int deleteBulletin(BulletinVO vo);
}
