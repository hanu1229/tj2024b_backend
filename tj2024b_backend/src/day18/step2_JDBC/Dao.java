package day18.step2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	// DB 연동 정보
	private String dbUrl = "jdbc:mysql://localhost:3306/mydb0103";
	private String dbUser = "root";
	private String dbPw = "1234";
	// JDBC 인터페이스
	private Connection conn;
	// singleton start
	private static Dao instance = new Dao();
	private Dao() {
		try {
			// JDBC DB 연동
			// 1. 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. DB 서버와 연결 시도
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
			System.out.println(">> DB Connection Success");
		} catch(ClassNotFoundException e) {
			System.out.println(">> No JDBC driver found");
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(">> DB Connection fail");
			System.out.println(e);
		}
	}
	public static Dao getInstance() { 
		return instance; 
	}
	// singleton end
	
	public Connection getConnection() { return this.conn; }
	
	// 1. insert 메소드
	public void insert() {
		try {			
			// [1] SQL 작성
			String sql = "insert into user(uname, uage) values ('유재석', 30)";
			// [2] SQL 기재 prepare : 준비, Statement : 기재
			// 연동된 DB에 SQL을 기재하고 기재된 SQL문을 객체로 반환
			PreparedStatement ps = conn.prepareStatement(sql);
			// [3] .execute() : 기재된 SQL문을 실행하는 메소드
			// [3] .executeUpdate() : 기재된 SQL문을 실행하고 새로고침하는 메소드
			// 현재 기재된 SQL을 실행하고 처리한 레코드 수를 반환
			// 반환타입 : int
			int count = ps.executeUpdate();
			// [4] SQL 실행 결과 반환 받기
			if(count == 1) { System.out.println(">> insert Success"); return; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		System.out.println(">> insert Fail");
	}
	
	// 2. select 메소드
	public void select(String tableName) {
		try {
			// [1] SQL 작성
			String sql = "select * from " + tableName + ";"; 
			// [2] SQL 기재
			PreparedStatement ps = conn.prepareStatement(sql);
			// [3] 기재된 SQL 실행
			// .executeQuery()
			// 현재 기재된 SQL을 실행하고 조회 결과를 조작 가능한 인스턴스를 반환
			// 반환타입 : ResultSet
			// [4] SQL 실행 결과 반환 받기
			ResultSet rs =  ps.executeQuery();
			// [5] 반환 결과를 조작
			// .next() : 조회결과에서 다음 레코드로 이동하는 메소드
			// 다음 레코드가 존재하면 true 존재하지 않는다면 false 반환
			// 레코드가 존재하지 않을때까지 무한 루프
			while(rs.next()) {
				// rs.get타입("속성명");
				// 현재 레코드의 속성 값을 반환하는 메소드(타입은 일치해야 함)
				System.out.printf("%d \t %s \t %d \n", rs.getInt("uno"), rs.getString("uname"), rs.getInt("uage"));
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	// 3. update 메소드
	public void update() {
		try {
			// SQL 작성 (update 테이블명 set 속성명 = 새로운 값 where 속성명 = 값;)
			String sql = "update user set uname = '강호동' where uno = 2";
			// SQL 기재
			PreparedStatement ps = conn.prepareStatement(sql);
			// 기재된 SQL 실행 및 반환값 얻기
			int count = ps.executeUpdate();
			// 반환 결과를 조작
			if(count == 1) { System.out.println(">> update Success"); return; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		System.out.println(">> update Fail");
	}
	
	// 4. delete 메소드
	public void delete() {
		try {
			// SQL 작성 (delete from 테이블명 where 속성명 = 값;)
			String sql = "delete from user where uno = 3";
			// SQL 기재
			PreparedStatement ps = conn.prepareStatement(sql);
			// 기재된 SQL 실행 및 반환값 얻기
			int count = ps.executeUpdate();
			// 반환 결과를 조작
			if(count == 1) { System.out.println(">> delete Success"); return; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		System.out.println(">> delete Fail");
	}
}
