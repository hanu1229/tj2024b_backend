package day12;

class BirthDay {
	// 모든 인스턴스들이 각각 사용하는 변수 = 힙메모리
	int day; int month; int year;
	
	// 모든 인스턴스들이 공통으로 사용하는 함수 = 정적메모리
	public void setYear(int year) { this.year = year; }
	public void printThis() { System.out.println(this); }
	// this : 해당 메소드를 호출하는 인스턴스를 가르킨다.
}

public class Example1 {

	public static void main(String[] args) {
		BirthDay dDay = new BirthDay();
		dDay.printThis();
		dDay.setYear(2000);
		System.out.println(dDay.year);
		
		BirthDay dDay2 = new BirthDay();
		dDay2.printThis();
		dDay2.setYear(2024);
		System.out.println(dDay2.year);
	}

}
