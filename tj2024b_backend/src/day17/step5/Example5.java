package day17.step5;

interface InterFaceTest2 {
	// 1. 상수
	public static final int value = 10;
	// 2. 추상 메소드
	public abstract void method();
	// 3. 디폴트 메소드 : 인터페이스에 구현한 메소드를 만들수 있다.
	public default void method2() {method4(); method5();}
	// 4. 정적 메소드 : 인터페이스에 정적 구현 메소드를 만들수 있다.
	public static void method3() {}
	// 5. private 메소드 : 현재 인터페이스에서만 사용 가능한 구현 메소드를 만들수 있다.
	private void method4() {}
	// 6. private static 메소드 : 현재 인터페이스에서만 사용 가능한 정적 구현 메소드를 만들수 있다.
	private static void method5() {}
	
}

public class Example5 {
	public static void main(String[] args) {
		 // [1] 인터페이스의 상수 호출
		System.out.println(InterFaceTest2.value);
		// [2] 인터페이스의 추상메소드 호출
		// InterFaceTest2.method(); --> 오류
		// [3] 인터페이스의 디폴트메소드 호출
		// InterFaceTest2.method2(); --> 오류
		// [4] 인터페이스의 정적메소드 호출
		InterFaceTest2.method3();
		// [5] 인터페이스타입은 new 할수 없다. 인스턴스 생성이 불가능
		// InterFaceTest2 inter = new InterFaceTest2(); --> 오류
		
	}
}
