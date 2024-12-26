package day13.boardProgram8;
import day13.boardProgram8.view.BoardView;

// 프로그램을 시작하는 클래스(main함수 포함) (싱글톤 패턴)
public class AppStart {

	public static void main(String[] args) {
		BoardView.getInstance().index();
	}
}
