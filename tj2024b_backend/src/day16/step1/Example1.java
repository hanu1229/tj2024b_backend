package day16.step1;

// 부모 : object / 자식 : B,C / 자손 : D,E 
class A {}
// 부모 : A / 자식 : D
class B extends A {}
// 부모 : A / 자식 : E
class C extends A {}
// 부모 : B / 자식 : X
class D extends B {}
// 부모 : C / 자식 : X
class E extends C {}

public class Example1 {

	public static void main(String[] args) {
		
		// B클래스의 인스턴스 B인스턴스 -> A인스턴스 -> Object인스턴스
		B b = new B();
		// C클래스의 인스턴스 C인스턴스 -> A인스턴스 -> Object인스턴스
		C c = new C();
		// D클래스의 인스턴스 D인스턴스 -> B인스턴스 -> A인스턴스 -> Object인스턴스
		D d = new D();
		// E클래스의 인스턴스 E인스턴스 -> C인스턴스 -> A인스턴스 -> Object인스턴스
		E e = new E();
		
		// [1] 자동 타입변환, 묵시적 타입변환
		A a1 = b; A a2 = c; A a3 = d; A a4 = e;
		// B b2 = c; B b4 = e; 형제간의 타입 변환은 불가능
		B b1 = b; B b3 = d;
		// C c1 = b; C c3 = d; 형제간의 타입 변환은 불가능
		C c2 = c; C c4 = e;
		D d3 = d;
		
		// [2] 강제 타입 변환 명시적 타입변환, 캐스팅
		B b5 = (B)a1;
		E e5 = (E)a4;
		// 오류 ClassCastException
		// E e6 = (E)a1;
		// D d6 = (D)a2;
		
		// [3] 본래의 인스턴스를 확인하는 방법 (instanceof 키워드)
		// a1변수가 참조하는 인스턴스에 A타입이 존재? true
		System.out.println(a1 instanceof A);
		System.out.println(a1 instanceof Object);
		System.out.println(a1 instanceof C);
		
		System.out.println(a4 instanceof B);
		System.out.println(a4 instanceof C);
	}

}
