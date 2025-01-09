package boardservice10.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
	접근제한자
	public		: 프로그램내 모든 곳에서 접근 가능
	private		: 현재 클래스에서만 사용 가능
	(defalut)	: 같은 패키지에서만 접근 가능 *접근제한자를 작성하지 않으면 적용된다. 
	protected	: 같은 패키지에서만 접근 가능 *상속 관계이면 다른 패키지도 가능
*/

public class Dao {
	/** DB와 연동한 결과를 조작하는 인터페이스 */
	protected Connection conn;
	/** 연동할 DB서버의 URL */
	private String dburl = "jdbc:mysql://localhost:3306/boardservice10";
	/** 연동할 DB서버의 계정명 */
	private String dbuser = "root";
	/** 연동할 DB서버의 비밀번호 */
	private String dbpwd = "1234";
	
	protected Dao() {
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
}
