package day14.boardProgram9.controller;
import day14.boardProgram9.model.dto.BoardDto;
import day14.boardProgram9.model.dao.BoardDao;
import java.util.ArrayList;

public class BoardController {
	// singleton start
	private static BoardController instance = new BoardController();
	private BoardController() { }
	public static BoardController getInstance() { return instance; }
	// singleton end
	
	// 게시물 작성 제어 함수
	public boolean create(BoardDto boardDto) {
		boolean result = BoardDao.getInstance().create(boardDto);
		return result;
	}
	
	// 게시물 출력 제어 함수
	public ArrayList<BoardDto> readAll() {
		ArrayList<BoardDto> result = BoardDao.getInstance().readAll();
		return result;
	}
	
	// 게시물 수정 제어 함수
	public boolean update(BoardDto boardDto, int boardIndex) {
		boolean result = BoardDao.getInstance().update(boardDto, boardIndex);
		return result;
	}
	
	// 게시물 삭제 제어 함수
	public boolean delete(int boardIndex) {
		boolean result = BoardDao.getInstance().delete(boardIndex);
		return result;
	}
	
}
