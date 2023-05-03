package edu.kh.project.myPage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.dao.MyPageDAO;

@Service // 비즈니스 로직 처리 클래스 + Bean 등록 (IOC)
public class MyPageServiceImpl implements MyPageService{
	
	@Autowired  // MyPageDAO 의존성 주입(DI)
	private MyPageDAO dao;
	
	@Autowired  // BCryptPasswordEncoder 의존성 주입(DI)
	private BCryptPasswordEncoder bcrypt;

	// 회원 정보 수정 서비스
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int updateInfo(Member updateMember) {
		return dao.updateInfo(updateMember);
	}

	// 비밀번호 변경 서비스
	//@Transactional // UnChecked Exception 발생 시 rollback
	@Transactional(rollbackFor = Exception.class) // 모든 Exception 발생 시 rollback 
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		
		// 1. 현재 비밀번호와 DB에 저장된 비밀번호 비교
		
		// 1) 회원번호가 일치하는 MEMBER 테이블 행의 MEMBER_PW 조회
		String encPw = dao.selectEncPw(memberNo);
			
		// 2) bcrypt.matches(평문, 암호문) -> 같으면 true -> 이 때 비번 수정
		if(bcrypt.matches(currentPw, encPw)) {
			// 2. 비밀번호 변경(UPDATE DAO 호출) -> 결과 반환
			return dao.changePw(bcrypt.encode(newPw), memberNo);
		}
			// 3) 비밀번호가 일치하지 않으면 0 반환
		return 0;
	}

	// 회원 탈퇴 서비스
	@Transactional(rollbackFor = Exception.class) 
	@Override
	public int secession(int memberNo, String memberPw) {
		
		// 1. 회원 번호가 일치하는 회원의 비밀번호 조회
		String encPw = dao.selectEncPw(memberNo);
		
		// - 비밀번호가 일치하면 
		if(bcrypt.matches(memberPw, encPw)) {
			// MEMBER_DEL_FL -> 'Y'로 바꾸고 1 반환
			return dao.secession(memberNo);
		}
		// - 비밀번호가 일치하지 않으면 -> 0 반환 
		return 0;
	}

}
