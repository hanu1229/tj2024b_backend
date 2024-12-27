package day14.boardProgram9.model.dao;
import day14.boardProgram9.model.dto.BoardDto;
import java.util.ArrayList;

public class BoardDao {
	// singleton start
	private static BoardDao instance = new BoardDao();
	private BoardDao() { }
	public static BoardDao getInstance() { return instance; }
	// singleton end
	
	ArrayList<BoardDto> boardDB = new ArrayList<>();
	
	// 게시물 등록 처리 함수
	public boolean create(BoardDto boardDto) {
		if(boardDto != null) {			
			boardDB.add(boardDto);
			return true;
		} else {
			return false;
		}
	}
	
	// 게시물 출력 처리 함수
	public ArrayList<BoardDto> readAll() {
		return boardDB;
	}
	
	// 게시물 수정 처리 함수
	public boolean update(BoardDto boardDto, int boardIndex) {
		if(boardIndex > boardDB.size() -1 || boardIndex < 0) {
			return false;
		} else {
			// BoardDto board = boardDB.get(boardIndex);
			// if(board != null) { }
			// board.setTitle(boardDto.getTitle());
			// board.setContent(boardDto.getContent());
			// board.setWriter(boardDto.getWriter());
			boardDB.set(boardIndex, boardDto);
			return true;
		}
	}
	
	// 게시물 삭제 처리 함수
	public boolean delete(int boardIndex) {
		if(boardIndex > boardDB.size() - 1) {
			return false;
		} else {			
			boardDB.remove(boardIndex);
			return true;
		}
	}
}
