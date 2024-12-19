package day09;
import java.util.Scanner;
/*
실습 : 게시판 프로그램
- 문법 : 변수 입출력함수, 연산자, 제어문(조건문/반복문), 클래스(멤버변수 ,메소드)/객체, 배열
- 제목, 내용, 작성자를 입력받아서 저장/출력 구현
- 게시물 클래스 설계하기
- 게시물 최대 100개 저장하기, 게시물1개당 객체 1개 필요, 객체1개당 3개의 멤버변수를 갖는다.
*/

public class BoardProgram4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BoardService bs = new BoardService();
		Board[] boardList = new Board[100];
		while(true) {
			System.out.println("====== 게시판 ======");
			System.out.print(">> 1. 등록 2. 출력 3. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				bs.boardAdd(scan, boardList);
			} else if(choose == 2) {
				bs.boardPrint(boardList);
			} else {
				System.out.println(">> 종료합니다.");
				break;
			}
		}
		scan.close();
	}

}
