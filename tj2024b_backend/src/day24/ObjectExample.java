package day24;

class Book {}

public class ObjectExample {
	
	public static void main(String[] args) {
		// [1] Object클래스를 이용한 객체/인스턴스
		// Object type
		Object obj1 = new Object();
		// int type
		Object obj2 = 3;
		// double type
		Object obj3 = 3.14;
		// String type
		Object obj4 = "유재석";
		// array type
		Object obj5 = new int[] {3, 10, 20};
		// reference type
		Object obj6 = new Book();
		// Object가 모든 타입들을 참조할 수 있는 이유 : Object가 최상위 클래스이기 때문이다.
		// 하위 타입은 상위 타입으로 타입변환이 가능하다.
		
		// [2] Object 메소드
		// toString() : 객체를 문자열로 표현하여 반환한다. / 인스턴스는 주소값을 16진수로 반환한다.
		System.out.println(obj6.toString());
		System.out.println(obj5.toString());
		// equals() : 주로 String에서 비교할 때 사용한다.
		// 값1 = 값2 , 값1.equals(값2);
		System.out.println(obj1 == obj2);
		Object obj7 = obj6;
		System.out.println(obj7 == obj6);
		System.out.println(obj1.equals(obj2));
		System.out.println(obj7.equals(obj6));
		
		// [3] .hashCode() : 인스턴스의 해시 코드 값을 반환하는 함수
		System.out.println(obj1.hashCode());
		System.out.println(obj6.hashCode());
		System.out.println(obj7.hashCode());
	}
}
