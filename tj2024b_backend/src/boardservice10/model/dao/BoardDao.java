package boardservice10.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	
	/** 개별(1개) 게시물 조회 페이지 처리 메소드 */
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
		if(boardDto.getBno() == bno) {
			return boardDto;
		} else {			
			return null;
		}
	}
	
	/** 게시물 쓰기 페이지 처리 메소드 */
	public boolean write(BoardDto boardDto) {
		try {
			String sql = "insert into board(btitle, bcontent, mno, cno) values (?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getMno());
			ps.setInt(4, boardDto.getCno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 게시물 수정 페이지 처리 메소드 */
	public boolean update(BoardDto boardDto) {
		try {
			LocalDateTime time = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String ft = time.format(formatter);
			String sql = "update board set btitle = ?, bcontent = ?, bdate = ? where mno = ? and bno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setObject(3, time);
			ps.setInt(4, boardDto.getMno());
			ps.setInt(5, boardDto.getBno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	/** 게시물 삭제 페이지 처리 메소드*/
	public boolean delete(BoardDto boardDto) {
		try {
			String sql = "delete from board where bno = ? and mno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, boardDto.getBno());
			ps.setInt(2, boardDto.getMno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 전체 카테고리 출력 페이지 처리 메소드 */
	public ArrayList<BoardDto> categoryAll() {
		ArrayList<BoardDto> result = new ArrayList<BoardDto>();
		try {
			String sql = "select cno, cname from category order by cno;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setCno(rs.getInt("cno")); boardDto.setCname(rs.getString("cname"));
				result.add(boardDto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 내가 쓴글 확인 SQL 메소드 */
	public boolean writeCheck(int bno, int mno) {
		try {
			String sql = "select * from board where bno = ? and mno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.setInt(2, mno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
}
