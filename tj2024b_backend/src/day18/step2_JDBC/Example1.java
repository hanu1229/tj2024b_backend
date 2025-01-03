package day18.step2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example1 {

	public static void main(String[] args) {
		Connection conn;
		// [1] DB 연동
		// "com.mysql.cj.jdbc" : 패키지 경로, "Driver" : 클래스
		// mysql : com.mysql.cj.jdbc.Driver
		// oracle : oravle.jdbc.driver.OracleDriver
		try {
			// mysql JDBC 클래스 존재하는지 로드/불러오기, 클래스 로드 함수는 Class.forName()을 사용
			Class.forName("com.mysql.cj.jdbc.Driver");
			// db서버와 연동 시도
			// DriverManager : DB서버와 연동하는 클래스
			// .getConnection(url, user, password);
			// url : jdbc:mysql://주소:포트번호/데이터베이스명
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0103", "root", "1234");
			System.out.println(">> DB 연동 성공");
			conn.close();
			System.out.println(">> DB 연동 끊음");
		} catch(ClassNotFoundException e) {
			System.out.println("프로젝트내 jdbc 드라이버가 존재하지 않습니다.");
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println("DB연동 실패 : " + e);
		}
	}

}
