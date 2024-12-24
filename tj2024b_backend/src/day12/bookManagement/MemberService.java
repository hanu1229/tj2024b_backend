package day12.bookManagement;
import java.util.Scanner;

public class MemberService {
	
	// 회원가입 함수
	public void addMember(Scanner scan, MemberDto[] members) {
		boolean addState = false;
		
		System.out.println(">> 회원가입을 선택했습니다.");
		System.out.print(">> 아이디 : "); String id = scan.next();
		System.out.print(">> 비밀번호 : "); String pw = scan.next();
		System.out.print(">> 이름 : "); String name = scan.next();
		
		MemberDto member = new MemberDto(name, id, pw);
		for(int index = 0; index < members.length; index++) {
			if(members[index] == null) {
				members[index] = member;
				addState = true;
				break;
			}
		}
		if(addState) {
			System.out.println(">> 회원가입 성공");
		}else {
			System.out.println(">> 회원가입 실패");
		}
	}
	
	// 로그인 함수
	public MemberDto login(Scanner scan, MemberDto[] members) {
		boolean loginState = false;
		MemberDto member = null;
		System.out.println(">> 로그인을 선택하셨습니다.");
		System.out.print(">> 아이디 : "); String id = scan.next();
		System.out.print(">> 비밀번호 : "); String pw = scan.next();
		for(int index = 0; index < members.length; index++) {
			if(members[index] != null) {
				if(members[index].getId().equals(id) && members[index].getPw().equals(pw)) {
					member = members[index];
					loginState = true;
					break;
				}
			}
		}
		if(loginState) {
			System.out.println(">> 로그인 성공");
		} else {
			System.out.println(">> 로그인 실패");
		}
		return member;
	}
	
}
