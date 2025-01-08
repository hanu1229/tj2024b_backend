package boardservice10.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import boardservice10.model.dto.MemberDto;

public class MemberDao {
	/** DB와 연동한 결과를 조작하는 인터페이스 */
	private Connection conn;
	/** 연동할 DB서버의 URL */
	private String dburl = "jdbc:mysql://localhost:3306/boardservice10";
	/** 연동할 DB서버의 계정명 */
	private String dbuser = "root";
	/** 연동할 DB서버의 비밀번호 */
	private String dbpwd = "1234";
	// singleton start
	private static MemberDao instance = new MemberDao();
	private MemberDao() {
		try {			
			// 1. JDBC 클래스 드라이버 로드, Class.forName();
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 설정한 경로/계정/비밀번호로 DB서버에 연동을 시도하고 결과물(구현체)를 반환
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		}  catch(SQLException e) {
			System.out.println(">> DB 연동 실패");
			System.out.println(e);
		}
	}
	public static MemberDao getInstance() { return instance; }
	// singleton end
	
	/** 회원가입 처리 메소드 */
	public boolean signup(MemberDto memberDto) {
		try {			
			// [1] SQL문을 작성한다.
			String sql = "insert into member(mid, mpwd, mname, mphone) values ('" + 
					memberDto.getMid() + "', '" + memberDto.getMpwd() + "', '" +
					memberDto.getMname() + "', '" + memberDto.getMphone() + "');";
			// [2] DB와 연동된 곳에 SQL문을 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			// [3] 기재된 SQL문을 실행하고 결과를 받는다.
			int count = ps.executeUpdate();
			// [4] 결과에 따른 처리 및 반환을 한다.
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(">> DB에 저장 실패");
			System.out.println(e);
		}
		return false;
	}
	
	/** 로그인 처리 메소드 */
	public int login(MemberDto memberDto) {
		try {			
			// [1] SQL문을 작성한다.
			String sql = "select mno from member where mid = ? and mpwd = ?;";
			// [2] DB와 연동된 곳에 SQL문을 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			// [3] 기재된 SQL문을 실행하고 결과를 받는다.
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환을 한다.
			while(rs.next()) {
				return rs.getInt("mno");
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return 0;
	}
	
	
	/** 아이디찾기 처리 메소드 */
	public String findId(MemberDto memberDto) {
		try {	
			// [1] SQL문 작성한다.
			String sql = "select mid from member where mname = ? and mphone = ?;";
			// [2] DB와 연동된 곳에 SQL문 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			// [3] 기재된 SQL문을 실행하고 결과를 받는다.
			ps.setString(1, memberDto.getMname());
			ps.setString(2, memberDto.getMphone());
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환을 한다.
			while(rs.next()) {
				String result = rs.getString("mid");
				return result;
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	/** 비밀번호찾기 처리 메소드 */
	public String findPwd(MemberDto memberDto) {
		try {
			// [1] SQL문 작성한다.
			String sql = "select * from member where mid = ? and mphone = ?;";
			// [2] DB와 연동된 곳에 SQL문 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			// [3] 기재된 SQL문을 실행하고 결과를 받는다.
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMphone());
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환한다.
			while(rs.next()) {				
				String result = rs.getString("mpwd");
				return result;
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	/** 내정보 보기 처리 메소드 */
	public MemberDto myInfo(int loginMno) {
		try {
			// [1] SQL문을 작성한다.
			String sql = "select * from member where mno = ?;";
			// [2] DB와 연동된 곳에 SQL문을 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			// [3] 기재된 SQL문을 실행하고 결과를 받는다.
			ps.setInt(1, loginMno);
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환을 한다.
			if(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setMid(rs.getString("mid"));
				memberDto.setMname(rs.getString("mname"));
				memberDto.setMphone(rs.getString("mphone"));
				memberDto.setMdate(rs.getString("mdate"));
				return memberDto;
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	/** 회원탈퇴 처리 메소드 */
	public void delete(int loginMno) {
		try {
			String sql = "delete from member where mno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, loginMno);
			int result = ps.executeUpdate();
			if(result == 1) {
				System.out.println(">> 회원탈퇴 성공");
			} else {
				System.out.println(">> 회원탈퇴 오류");
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	
}
