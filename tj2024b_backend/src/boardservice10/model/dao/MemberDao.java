package boardservice10.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
			// 2. 
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(">> DB 연동 실패");
			System.out.println(e);
		}
	}
	public static MemberDao getInstance() { return instance; }
	// singleton end
}
