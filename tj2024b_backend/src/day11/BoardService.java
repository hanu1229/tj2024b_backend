package day11;
import java.util.Scanner;

public class BoardService {

	public void addBoard(Scanner scan, BoardDto[] board) {
		boolean addState = false;
		int count = 0;
		System.out.println(">> 등록을 선택했습니다.");
		System.out.print(">> 제목 : ");
		String title = scan.next();
		System.out.print(">> 내용 : ");
		String content = scan.next();
		System.out.print(">> 작성자 : ");
		String writer = scan.next();
		BoardDto newBoard = new BoardDto(title, content, writer);
		for(int index = 0; index < board.length; index++) {
			if(board[index] == null) {
				board[index] = newBoard;
				addState = true;
				count = index + 1;
				break;
			}
		}
		if(addState) {
			System.out.printf(">> %d번째 게시물이 등록되었습니다.\n", count);
		} else {
			System.out.println(">> 등록에 실패했습니다.");
		}
	}

	public void addBoard(Scanner scan, BoardDto[] board, MemberDto writer) {
		boolean addState = false;
		int count = 0;
		System.out.println(">> 게시물 등록을 선택했습니다.");
		System.out.print(">> 제목 : ");
		String title = scan.next();
		System.out.print(">> 내용 : ");
		String content = scan.next();
		BoardDto newBoard = new BoardDto(title, content, writer.getName());
		for(int index = 0; index < board.length; index++) {
			if(board[index] == null) {
				board[index] = newBoard;
				addState = true;
				count = index + 1;
				break;
			}
		}
		if(addState) {
			System.out.printf(">> %d번째 게시물이 등록되었습니다.\n", count);
		} else {
			System.out.println(">> 등록에 실패했습니다.");
		}
	}
	
	public void printBoard(BoardDto[] board) {
		boolean printState = false;
		System.out.println(">> 게시물 출력을 선택했습니다.");
		for(int index = 0; index < board.length; index++) {
			if(board[index] != null) {
				System.out.printf("====== %d 게시물 출력 ======\n", index + 1);
				System.out.printf(">> 제목 : %s\n", board[index].getTitle());
				System.out.printf(">> 내용 : %s\n", board[index].getContent());
				System.out.printf(">> 작성자 : %s\n", board[index].getWriter());
				System.out.printf("====== %d 게시물 출력 ======\n", index + 1);
				printState = true;
			}
		}
		if(!printState) {
			System.out.println("\n>> 등록된 게시물이 없습니다.");
		}
	}
}
