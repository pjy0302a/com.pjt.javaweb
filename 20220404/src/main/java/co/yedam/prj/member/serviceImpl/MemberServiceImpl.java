package co.yedam.prj.member.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.yedam.prj.member.service.MemberMapper;
import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.vo.MemberVO;

@Repository("memberDao")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberMapper map;	//SqlSessionTemplate가 알아서 주입된다.
	@Override
	public List<MemberVO> memberSelectList() {
		return map.memberSelectList();
		
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return map.memberDelete(vo);
	}

}
