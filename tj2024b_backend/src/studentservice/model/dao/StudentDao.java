package studentservice.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import studentservice.model.dto.StudentDto;

public class StudentDao {
	/** DB와 연동한 결과를 조작하는 인터페이스 */
	private Connection conn;
	/** 연동할 DB서버의 URL */
	private String dburl = "jdbc:mysql://localhost:3306/studentservice";
	/** 연동할 DB서버의 계정명 */
	private String dbuser = "root";
	/** 연동할 DB서버의 비밀번호 */
	private String dbpwd = "1234";
	
	// singleton start
	private static StudentDao instance = new StudentDao();
	private StudentDao() {
		try {
			// 1. JDBC 클래스 드라이버 로드, Class.forName();
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 설정한 경로/계정/비밀번호로 DB서버에 연동을 시도하고 결과물(구현체)를 반환
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
			System.out.println(">> DB 연동 실패");
		}
	}
	public static StudentDao getInstance() { return instance; }
	// singleton end
	
	/** 점수등록 페이지 처리 메소드 */
	public boolean register(StudentDto sd) {
		try {			
			String sql = "insert into student(sname, kscore, escore, mscore) values (?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sd.getSname());
			ps.setInt(2, sd.getKscore());
			ps.setInt(3, sd.getEscore());
			ps.setInt(4, sd.getMscore());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 전체점수조회 페이지 처리 메소드 */
	public ArrayList<StudentDto> readAll() {
		ArrayList<StudentDto> result = new ArrayList<>();
		try {
			String sql = "select * from student;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StudentDto sd = new StudentDto();
				sd.setSno(rs.getInt("sno"));
				sd.setSname(rs.getString("sname"));
				sd.setKscore(rs.getInt("kscore"));
				sd.setEscore(rs.getInt("escore"));
				sd.setMscore(rs.getInt("mscore"));
				result.add(sd);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 점수수정 페이지 처리 메소드 */
	public boolean update(StudentDto sd) {
		try {
			String sql = "update student set kscore = ?, escore = ?, mscore = ? where sno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sd.getKscore());
			ps.setInt(2, sd.getEscore());
			ps.setInt(3, sd.getMscore());
			ps.setInt(4, sd.getSno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 점수삭제 페이지 처리 메소드*/
	public boolean delete(int sno) {
		try {
			String sql = "delete from student where sno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sno);
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
}
