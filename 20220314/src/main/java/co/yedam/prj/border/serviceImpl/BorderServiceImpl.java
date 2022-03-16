package co.yedam.prj.border.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.prj.border.service.BorderMapper;
import co.yedam.prj.border.service.BorderService;
import co.yedam.prj.border.service.BorderVO;
import co.yedam.prj.common.DataSource;

public class BorderServiceImpl implements BorderService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BorderMapper map = sqlSession.getMapper(BorderMapper.class);
	
	@Override
	public List<BorderVO> borderSelectList() {
		return map.borderSelectList();
	}

	@Override
	public BorderVO borderSelect(BorderVO vo) {
		return map.borderSelect(vo);
	}

	@Override
	public int BorderInsert(BorderVO vo) {
		return map.BorderInsert(vo);
	}

	@Override
	public int BorderUpdate(BorderVO vo) {
		return map.BorderUpdate(vo);
	}

	@Override
	public int BorderDelete(BorderVO vo) {
		return map.BorderDelete(vo);
	}

	@Override
	public List<BorderVO> borderSelectSearchList(String key, String val) {
		return map.borderSelectSearchList(key, val);
	}

	@Override
	public int borderUpdateHit(int id) {
		return map.borderUpdateHit(id);
	}

	@Override
	public List<BorderVO> borderSortList(String key) {
		return map.borderSortList(key);
	}
	
}
