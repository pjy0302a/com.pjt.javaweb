package com.yedam.prj.member.service;

import java.util.List;

import com.yedam.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList(); //전체 회원목록(R)
	MemberVO memberSelect(MemberVO vo);	//단건 조회(R)
	int memberInsert(MemberVO vo);		//회원 추가(C)
	int memberUpdate(MemberVO vo);		//회원정보 변경(U)
	int memberDelete(MemberVO vo);		//회원정보 삭제(D)
	
	boolean isIdcheck(String id);		//중복아이디 존재: false 
	MemberVO memberLogin(MemberVO vo);	//로그인
}
