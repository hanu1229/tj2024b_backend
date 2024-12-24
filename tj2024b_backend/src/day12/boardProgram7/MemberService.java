package day12.boardProgram7;
import java.util.Scanner;

public class MemberService {
	
	// 회원가입 함수
	public void signUp(Scanner scan, MemberDto[] members) {
		boolean signUpState = false;
		System.out.print(">> 아이디 : "); String id = scan.next();
		System.out.print(">> 비밀번호 : "); String pw = scan.next();
		System.out.print(">> 닉네임 : "); String name = scan.next();
		MemberDto memberDto = new MemberDto(id, pw, name);
		for(int index = 0; index < members.length; index++) {
			if(members[index] == null) {
				members[index] = memberDto;
				signUpState = true;
				break;
			}
		}
		if(signUpState) {
			System.out.println(">> 회원가입 성공");
		} else {
			System.out.println(">> 회원가입 실패");
		}
	}
	
	// 로그인 함수
	public String login(Scanner scan, MemberDto[] members) {
		boolean loginState = false;
		MemberDto memberDto = null;
		System.out.println(">> 로그인을 선택했습니다.");
		System.out.print(">> 아이디 : "); String id = scan.next();
		System.out.print(">> 비밀번호 : "); String pw = scan.next();
		for(int index = 0; index < members.length; index++) {
			memberDto = members[index];
			if(memberDto != null) {
				if(memberDto.getId().equals(id) && memberDto.getPw().equals(pw)) {
					loginState = true;
					break;
				}
			}
		}
		if(loginState) {
			System.out.println(">> 로그인 성공");
			return memberDto.getId();
		} else {
			System.out.println(">> 로그인 실패");
			return null;
		}
	}
}
