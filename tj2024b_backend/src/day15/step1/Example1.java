package day15.step1;

class Animal {
	String myName;
	
	Animal() {
		this.myName = "동물";
		System.out.println("[[동물 생성자 탄생]]");
	}
	void showMe() {
		System.out.println("myName : " + this.myName);
	}
}

class Birds extends Animal {
	Birds() {
		this.myName = "조류";
		System.out.println("[[조류 생성자 탄생]]");
	}
}
class Sparrow extends Birds {
	Sparrow() {
		this.myName = "참새";
		System.out.println("[[참새 생성자 탄생]]");
	}
}
class Chicken extends Birds {
	Chicken() {
		this.myName = "닭";
		System.out.println("[[닭 생성자 탄생]]");
	}
}

public class Example1 {
	
	public static void main(String[] args) {
		
		// [1] Animal인스턴스 생성
		// 생성된 인스턴스 2개 (object --> animal)
		Animal animal = new Animal();
		animal.showMe();
		// 생성된 인스턴스 3개 (object --> animal --> bird)
		Birds bird = new Birds();
		bird.showMe();
		// 생성된 인스턴스 4개 (object --> animal --> bird --> sparrow)
		Sparrow sparrow = new Sparrow();
		sparrow.showMe();
		
		// [2] 타입 변환
		// 자식 타입의 자료는 부모 타입으로 변환이 자동으로 가능하다. 자식 객체는 부모 타입을 참조한다.
		// 참새 타입의 자료(객체)가 조류 타입으로 변환이 된다. (자동타입변환)
		Birds bird2 = sparrow;
		// 참새 타입의 자료(객체)가 동물 타입으로 변환이 된다. (자동타입변환)
		Animal animal2 = sparrow;
		// 참새 타입의 자료(객체)가 Object 타입으로 변환이 된다. (자동타입변환)
		Object obj = sparrow;
		
		// 부모 타입의 자료는 자식 타입으로 변환이 될 수 없다. 부모객체는 자식타입으로 참조하지 않는다.
		// 동물 타입의 자료(객체)가 참새 타입으로 변환이 안된다.
		//Sparrow sparrow3 = animal;
		// 동물 타입의 자료(객체)가 조류 타입으로 변환이 안된다.
		//Birds bird3 = animal;
		// *캐스팅* : 가능한 전제조건은 본래 하위 타입의 객체가 상위 타입에서 다시 본래 하위 타입 변환 허용.
		// 부모 타입의 자료는 자식 타입으로 변환이 될 수 없지만 본래 자식의 타입의 객체였다면 가능하다.
		Animal animal4 = sparrow;
		Sparrow sparrow4 = (Sparrow)animal4;
		
		// 형제간의 타입변환은 불가능
		Chicken chicken1 = new Chicken();
		Birds bird5 = chicken1;
		// Sparrow sparrow5 = bird5;
	}
}
