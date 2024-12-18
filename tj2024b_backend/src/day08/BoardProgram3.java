package day08;
import java.util.Scanner;
/*
	실습 : 게시판 프로그램
	- 문법 : 변수 입출력함수, 연산자, 제어문(조건문/반복문), 클래스/객체, 배열
	- 제목, 내용, 작성자를 입력받아서 저장/출력 구현
	- 게시물 클래스 설계하기
	- 게시물 최대 100개 저장하기, 게시물1개당 객체 1개 필요, 객체1개당 3개의 멤버변수를 갖는다.
*/

public class BoardProgram3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Board[] board = new Board[100];
		while(true) {
			System.out.println("====== 게시판 ======");
			System.out.print(">> 1. 등록 2. 출력 3. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println(">> 등록을 선택했습니다.");
				Board newBoard = new Board();
				System.out.print(">> 제목 : "); newBoard.title = scan.next();
				System.out.print(">> 내용 : "); newBoard.content = scan.next();
				System.out.print(">> 작성자 : "); newBoard.writer = scan.next();
				for(int index = 0; index < board.length; index++) {
					if(board[index] == null) {
						board[index] = newBoard;
						System.out.printf(">> %d번째 게시물을 등록했습니다.\n", index+1);
						break;
					}
				}
			} else if(choose == 2) {
				System.out.println(">> 출력을 선택했습니다.");
				for(int index = 0; index < board.length; index++) {
					if(board[index] != null) {
						System.out.print(">> 제목 : " + board[index].title + " ");
						System.out.print(">> 내용 : " + board[index].content + " ");
						System.out.println(">> 작성자 : " + board[index].writer + " ");
					}
				}
			} else {
				break;
			}
		}
		scan.close();
	}

}
