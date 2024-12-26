package day13.boardProgram8.model.dao;
import day13.boardProgram8.model.dto.BoardDto;

// (데이터 관련)기능을 처리하는 담당 클래스 (싱글톤 패턴)
public class BoardDao {
	// singleton start
	private static BoardDao instance = new BoardDao();
	private BoardDao() { }
	public static BoardDao getInstance() {
		if(instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	// singleton end
	
	// 멤버변수(모든 게시물정보를 갖는 배열, 데이터베이스 역할)
	private BoardDto[] boardDB = new BoardDto[100];
	
	// 글쓰기 처리(저장) 메소드
	public boolean write(BoardDto boardDto) {
		// [1] 매개변수로 받은 boardDto를 배열에 저장한다.
		for(int index = 0; index < boardDB.length; index++) {
			if(boardDB[index] == null) {
				boardDB[index] = boardDto;
				// [2] 성공시 결과를 Controller에게 응답한다.
				return true;
			}
		}
		// [2] 실패시 결과를 Controller에게 응답한다.
		return false;
	}
	
	// 글출력 처리(출력) 메소드
	public BoardDto[] findAll() {
		// [1] 배열의 모든 객체를 Controller에게 응답한다.
		return boardDB;
	}
}
