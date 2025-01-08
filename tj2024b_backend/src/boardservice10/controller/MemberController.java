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
	public boolean signup(MemberDto memberDto) {
		// 다양한 유효성 검사를 넣을 예정
		boolean result = MemberDao.getInstance().signup(memberDto);
		return result;
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
}
