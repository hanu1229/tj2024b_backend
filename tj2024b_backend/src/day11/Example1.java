package day11;
import java.util.Scanner;

/*
	자바 과제 11 : 회원제 게시판
		- 초기메뉴는 로그인과 회원가입만 제공한다.
		- 로그인 성공하면 게시물 등록과 게시물 출력을 제공한다.
			- 단 게시물 등록시 작성자를 현재 로그인된 회원아이디로 자동 등록됩니다.
*/

public class Example1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberDto writer = null;
		// 게시판 관련
		BoardService bs = new BoardService();
		BoardDto[] board = new BoardDto[100];
		// 로그인 관련
		MemberService ms = new MemberService();
		MemberDto[] member = new MemberDto[100];
		
		while(true) {
			 if(writer == null) {		
				 System.out.println("====== 로그인 페이지 ======");
				 System.out.print(">> 1. 로그인 2. 회원가입 3. 종료 : ");
				 int choose = scan.nextInt();
				 if(choose == 1) {
					 writer = ms.loginMember(scan, member);
				 } else if(choose == 2) {
					 ms.addMember(scan, member);
				 } else {
					 System.out.println(">> 프로그램을 종료합니다.");
					 break;
				 }
			 } else if (writer != null) {
				 System.out.printf("====== %s님 게시판 페이지 ======\n", writer.getName());
				 System.out.print(">> 1. 게시물 등록 2. 게시물 출력 3. 로그아웃 : ");
				 int choose = scan.nextInt();
				 if(choose == 1) {
					 bs.addBoard(scan, board, writer);
				 } else if(choose == 2) {
					 bs.printBoard(board);
				 } else {
					 System.out.printf(">> %s님이 로그아웃했습니다.\n", writer.getName());
					 writer = null;
				 }
			 }
		}
		scan.close();
	}

}
