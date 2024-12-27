package day14.boardProgram9;
import day14.boardProgram9.view.BoardView;

/*
	자바 실습 : 비게시판 프로그램
		- MVC패턴으로 패키지와 클래스 구성하기
		- 배열 대신 ArrayList클래스 사용하기
*/

public class AppStart {

	public static void main(String[] args) {
		BoardView.getInstance().run();
	}

}
