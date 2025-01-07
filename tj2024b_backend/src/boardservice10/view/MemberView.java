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
			System.out.print("1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호찾기 5. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) { signup(); }
			else if(choose == 2) {}
			else if(choose == 3) {}
			else if(choose == 4) {}
			else if(choose == 5) { System.out.println(">> 종료"); break; }
		}
		
	}
	
	/** 회원가입 페이지 */
	public void signup() {
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
}
