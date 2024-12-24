package day12;

class Member {
	String name;
	static int age;
	
	boolean getAge() { return true; }
	static int getName() { return 10; }
}

public class Example4 {

	public static void main(String[] args) {
		// 함수 호출판단
			// 1. 호출하고자 하는 메소드가 같은 클래스인지 다른 클래스인지 판단
			// 2. 호출하고자 하는 메소드가 static(정적)인지 아닌지 판단
			// 3. 호출하고자 하는 위치의 메소드가 static(정적)인지 아닌지 판단
				// - static 없는 메소드는 객체를 통해 호출
				// - static 있는 메소드는 클래스를 통해 호출
		
		Example4 example4 = new Example4();
		example4.signup();
		login();

	}
	
	void signup() {
		System.out.println("singup");
		myInfo();
		Member member = new Member();
		System.out.println(member.getAge());
	}
	void myInfo() {
		System.out.println("myInfo");
	}
	
	static void login() {
		System.out.println("login");
	}

}
