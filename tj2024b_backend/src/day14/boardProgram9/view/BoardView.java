package day14.boardProgram9.view;
import day14.boardProgram9.model.dto.BoardDto;
import day14.boardProgram9.controller.BoardController;
import java.util.Scanner;
import java.util.ArrayList;

public class BoardView {
	// singleton start
	private static BoardView instance = new BoardView();
	private BoardView() { }
	public static BoardView getInstance() { return instance; }
	// singleton end
	
	Scanner scan = new Scanner(System.in);
	
	// 메인화면 출력 함수
	public void run() {
		System.out.println("====== 게시판 페이지 ======");
		while(true) {
			System.out.print(">> 1. 등록 2. 출력 3. 수정 4. 삭제 5. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) { create(); }
			else if(choose == 2) { readAll(); }
			else if(choose == 3) { update(); }
			else if(choose == 4) { delete(); }
			else if(choose == 5) { System.out.println(">> 프로그램 종료"); break; }
		}
	}
	
	// 게시물 작성 함수
	public void create() {
		System.out.println("====== 게시물 작성 ======");
		System.out.print(">> 제목 : "); String title = scan.next();
		System.out.print(">> 내용 : "); String content = scan.next();
		System.out.print(">> 작성자 : "); String writer = scan.next();
		BoardDto boardDto = new BoardDto(title, content, writer);
		boolean result = BoardController.getInstance().create(boardDto);
		if(result) { System.out.println(">> 등록 성공"); }
		else { System.out.println(">> 등록 실패"); }
	}
	
	// 게시물 출력 함수
	public void readAll() {
		System.out.println("====== 게시물 출력 ======");
		ArrayList<BoardDto> result = BoardController.getInstance().readAll();
		for(int index = 0; index < result.size(); index++) {
			BoardDto board = result.get(index);
			System.out.printf("====== %d번째 게시물 ======\n", index + 1);
			System.out.printf(">> 제목 : %s\n", board.getTitle());
			System.out.printf(">> 내용 : %s\n", board.getContent());
			System.out.printf(">> 작성자 : %s\n", board.getWriter());
			System.out.printf("====== %d번째 게시물 ======\n", index + 1);
		}
	}
	
	// 게시물 수정 함수
	public void update() {
		System.out.println("====== 게시물 수정 ======");
		System.out.print(">> 수정할 게시물 번호 : "); int boardIndex = scan.nextInt() - 1;
		System.out.print(">> 수정할 제목 : "); String title = scan.next();
		System.out.print(">> 수정할 내용 : "); String content = scan.next();
		System.out.print(">> 수정할 작성자 : "); String writer = scan.next();
		BoardDto boardDto = new BoardDto(title, content, writer);
		boolean result = BoardController.getInstance().update(boardDto, boardIndex);
		if(result) { System.out.println(">> 수정 성공"); }
		else { System.out.println(">> 수정 실패"); }
	}
	
	// 게시물 삭제 함수
	public void delete() {
		System.out.println("====== 게시물 삭제 ======");
		System.out.print(">> 삭제할 게시물 번호 : "); int boardIndex = scan.nextInt();
		boolean result = BoardController.getInstance().delete(boardIndex-1);
		if(result) { System.out.println(">> 삭제 성공"); }
		else { System.out.println(">> 삭제 실패"); }
	}
	
}
