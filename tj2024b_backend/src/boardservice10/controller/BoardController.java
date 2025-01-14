package boardservice10.controller;

import java.util.ArrayList;

import boardservice10.model.dao.BoardDao;
import boardservice10.model.dto.BoardDto;

public class BoardController {
	// singleton start
	private static BoardController instance = new BoardController();
	private BoardController() {}
	public static BoardController getInstance() { return instance; }
	// singleton end
	
	/** 전체 게시물 조회 페이지 제어 메소드 */
	public ArrayList<BoardDto> findAll() {
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
		return result;
	}
	
	/** 개별(1개) 게시물 조회 페이지 제어 메소드 */
	public BoardDto findById(int bno) {
		BoardDto result = BoardDao.getInstance().findById(bno);
		return result;
	}
	
	/** 게시물 쓰기 페이지 제어 메소드 */
	public boolean write(BoardDto boardDto) {
		boardDto.setMno(MemberController.getInstance().getLoginMno());
		boolean result = BoardDao.getInstance().write(boardDto);
		return result;
	}
	
	/** 게시물 수정 페이지 제어 메소드 */
	public boolean update(BoardDto boardDto) {
		// 현재 로그인된 회원번호
		int loginMno = MemberController.getInstance().getLoginMno();
		// 내가 수정할 게시물 번호
		int currentBno = boardDto.getBno();
		// 수정할 게시물이 본인 게시물인지 확인하는 함수 호출
		boolean result = BoardDao.getInstance().writeCheck(currentBno, loginMno);
		if(result == false) { return false; }
		// 전달할 인수에 회원번호 넣기
		boardDto.setMno(MemberController.getInstance().getLoginMno());
		// 내가 쓴 게시물이면 DB에서 레코드 업데이트
		return BoardDao.getInstance().update(boardDto);
	}
	
	/** 게시물 삭제 페이지 제어 메소드 */
	public boolean delete(BoardDto boardDto) {
		int loginMno = MemberController.getInstance().getLoginMno();
		boolean result = BoardDao.getInstance().writeCheck(boardDto.getBno(), loginMno);
		if(result == false) { return false; }
		boardDto.setMno(MemberController.getInstance().getLoginMno());
		return BoardDao.getInstance().delete(boardDto);
	}
		
	/** 전체 카테고리 출력 페이지 제어 메소드 */
	public ArrayList<BoardDto> categoryAll() {
		return BoardDao.getInstance().categoryAll();
	}
	
}
