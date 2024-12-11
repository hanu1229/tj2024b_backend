package day03;

public class Example3 {

	public static void main(String[] args) {
		// p.92 조건문
		
		int age = 10;
		// [1] if문
		if(age >= 8) {
			System.out.println("학교에 다닙니다.");
		}
		
		// [2] if ~ else문
		if(age >= 8) {
			System.out.println("학교에 다닙니다.");
		} else {
			System.out.println("학교에 다니지 않습니다.");
		}
		
		// [3] if ~ else if문
		int charge;
		if(age < 8) {
			charge = 1000;
			System.out.println("취학 전 아동입니다.");
		} else if(age < 14) {
			charge = 2000;
			System.out.println("초등학생입니다.");
		} else if(age < 20) {
			charge = 2500;
			System.out.println("중, 고등학생입니다.");
		} else if(age >= 60) {
			charge = 0;
			System.out.println("경로우대입니다.");
		} else {
			charge = 3000;
			System.out.println("일반인 입니다.");
		}
		System.out.println("입장료는 " + charge + "원 입니다.");
		
		// p.100 나 혼자 코딩
		int score = 90;
		char grade;
		if(score >= 90) {
			grade = 'A';
		} else if(score >= 80) {
			grade = 'B';
		} else if(score >= 70) {
			grade = 'C';
		} else if(score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println(grade);
	}
}
