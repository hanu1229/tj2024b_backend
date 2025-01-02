package day17.step2;

public class Example2 {

	public static void main(String[] args) {
		// 인터페이스 타입의 변수 생성, 키보드 변수 선언
		Keyboard myKeyBoard;
		
		myKeyBoard = new HuntingGame();
		myKeyBoard.aKey();
		myKeyBoard.bKey();
		
		myKeyBoard = new SoccerGame();
		myKeyBoard.aKey();
		myKeyBoard.bKey();
		
		HuntingGame game1 = new HuntingGame();
		game1.aKey();
		game1.bKey();
		// game1 = new SoccerGame(); --> 오류 다른 클래스이며 부모 인터페이스가 같아 형제 클래스이다.
	}

}
