package day10;
import java.util.Scanner;
/*
	
*/

public class BoardProgram5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BoardService bs = new BoardService();
		Board[] board = new Board[100];
		
		while(true) {
			System.out.println("====== 게시판 ======");
			System.out.print("1. 등록 2. 출력 3. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				bs.addBoard(scan, board);
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
