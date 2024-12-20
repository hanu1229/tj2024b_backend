package day10;
import java.util.Scanner;

public class MemberService {

	
	public void addMember(Scanner scan, Member[] member) {
		boolean addState = false;
		System.out.println(">> 회원가입을 선택했습니다.");
		System.out.print(">> 아이디 : ");
		String id = scan.next();
		System.out.print(">> 비밀번호 : ");
		String pw = scan.next();
		System.out.print(">> 닉네임 : ");
		String name = scan.next();
		Member newMember = new Member(name, id, pw);
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
			System.out.println(">> 회원가입이 불가능합니다.");
		}
	}
	
	public void loginMember(Scanner scan, Member[] member) {
		boolean loginState = false;
		String name = "";
		System.out.println(">> 로그인을 선택하셨습니다.");
		System.out.print(">> 아이디 : ");
		String id = scan.next();
		System.out.print(">> 비밀번호 : ");
		String pw = scan.next();
		for(int index = 0; index < member.length; index++) {
			if(member[index] != null
					&& member[index].getID().equals(id) 
					&& member[index].getPW().equals(pw)) {
				loginState = true;
				name = member[index].getName();
				break;
			}
		}
		if(loginState) {
			System.out.printf(">> %s님 로그인 성공!\n", name);
		} else {
			System.out.println(">> 로그인 실패!");
		}
	}
}
