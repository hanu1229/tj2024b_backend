package day12.boardProgram7;
import java.util.Scanner;

public class BoardService {
	
	// 게시물 작성 함수
	public void boardAdd(Scanner scan, BoardDto[] boards, String loginId) {
		boolean addState = false;
		System.out.println(">> 등록을 선택했습니다.");
		System.out.print(">> 제목 : "); String title = scan.next();
		System.out.print(">> 내용 : "); String content = scan.next();
		System.out.print(">> 작성자 : ");
		BoardDto boardDto = new BoardDto(title, content, loginId);
		for(int index = 0; index < boards.length; index++) {
			if(boards[index] == null) {
				boards[index] = boardDto;
				addState = true;
				break;
			}
		}
		if(addState) {
			System.out.println(">> 게시물 작성 완료");
		} else {
			System.out.println(">> 게시물 작성 실패");
		}
	}
	
	// 게시물 출력 함수
	public void boardPrint(BoardDto[] boards) {
		System.out.println(">> 출력을 선택했습니다.");
		for(int index = 0; index < boards.length; index++) {
			if(boards[index] != null) {
				System.out.printf("====== %d번째 게시물 ======\n", index + 1);
				System.out.printf(">> 제목 : %s\n", boards[index].getTitle());
				System.out.printf(">> 내용 : %s\n", boards[index].getContent());
				System.out.printf(">> 작성자 : %s\n", boards[index].getWriter());
				System.out.printf("====== %d번째 게시물 ======\n", index + 1);
			}
		}
	}
	
}
