package boardservice10.controller;

import boardservice10.model.dao.MemberDao;
import boardservice10.model.dto.MemberDto;

public class MemberController {
	// 0이면 비로그인 상태, 0초과이면 로그인상태 즉 로그인된 회원번호를 삽입
	private int loginMno = 0;
	// singleton start
	private static MemberController instance = new MemberController();
	private MemberController() {}
	public static MemberController getInstance() { return instance; }
	// singleton end
	
	// getter
	public int getLoginMno() { return this.loginMno; }
	
	/** 회원가입 컨트롤러 메소드 */
	public int signup(MemberDto memberDto) {
		// 다양한 유효성 검사를 넣을 예정
		
		// 1. 아이디 길이 검사 : 사용자로부터 입력받은 아이디의 길이가 5미만 이거나 30을 초과하면 실패
		if(memberDto.getMid().length() < 5 || memberDto.getMid().length() > 30) {
			return 1;
		}
		
		// 2. 아이디 중복 검사
		if(MemberDao.getInstance().check("mid", memberDto.getMid())) {
			return 7;
		}
		
		// 3. 비밀번호 길이 검사
		if(memberDto.getMpwd().length() < 5 || memberDto.getMpwd().length() > 30) {
			return 2;
		}
		
		// 4. 이름 길이 검사
		if(memberDto.getMname().length() < 2 || memberDto.getMname().length() > 30) {
			return 3;
		}
		
		// 5. 연락처 - 검사, 길이 검사
		String[] phones = memberDto.getMphone().split("-");
		if(phones.length != 3 || memberDto.getMphone().length() != 13) {
			return 4;
		}
		
		// 6. 연락처 중복 검사
		if(MemberDao.getInstance().check("mphone", memberDto.getMphone())) {
			return 8;
		}
		
		boolean result = MemberDao.getInstance().signup(memberDto);
		if(result) { return 5; }
		else { return 6; }
	}
	
	/** 로그인 컨트롤러 메소드 */
	public boolean login(MemberDto memberDto) {
		int result = MemberDao.getInstance().login(memberDto);
		// boolean에서 int로 변경한 이유 : 로그인을 성공한 회원본호를 내부적으로 저장하기 위해서이다.
		// 회원번호(1번부터 시작)를 반환받아서 0이면 없는 회원번호, 0초과이면 있는 회원번호
		if(result > 0) {
			// 로그인 성공시 로그인 저장변수에 로그인을 성공한 회원번호를 저장
			loginMno = result;
			return true;
		} else {			
			return false;
		}
	}
	
	/** 로그아웃 컨트롤러 메소드 */
	public void logout() {
		if(loginMno == 0) {}
		loginMno = 0;
	}
	
	/** 아이디찾기 컨트롤러 메소드 */
	public String findId(MemberDto memberDto) {
		// 다양한 유효성 검사를 넣을 예정
		String result = MemberDao.getInstance().findId(memberDto);
		return result;
	}
	
	/** 비밀번호찾기 컨트롤러 메소드 */
	public String findPwd(MemberDto memberDto) {
		// 다양한 유효성 검사를 넣을 예정
		String result = MemberDao.getInstance().findPwd(memberDto);
		return result;
	}
	
	/** 내정보보기 컨트롤러 메소드 */
	public MemberDto myInfo() {
		// Dao에게 로그인(로그인된 회원번호PK)정보를 주고 결과 받아 view에 전달
		return MemberDao.getInstance().myInfo(loginMno);
	}
	
	/** 회원탈퇴 컨트롤러 메소드 */
	public void delete() {
		MemberDao.getInstance().delete(loginMno);
	}
	
	/** 회원수정 컨트롤러 메소드 */
	public boolean update(MemberDto memberDto) {
		memberDto.setMno(loginMno);
		boolean result = MemberDao.getInstance().update(memberDto);
		return result;
	}
	
	
}
