package day09;

public class Example3 {

	public static void main(String[] args) {
		Person person1 = new Person();
		Person person2 = new Person("유재석");
		Person person3 = new Person("강호동", 180.1f, 82.9f);
		// person1.name = "이정만";
		System.out.println(person1.getName());
		System.out.println(person2.getName());
		System.out.println(person3.getName());
		System.out.println(person3.height);
		System.out.println(person3.weight);

	}

}
