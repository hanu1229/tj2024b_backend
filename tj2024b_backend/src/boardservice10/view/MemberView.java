package boardservice10.view;

import java.util.Scanner;
import boardservice10.controller.MemberController;
import boardservice10.model.dto.MemberDto;

public class MemberView {
	// singleton start
	private static MemberView instance = new MemberView();
	private MemberView() {}
	public static MemberView getInstance() { return instance; }
	// singleton end
	
	private Scanner scan = new Scanner(System.in);
	
	/** 메인메뉴 페이지 */
	public void run() {
		
		System.out.println("====== 메인 페이지 ======");
		while(true) {
			System.out.print(">> 1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호찾기 5. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) { signup(); }
			else if(choose == 2) {
				if(MemberController.getInstance().getLoginMno() == 0) {					
					login();
				} else {
					logout();
				}
			}
			else if(choose == 3) { findId(); }
			else if(choose == 4) { findPwd(); }
			else if(choose == 5) { System.out.println(">> 종료"); break; }
		}
		
	}
	
	/** 회원가입 페이지 */
	// choose == 1
	public void signup() {
		System.out.println("====== 회원가입 ======");
		System.out.print(">> 아이디 : "); String mid = scan.next();
		System.out.print(">> 비밀번호 : "); String mpwd = scan.next();
		System.out.print(">> 이름 : "); String mname = scan.next();
		System.out.print(">> 전화번호 : "); String mphone = scan.next();
		MemberDto memberDto = new MemberDto(mid, mpwd, mname, mphone);
		boolean result = MemberController.getInstance().signup(memberDto);
		if(result) {
			System.out.println(">> 회원가입 성공");
		} else {
			System.out.println(">> 회원가입 실패");
		}
	}
	/** 로그인 페이지 */
	// choose == 2
	public void login() {
		System.out.println("====== 로그인 ======");
		System.out.print(">> 아이디 : "); String mid = scan.next();
		System.out.print(">> 비밀번호 : "); String mpwd = scan.next();
		MemberDto memberDto = new MemberDto();
		memberDto.setMid(mid); memberDto.setMpwd(mpwd);
		boolean result = MemberController.getInstance().login(memberDto);
		if(result) {
			System.out.println(">> 로그인 성공");
		} else {
			System.out.println(">> 로그인 실패");
			System.out.println(">> 동일한 회원정보가 없습니다.");
		}
	}
	
	/** 로그아웃 메소드 */
	public void logout() {
		int result = MemberController.getInstance().getLoginMno();
		MemberController.getInstance().logout();
		System.out.println(">> " + result + " 회원번호님 로그아웃 되었습니다.");
	}
	
	/** 아이디찾기 페이지 */
	// choose == 3
	public void findId() {
		System.out.println("====== 아이디 찾기 ======");
		// [1] 입력
		System.out.print(">> 이름 : "); String mname = scan.next();
		System.out.print(">> 전화번호 : "); String mphone = scan.next();
		// [2] 객체화 - 데이터포장(view에서 controller로 이동)
		MemberDto memberDto = new MemberDto();
		memberDto.setMname(mname); memberDto.setMphone(mphone);
		// [3] 컨트롤러에게 전달(request/요청/매개변수)하고 응답(response/응답/리턴)결과 받기
		String result = MemberController.getInstance().findId(memberDto);
		// [4] 컨트롤러의 결과에 따른 처리
		if(result != null) {			
			System.out.printf(">> 찾은 아이디 : %s\n", result);
		} else {
			System.out.println(">> 동일한 회원 정보가 없습니다.");
		}
	}
	
	/** 비밀번호찾기 페이지 */
	// choose == 4
	public void findPwd() {
		System.out.println("====== 비밀번호 찾기 ======");
		System.out.printf(">> 아이디 : "); String mid = scan.next();
		System.out.printf(">> 전화번호 : "); String mphone = scan.next();
		MemberDto memberDto = new MemberDto();
		memberDto.setMid(mid); memberDto.setMphone(mphone);
		String result = MemberController.getInstance().findPwd(memberDto);
		if(result != null) {
			System.out.printf(">> 찾은 비밀번호 : %s\n", result);
		} else {
			System.out.println(">> 동일한 회원 정보가 없습니다.");
		}
	}
	
	/** 내정보 보기 페이지 */
	public void myInfo() {
		MemberDto result = MemberController.getInstance().myInfo();
		System.out.println("====== 내정보 ======");
		System.out.println(">> mid : " + result.getMid());
		System.out.println(">> mname : " + result.getMname());
		System.out.println(">> mphone : " + result.getMphone());
		System.out.println(">> mdate : " + result.getMdate());
		while(true) {
			System.out.print(">> 1. 회원수정 2. 회원탈퇴 3. 뒤로가기 : ");
			int choose = scan.nextInt();
			if(choose == 1) {}
			else if(choose == 2) { delete(); }
			else if(choose == 3) { break; }
		}
	}
	
	/** 회원탈퇴 페이지 */
	public void delete() {
		System.out.println(">> 정말 회원탈퇴를 하실건가요?");
		System.out.print(">> 0. 예 1. 아니오 : ");
		int choose = scan.nextInt();
		if(choose == 0) {
			MemberController.getInstance().delete();
			logout();
		}
	}
	
}
