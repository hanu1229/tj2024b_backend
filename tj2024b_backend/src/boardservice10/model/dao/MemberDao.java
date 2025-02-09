package boardservice10.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import boardservice10.model.dto.MemberDto;

public class MemberDao extends Dao {
	// singleton start
	private static MemberDao instance = new MemberDao();
	private MemberDao() { super(); }
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
	
	/** 회원수정 처리 메소드 */
	public boolean update(MemberDto memberDto) {
		try {
			String sql = "update member set mpwd = ?, mname = ?, mphone = ? where mno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getMpwd());
			ps.setString(2, memberDto.getMname());
			ps.setString(3, memberDto.getMphone());
			ps.setInt(4, memberDto.getMno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 특정한 속성의 중복값 검색
	 *  <p>
	 *  field : 중복을 검사할 데이터의 속성명
	 *  <p>
	 *  value : 중복을 검사할 데이터
	 * */
	public boolean check(String field, String value) {
		StringBuilder builder = new StringBuilder();
		builder.append("select * from member where ");
		builder.append(field);
		builder.append(" = ");
		builder.append("'" + value + "'");
		//System.out.println(builder.toString());
		try {			
			String sql = "select * from member where " + field + " = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, value);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
}
