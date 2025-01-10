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
			//String sql = "select * from board;";
			String sql = "select b.*, c.cname, m.mid from board as b inner join category as c on b.cno = c.cno" + 
			" inner join member as m on b.mno = m.mno;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				// 조회된 레코드 1개 <----> 인스턴스(DTO)1개
				BoardDto boardDto = new BoardDto(rs.getInt("bno"), rs.getString("btitle"), rs.getString("bcontent"), 
						rs.getInt("bview"), rs.getString("bdate"), rs.getInt("mno"), rs.getInt("cno"));
				boardDto.setCname(rs.getString("cname")); boardDto.setMid(rs.getString("mid"));
				result.add(boardDto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 개별(1개) 게시물 조회 페이지 제어 메소드 */
	public BoardDto findById(int bno) {
		BoardDto boardDto = null;
		try {
			//String sql = "select * from board where bno = ?;";
			String sql = "select b.*, c.cname, m.mid from board as b inner join category as c on b.cno = c.cno" + 
			" inner join member as m on b.mno = m.mno where b.bno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				boardDto = new BoardDto(rs.getInt("bno"), rs.getString("btitle"), rs.getString("bcontent"), 
						rs.getInt("bview"), rs.getString("bdate"), rs.getInt("mno"), rs.getInt("cno"));
				boardDto.setCname(rs.getString("cname")); boardDto.setMid(rs.getString("mid"));
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return boardDto;
	}
	
}
