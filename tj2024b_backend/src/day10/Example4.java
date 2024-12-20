package day10;
import java.util.Scanner;
/*
	자바 과제10 : 회원 서비스 구현하기
	- 문법 : 변수, 입출력함수, 연산자, 제어문, 클래스, 배열
	- 회원은 최대 100명까지 저장할수 있다.
	- 회원클래스와 회원서비스 클래스를 정의하시오
	- 회원정보는 아이디, 비밀번호, 닉네임을 갖습니다.
		+ 모든 멤버변수는 private 키워드를 적용한다.
		+ 멤버변수는 private이므로 외부 클래스에서 호출시 getter/setter함수를 활용한다.
		+ 회원가입과 로그인시 사용되는 회원객체는 생성자를 활용한다.
	- 회원가입함수와 로그인함수를 구현하시오.
		회원가입함수 : 아이디, 비밀번호, 닉네임 3개의 각 정보를 입력받아 객체 생성후 배열에 저장하기
		로그인함수 : 아이디, 비밀번호를 입력받아 기존의 저장된 정보와 일치한 정보가 있으면 '로그인 성공'
					아니면 '로그인실패'를 출력한다
	- 프로그램 초기 메뉴 : 1. 회원가입 2. 로그인
*/

public class Example4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberService ms = new MemberService();
		Member[] member = new Member[100];
		while(true) {
			System.out.println("====== 회원 정보 ======");
			System.out.print(">> 1. 회원가입 2. 로그인 3. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				ms.addMember(scan, member);
			} else if(choose == 2) {
				ms.loginMember(scan, member);
			} else {
				System.out.println(">> 프로그램을 종료합니다.");
				break;
			}
		}

	}

}
