package day11;
import java.util.Scanner;

public class BoardProgram6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BoardService bs = new BoardService();
		BoardDto[] board = new BoardDto[100];
		while(true) {
			System.out.print(">> 1. 등록 2. 출력");
			int choose = scan.nextInt();
			if(choose == 1) {
				bs.addBoard(scan,  board);
			} else if(choose == 2) {
				bs.printBoard(board);
			} else {
				System.out.println(">> 시스템을 종료합니다.");
				break;
			}
		}
		scan.close();
	}

}
