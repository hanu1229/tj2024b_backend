package day13.boardProgram8.view;
import day13.boardProgram8.controller.BoardController;
import day13.boardProgram8.model.dto.BoardDto;
import java.util.Scanner;

// 게시물의 입출력을 담당하는 클래스 (싱글톤 패턴)
public class BoardView {
	// singleton start
	private static BoardView instance = new BoardView();
	private BoardView () { }
	
	public static BoardView getInstance() {
		if(instance == null) {
			instance = new BoardView();
		}
		return instance;
	}
	// singleton end
	
	private Scanner scan = new Scanner(System.in);
	
	// 메인페이지 입출력 메소드
	public void index() {
		while(true) {			
			System.out.print(">> 1. 글등록 2. 글출력 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				write();
			} else if(choose == 2) {
				findAll();
			}
		}
	}
	
	// 글쓰기 입출력 메소드
	public void write() {
		System.out.println("====== [글쓰기 페이지] ======");
		// [1] 입력
		System.out.print(">> 제목 : "); String title = scan.next();
		System.out.print(">> 내용 : "); String content = scan.next();
		System.out.print(">> 작성자 : "); String writer = scan.next();
		// [2] 객체화
		BoardDto boardDto = new BoardDto(title, content, writer);
		// [3] 컨트롤러에게 저장할 객체를 전달하고 결과로 응답받기.
		boolean result = BoardController.getInstance().write(boardDto);
		// [4]
		if(result == true) {
			System.out.println(">> 글쓰기 성공");
		} else {
			System.out.println(">> 글쓰기 실패");
		}
	}
	// 모든글출력 입출력 메소드
	public void findAll() {
		System.out.println("====== [글출력 페이지] ======");
		// [1] 컨트롤러에게 모든 게시물정보를 요청하고 결과받기
		BoardDto[] result = BoardController.getInstance().findAll();
		// [2] 요청 결과 출력
		for(int index = 0; index < result.length; index++) {
			BoardDto board = result[index];
			if(board != null) {
				System.out.printf(">> %d / 제목 : %s / 내용 : %s, 작성자 : %s\n", 
						index, 
						board.getTitle(), 
						board.getContent(), 
						board.getWriter()
						);
			}
		}
	}
	
}
