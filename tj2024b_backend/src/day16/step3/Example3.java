package day16.step3;

class Parent {
	String field1;
	public void method1() {System.out.println("Parent method1");}
	public void method2() {System.out.println("Parent method2");}
}
class Child extends Parent {
	String field2;
	public void method3() {System.out.println("Child method3");}
	// *물려받은 메소드를 재정의/코드변경 ※오버라이딩※
	// 주의할점 : 메소드의 선언부는 동일하게 작성 { } 안에 있는 코드만 재정의
	// @ 어노테이션 / 생략이 가능하다.
	// 멤버변수는 인스턴스 마다 할당, 메소드는 모든 인스턴스가 공유해서 사용하기 때문에 this/super를 사용하지 않는다.
	@Override
	public void method1() {System.out.println("Child method1");}
	public void method2() {System.out.println("Child method2");}
}

public class Example3 {

	public static void main(String[] args) {
		
		// 1. 자식 인스턴스 생성
		Child child = new Child();
		// 자식 인스턴스는 부모클래스의 메소드/멤버변수를 사용할 수 있다.
		child.method1();
		child.method2();
		child.method3();
		System.out.println("=== parent ===");
		// 2. 자식 클래스의 인스턴스가 부모 클래스로 타입 변환
		Parent parent = child;
		parent.method1();
		parent.method2();
		// 타입 변환시 하위타입 멤버에 접근할 수 없다.
		// parent.method3();
		System.out.println("=== child2 ===");
		// 3. 부모 클래스의 타입에서 자식 클래스의 타입으로 변환
		Child child2 = (Child)parent;
		child2.method1();
		child2.method2();
		child2.method3();
		// 4. 부모 클래스의 인스턴스 생성
		Parent parent2 = new Parent();
		System.out.println("=== parent2 ===");
		parent2.method1();
		parent2.method2();
		// 오류 부모 인스턴스가 생성될때 자식 인스턴스가 생성되지 않았기 때문
		// Child child3 = (Child)parent2;
		// 태생 검사
		if(parent2 instanceof Child) {
			Child child3 = (Child)parent2;
		} else {
			System.out.println("타입변환 불가능");
		}
	}
}
