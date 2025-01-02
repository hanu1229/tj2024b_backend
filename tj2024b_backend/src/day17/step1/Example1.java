package day17.step1;

class Tool1 implements InterfaceTest {
	
	 @Override
	public int method2(int a) {
		System.out.println("Tool1클래스에서 구현된 method2메소드");
		return a;
	}
	@Override
	public int method3(int a) {
		System.out.println("Tool1클래스에서 구현된 method3메소드");
		return a;
	}
	
}

class Tool2 implements InterfaceTest {
	@Override
	public int method2(int a) {
		System.out.println("Tool2클래스에서 구현된 method2메소드");
		return a;
	}
	@Override
	public int method3(int a) {
		System.out.println("Tool2클래스에서 구현된 method2메소드");
		return a;
	}
}

public class Example1 {

	public static void main(String[] args) {
		
		// 1. 인터페이스의 상수 사용
		System.out.println(InterfaceTest.value2);
		System.out.println(InterfaceTest.value3);
		
		// 2. 인터페이스의 추상메소드 사용
		// 추상메소드 : 구체적인 메소드가 아닌 단순히 선언만 되어있고 구현부({})가 존재하지 않는다.
		// InterfaceTest.method2(); --> 오류
		
		// 추상메소드를 (클래스들이) 구체적으로 구현하기.
		Tool1 tool = new Tool1();
		tool.method2(0);
		tool.method3(1);
		
		InterfaceTest inter1 = new Tool1();
		inter1.method2(10);
		inter1.method3(20);
		
		Tool2 tool2 = new Tool2();
		tool2.method2(0);
		tool2.method3(0);
		
		InterfaceTest inter2 = new Tool2();
		inter2.method2(10);
		inter2.method2(20);
	}

}
