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
	
	/** 로그인 하기전 메인메뉴 페이지 */
	public void run() {
		
		System.out.println("====== 메인 페이지 ======");
		while(true) {
			System.out.print(">> 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 5.종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) { signup(); }
			else if(choose == 2) { login(); }
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
		int result = MemberController.getInstance().signup(memberDto);
		if(result == 1) { System.out.println(">> 아이디 길이를 5~30 사이로 해주세요."); }
		else if(result == 2) { System.out.println(">> 비밀번호 길이를 5~30 사이로 해주세요."); }
		else if(result == 3) { System.out.println(">> 이름 길이를 2~30 사이로 해주세요."); }
		else if(result == 4) { System.out.println(">> 연락처를 000-0000-0000 형식으로 작성해주세요."); }
		else if(result == 5) { System.out.println(">> 회원가입 성공"); }
		else if(result == 6) { System.out.println(">> 회원가입 실패 관리자에게 문의하세요"); }
		else if(result == 7) { System.out.println(">> 현재 사용중인 아이디입니다."); }
		else if(result == 8) { System.out.println(">> 현재 사용중인 전화번호입니다."); }

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
			// BoardView 메인메뉴 페이지 메소드 호출
			BoardView.getInstance().index();
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
		System.out.println("====== 메인 페이지 ======");
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
	public int myInfo() {
		MemberDto result = MemberController.getInstance().myInfo();
		System.out.println("====== 내정보 ======");
		System.out.println(">> 아이디		: " + result.getMid());
		System.out.println(">> 이름		: " + result.getMname());
		System.out.println(">> 전화번호	: " + result.getMphone());
		System.out.println(">> 생성일		: " + result.getMdate());
		while(true) {
			System.out.print(">> 1. 회원수정 2. 회원탈퇴 3. 뒤로가기 : ");
			int choose = scan.nextInt();
			if(choose == 1) { update(); break; }
			else if(choose == 2) {
				// delete(); break;
				int state = delete();
				if(state == 0) { return state;}
			}
			else if(choose == 3) { break; }
		}
		return 1;
	}
	
	/** 회원탈퇴 페이지 */
	public int delete() {
		System.out.println(">> 정말 회원탈퇴를 하실건가요?");
		System.out.print(">> 0.예 1.아니오 : ");
		int choose = scan.nextInt();
		if(choose == 0) {
			MemberController.getInstance().delete();
			// logout();
			return 0;
		}
		return 1;
	}
	
	/** 회원수정 페이지 */
	public void update() {
		System.out.println("====== 회원정보 수정 ======");
		System.out.print(">> 새로운 비밀번호 : "); String mpwd = scan.next();
		System.out.print(">> 새로운 이름 : "); String mname = scan.next();
		System.out.print(">> 새로운 전화번호 : "); String mphone = scan.next();
		MemberDto memberDto = new MemberDto();
		memberDto.setMpwd(mpwd); memberDto.setMname(mname); memberDto.setMphone(mphone);
		boolean result = MemberController.getInstance().update(memberDto);
		if(result) {
			System.out.println(">> 회원정보 수정 완료");
		} else {
			System.out.println(">> 회원정보 수정 실패");
		}
	}	
	
}

