package day07;
import java.util.Scanner;
/*
	주제 : 회원 서비스 구현하기
		- 문법 : 변수, 입출력함수, 연산자, 제어문(조건문/반복문), 클래스(멤버변수)/객체
		- 회원은 최대 3명까지 저장할 수 있다.
		- 회원정보는 아이디, 비밀번호, 닉네임을 갖습니다.
		- 프로그램 초기 메뉴 : 1. 회원가입 2. 로그인 :
			1 선택시 : 아이디, 비밀번호,닉네임 3개의 각 정보를 입력받아 저장하기
			2 선택시 : 아이디, 비밀번호를 입력받아 기존의 저장된 정보와 일치한 정보가 있으면 '로그인 성공' 아니면 '로그인 실패'를 출력한다.
		- 코드 구현
		- 구현된 코드에서 문법 찾기
*/
public class Example3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Customer people1 = null, people2 = null, people3 = null;
		while(true) {
			System.out.println("====== 회원 서비스 ======");
			System.out.print(">> 1. 회원가입 2. 로그인 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println(">> 회원가입을 선택했습니다.");
				Customer people = new Customer();
				System.out.print("아이디 : "); people.id = scan.next();
				System.out.print("비밀번호 : "); people.password = scan.next();
				System.out.print("닉네임 : "); people.name = scan.next();
				if(people1 == null) { people1 = people; }
				else if(people2 == null) { people2 = people; }
				else if(people3 == null) { people3 = people; }
				else { System.out.println("더이상 회원가입을 할 수 없습니다.\n"); }
			} else if(choose == 2) {
				System.out.println(">> 로그인을 선택했습니다.");
				Customer people = new Customer();
				System.out.print("아이디: "); people.id = scan.next();
				System.out.print("비밀번호 : "); people.password = scan.next();
				if(people1 != null && people1.id.equals(people.id)) {
					if(people1.password.equals(people.password)) {
						System.out.println(">> " + people1.name + "님, 로그인 성공!");
					} else {
						System.out.println(">> " + people1.id + "님, 로그인 실패!");
					}
				}
				if(people2 != null && people2.id.equals(people.id)) {
					if(people2.password.equals(people.password)) {
						System.out.println(">> " + people2.name + "님, 로그인 성공!");
					} else {
						System.out.println(">> " + people2.id + "님, 로그인 실패!");
					}					
				}
				if(people3 != null && people3.id.equals(people.id)) {
					if(people3.password.equals(people.password)) {
						System.out.println(">> " + people3.name + "님, 로그인 성공!");
					} else {
						System.out.println(">> " + people3.id + "님, 로그인 실패!");
					}
				}
			} else {
				break;
			}
		}
		scan.close();
	}
}
