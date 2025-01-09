package boardservice10.view;

import java.util.ArrayList;
import java.util.Scanner;

import boardservice10.controller.BoardController;
import boardservice10.model.dto.BoardDto;

public class BoardView {
	// singleton start
	private static BoardView instance = new BoardView();
	private BoardView() {}
	public static BoardView getInstance() { return instance; }
	// singleton end
	
	private Scanner scan = new Scanner(System.in);
	
	/** 로그인 했을때 메인메뉴 페이지 */
	public void index() {
		System.out.println("====== 게시판 ======");
		findAll();
		while(true) {
			System.out.print(">> 1.로그아웃 2.내정보 3.게시물작성 4.게시물상세보기 : ");
			int choose = scan.nextInt();
			if(choose == 1) { MemberView.getInstance().logout(); break; }
			else if(choose == 2) {
				int state = MemberView.getInstance().myInfo();
				if(state == 0) { return; }
				/*
				if(MemberController.getInstance().getLoginMno() == 0) {
					break;
				}
				*/
			}
			else if(choose == 3) {}
			else if(choose == 4) {}
		}
	}
	
	/** 전체 게시물 조회 화면 */
	public void findAll() {
		// 1. 컨트롤러에게 요청하고 결과를 받는다.
		ArrayList<BoardDto> result = BoardController.getInstance().findAll();
		// 2. 결과값을 출력한다
		System.out.println("번호\t카테고리\t작성자\t\t작성일\t\t  제목");
		for(int index = 0; index < result.size(); index++) {
			BoardDto boardDto = result.get(index);
			System.out.print(boardDto.getBno() + "\t");
			System.out.print(boardDto.getCno() + "\t");
			System.out.print(boardDto.getMno() + "\t");
			System.out.print(boardDto.getBdate() + "\t");
			System.out.print(boardDto.getBtitle() + "\n");
		}
	}
	
}
