package day09;
import java.util.Scanner;

public class MemberService {
	
	void addMember(Scanner scan, Member[] memberList) {
		Member member = new Member();
		boolean saveState = false;
		System.out.println(">> 회원가입을 선택했습니다.");
		System.out.print(">> 아이디 : ");
		member.id = scan.next();
		System.out.print(">> 비밀번호 : ");
		member.pw = scan.next();
		System.out.print(">> 닉네임 : ");
		member.name = scan.next();
		for(int index = 0; index < memberList.length; index++) {
			if(memberList[index] == null) {
				memberList[index] = member;
				saveState = true;
				break;
			}
		}
		if(saveState) {
			System.out.println(">> 회원가입을 완료했습니다.");
		} else {
			System.out.println(">> 회원가입이 불가능합니다.");
		}
	}
	
	void printMember(Scanner scan, Member[] memberList) {
		boolean printState = false;
		String name = "";
		System.out.println(">> 로그인을 선택하셨습니다.");
		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String pw = scan.next();
		for(int index = 0; index < memberList.length; index++) {
			if(memberList[index] != null && memberList[index].id.equals(id) && memberList[index].pw.equals(pw)) {
				printState = true;
				name = memberList[index].name;
				break;
			}
		}
		if(printState) {
			System.out.println(name + "님 " + "로그인 성공!");
		} else {
			System.out.println(id + "님 " + "로그인 실패!");
		}
	}
}
