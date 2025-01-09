package boardservice10.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import boardservice10.model.dto.BoardDto;

public class BoardDao extends Dao {
	// singleton start
	private static BoardDao instance = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() { return instance; }
	// singleton end
	
	/** 전체 게시물 조회 페이지 처리 메소드 */
	public ArrayList<BoardDto> findAll() {
		// 조회된 레코드(BoardDto)를 한개씩 저장하여 여러개의 레코드(BoardDto)를 저장하는 리스트 객체
		ArrayList<BoardDto> result = new ArrayList<>();
		try {
			String sql = "select * from board;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				// 조회된 레코드 1개 <----> 인스턴스(DTO)1개
				BoardDto boardDto = new BoardDto(rs.getInt("bno"), rs.getString("btitle"), rs.getString("bcontent"), 
						rs.getInt("bview"), rs.getString("bdate"), rs.getInt("mno"), rs.getInt("cno"));
				result.add(boardDto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
}
