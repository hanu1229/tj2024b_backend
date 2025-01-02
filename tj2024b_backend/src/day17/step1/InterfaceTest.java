package day17.step1;

public interface InterfaceTest {
	
	// 인터페이스 멤버
	// 1. 상수
	// int value1; --> 오류
	// 변수에 값을 넣으면 컴파일시 자동으로 상수로 만들어준다.
	int value2 = 10;
	// public static final 타입명 변수명 = 값;
	public static final int value3 = 20;
	final int value4 = 10;
	// 2. 추상메소드
	// int method1(int a) {}; --> 오류 : { } 사용 X
	int method2(int a);	
	abstract int method3(int a);
	
}
