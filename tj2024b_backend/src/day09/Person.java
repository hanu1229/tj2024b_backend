package day09;

public class Person {
	private String name;
	float height;
	float weight;
	
	// 오버로드 : 동일한 생성자명을 여러개 선언(전제조건 : 매개변수의 개수, 타입, 순서가 다를경우에만 가능)
	// (매개변수 명은 제외)
	Person() { }
	Person(String pname) { name = pname; }
	Person(String name, float height, float weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	
	public String getName() {
		return name;
	}
}
