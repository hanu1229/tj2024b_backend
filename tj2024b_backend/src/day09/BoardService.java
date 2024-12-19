package day09;
import java.util.Scanner;
public class BoardService {
	
	void boardAdd(Scanner scan, Board[] boardList) {
		System.out.println(">> 게시물을 등록합니다.");
		System.out.print(">> 제목 : ");
		String title = scan.next();
		System.out.print(">> 내용 : ");
		String content = scan.next();
		System.out.print(">> 작성자 : ");
		String writer = scan.next();
		Board board = new Board();
		board.title = title;
		board.content = content;
		board.writer = writer;
		boolean saveState = false;
		for(int index = 0; index < boardList.length; index++) {
			if(boardList[index] == null) {
				boardList[index] = board;
				System.out.printf(">> %d번째 게시물이 등록되었습니다.\n", index+1);
				saveState = true;
				break;
			}
		}
		if(!saveState) {
			System.out.println(">> 등록에 실패했습니다.");
		}
	}
	
	void boardPrint(Board[] boardList) {
		boolean printState = false;
		System.out.println(">> 게시물을 출력합니다.");
		for(int index = 0; index < boardList.length; index++) {
			if(boardList[index] != null) {
				printState = true;
				System.out.printf("\n====== %d번째 게시물 ======\n", index+1);
				System.out.println(">> 제목 : " + boardList[index].title + " ");
				System.out.println(">> 내용 : " + boardList[index].content + " ");
				System.out.println(">> 작성자 : " + boardList[index].writer + " ");
				System.out.printf("====== %d번째 게시물 ======\n", index+1);
			}
		}
		if(!printState) {
			System.out.println(">> 게시물이 없습니다.");
		} else {
			System.out.println("\n>> 게시물 전체 출력 완료");
		}
	}

}
