package edu.kh.project.myPage.model.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.common.utility.Util;
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

	// 프로필 이미지 수정 서비스
	@Override
	public int updateProfile(MultipartFile profileImage, String webPath, String filePath, Member loginMember) throws IllegalStateException, IOException {
		
		// 프로필 이미지 변경 실패 대비
		String temp = loginMember.getProfileImage();
		
		String rename = null;  // 변경 이름 저장 변수
		if(profileImage.getSize() > 0) {  // 업로드된 이미지가 있을 경우
			
			// 1) 파일 이름 변경
			rename = Util.fileRename(profileImage.getOriginalFilename());
			
			// 2) 바뀐 이름 loginMember에 세팅
			loginMember.setProfileImage(webPath + rename);
			
			
		} else {  // 없는 경우(x버튼)
			loginMember.setProfileImage(null);
			// 세션 이미지를 null로 변경해서 삭제
		}
		
		// 프로필 이미지 수정 DAO 메서드 호출
		int result = dao.updateProfile(loginMember);
		
		if(result>0) {  // 성공
			// 새 이미지가 업로드된 경우
			if(rename != null) {
				profileImage.transferTo(new File(filePath + rename));
			}
			
		} else {  // 실패
			// 이전 이미지로 프로필 다시 세팅
			loginMember.setProfileImage(temp);
		}
		
		return result;
	}

}
