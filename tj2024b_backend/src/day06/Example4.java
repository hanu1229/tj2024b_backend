package day06;

public class Example4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [1] 클래스 정의하기, 객체를 만들기위한 일종의 틀 만들기
		
		// [2] 객체 생성, 클래스 기반으로 메모리 할당
		붕어빵틀 붕어빵1 = new 붕어빵틀();
		붕어빵틀 붕어빵2 = new 붕어빵틀();
		붕어빵1.반죽 = "밀가루";
		붕어빵2.반죽 = "밀가루";
		붕어빵1.내용물 = "팥앙금";
		붕어빵2.내용물 = "슈크림";
		
		// [1] 클래스 정의, 자동차
		// Car.java 파일 생성
		// [2] 객체 생성하기(인스턴스)
		Car car1 = new Car();
		Car car2 = new Car();
		// [3] 객체의 멤버변수 접근하기
		car1.차량번호 = 111;
		car1.차량주인 = "유재석";
		car2.차량번호 = 222;
		car2.차량주인 = "강호동";
		
		SmartPhone phone1 = new SmartPhone();
		SmartPhone phone2 = new SmartPhone();
		
		phone1.usimState = true;
		phone1.phoneNumber = "010-1111-1111";
		phone1.phoneName = "갤럭시 폴드6";
		
		phone2.usimState = false;
		phone2.phoneNumber = "010-2222-2222";
		phone2.phoneName = "아이폰 16";
	}
}