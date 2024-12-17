package day07;
import java.util.Scanner;


public class BoardProgram2 {
	
	public static void main(String[] args) {
		Board board1 = null; Board board2 = null; Board board3 = null;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("1. 등록 2. 출력 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println(">> 등록을 선택했습니다.");
				System.out.print(">> 제목 : ");
				String title = scan.next();
				System.out.print(">> 내용 : ");
				String content = scan.next();
				System.out.print(">> 작성자 : ");
				String writer = scan.next();
				if(board1 == null) {
					board1 = new Board();
					board1.title = title; board1.content = content; board1.writer = writer;
				} else if(board2 == null) {
					board2 = new Board();
					board2.title = title; board2.content = content; board2.writer = writer;
				} else if(board3 == null) {
					board3 = new Board();
					board3.title = title; board3.content = content; board3.writer = writer;
				} else {
					System.out.println(">> 저장공간에 없습니다.");
				}
			} else if(choose == 2) {
				System.out.println(">> 출력을 선택했습니다.");
				if(board1 != null) {
					System.out.printf(">> 제목 : %s / 내용 : %s / 작성자 : %s\n", board1.title, board1.content, board1.writer);
				}
				if(board2 != null) {
					System.out.printf(">> 제목 : %s / 내용 : %s / 작성자 : %s\n", board2.title, board2.content, board2.writer);
				}
				if(board3 != null) {
					System.out.printf(">> 제목 : %s / 내용 : %s / 작성자 : %s\n", board3.title, board3.content, board3.writer);
				}
			} else {
				break;
			}
		}
		scan.close();
	}
}
