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
}
