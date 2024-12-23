package day11;
import java.util.Scanner;

public class MemberService {
	int code = 0;
	public void addMember(Scanner scan, MemberDto[] member) {
		
		boolean addState = false;
		System.out.println(">> 회원가입을 선택하셨습니다.");
		System.out.print(">> 아이디 : "); String id = scan.next();
		System.out.print(">> 비밀번호 : "); String pw = scan.next();
		System.out.print(">> 닉네임 : "); String name = scan.next();
		MemberDto newMember = new MemberDto(code++, id, pw, name);
		
		for(int index = 0; index < member.length; index++) {
			if(member[index] == null) {
				member[index] = newMember;
				addState = true;
				break;
			}
		}
		if(addState) {
			System.out.println(">> 회원가입을 완료했습니다.");
		} else {
			System.out.println(">> 회원가입을 실패했습니다.");
		}
	}
	
	public MemberDto loginMember(Scanner scan, MemberDto[] member) {
		
		boolean loginState = false;
		MemberDto writer = new MemberDto();
		System.out.println(">> 로그인을 선택하셨습니다.");
		System.out.print(">> 아이디 : "); String id = scan.next();
		System.out.print(">> 비밀번호 : "); String pw = scan.next();
		
		for(int index = 0; index < member.length; index++) {
			if(member[index] != null && 
					member[index].getId().equals(id) && 
					member[index].getPw().equals(pw)) {
				writer = member[index];
				loginState = true;
			}
		}
		if(loginState) {
			System.out.println(">> 로그인을 성공했습니다.");
			return writer;
		} else {
			System.out.println(">> 로그인을 실패했습니다.");
			return null;
		}
	}
}
