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
		while(true) {
			findAll();
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
			else if(choose == 3) { write(); }
			else if(choose == 4) { findById(); }
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
			System.out.print(boardDto.getCname() + "\t");
			System.out.print(boardDto.getMid() + "\t");
			System.out.print(boardDto.getBdate() + "\t");
			System.out.print(boardDto.getBtitle() + "\n");
		}
	}
	
	/** 개별(1개) 게시물 조회 페이지 */
	public void findById() {
		System.out.println("====== 개별 게시물 조회 ======");
		System.out.print(">> 게시물 번호 : "); int bno = scan.nextInt();
		while(true) {
			BoardDto result = BoardController.getInstance().findById(bno);
			if(result != null) {				
				System.out.println("====== 게시물 ======");
				System.out.println(">> 제목 : " + result.getBtitle());
				System.out.println(">> 카테고리 : " + result.getCname() + "\t작성자 : " + result.getMid() + 
						"\t조회수 : " + result.getBview() + "\t작성일 : " + result.getBdate());
				System.out.println(">> 내용 : " + result.getBcontent());
				// 추후 댓글 출력하는 코드 부분 아래로 작성
				System.out.println("====== 게시물 ======");
				System.out.print(">> 1.뒤로가기 2.댓글작성(구현X) 3.수정 4.삭제 : ");
				int choose = scan.nextInt();
				if(choose == 1) { break; }
				else if(choose == 2) { /*댓글작성 구현 X*/ }
				else if(choose == 3) { update(bno); }
				else if(choose == 4) { delete(bno); break; }
			} else {
				break;
			}
		}
	}
	
	/** 게시물 쓰기 페이지 */
	public void write() {
		// 카테고리 전체 조회
		categoryAll();
		System.out.print("카테고리 번호 : "); int cno = scan.nextInt();
		System.out.print("제목 : "); String btitle = scan.next(); scan.nextLine();
		System.out.print("내용 : "); String bcontent = scan.nextLine();
		BoardDto boardDto = new BoardDto();
		boardDto.setCno(cno); boardDto.setBtitle(btitle); boardDto.setBcontent(bcontent);
		boolean result = BoardController.getInstance().write(boardDto);
		if(result) { System.out.println(">> 게시물 작성 성공"); } else { System.out.println(">> 게시물 작성 실패"); }
	}
	
	/** 게시물 수정 페이지 */
	public void update(int bno) {
		System.out.println("======== 게시물 수정 ========");
		System.out.print(">> 새로운 제목 : "); String btitle = scan.next(); scan.nextLine();
		System.out.print(">> 새로운 내용 : "); String bcontent = scan.nextLine();
		BoardDto boardDto = new BoardDto();
		boardDto.setBtitle(btitle); boardDto.setBcontent(bcontent); boardDto.setBno(bno);
		boolean result = BoardController.getInstance().update(boardDto);
		if(result) { System.out.println(">> 수정 성공"); } else { System.out.println(">> 수정 실패"); }
	}
	
	/** 게시물 삭제 페이지 */
	public void delete(int bno) {
		BoardDto boardDto = new BoardDto(); boardDto.setBno(bno);
		boolean result = BoardController.getInstance().delete(boardDto);
		if(result) { System.out.println(">> 삭제 성공"); } else { System.out.println(">> 삭제 실패"); }
	}	
	
	/** 전체 카테고리 출력 페이지 */
	public void categoryAll() {
		ArrayList<BoardDto> result = BoardController.getInstance().categoryAll();
		System.out.println("======== 카테고리 ========");
		for(int index = 0; index < result.size(); index++) {
			BoardDto boardDto = result.get(index);
			System.out.printf("번호 : %d  카테고리명 : %s \n", boardDto.getCno(), boardDto.getCname());
		}
		System.out.println("======== 카테고리 ========");
	}
	
}
