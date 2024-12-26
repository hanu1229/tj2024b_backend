package day13.boardProgram8.controller;
import day13.boardProgram8.model.dao.BoardDao;
import day13.boardProgram8.model.dto.BoardDto;

// 입력받은 게시물 정보를 받아 dao에게 전달하는 담당 클래스 (싱글톤 패턴)
public class BoardController {
	// singleton start
	private static BoardController instance = new BoardController();
	private BoardController() { }
	
	public static BoardController getInstance() {
		if(instance == null) {
			instance = new BoardController();
		}
		return instance;
	}
	// singleton end
	
	// 글쓰기 제어 메소드
	public boolean write(BoardDto boardDto) {
		// [1] dao에게 저장할 객체를 전달하고 응답하기
		boolean result = BoardDao.getInstance().write(boardDto);
		// [2] View에게 응답하기 
		return result;
	}
	
	// 글출력 제어 메소드
	public BoardDto[] findAll() {
		// [1] dao에게 모든 게시물 정보를 요청하고 응답받기
		BoardDto[] result = BoardDao.getInstance().findAll();
		// [2] View에게 응답하기
		return result;
	}
}
