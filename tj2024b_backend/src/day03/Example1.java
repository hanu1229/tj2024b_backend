package day03;

public class Example1 {

	public static void main(String[] args) {
		// 연산자
		// [1] 대입연산자
		int age = 24;
		int mathScore = 10;
		int engScore = 20;
		int totalScore = mathScore + engScore;
		
		// [2] 부호 연산자
		int num = 10;
		System.out.println(+num);
		System.out.println(-num);
		System.out.println(num);
		num = -num;
		System.out.println(num);
		
		// [3] 산술 연산자
		System.out.println(5 / 3);
		System.out.println(5.0 / 3.0);
		System.out.println((int)(5.0 / 3.0));
		
		int math = 90, eng = 70;
		int total = math + eng;
		System.out.println("total : " + total);
		double avg = total / 2;
		System.out.println("avg : " + avg);
		
		// [1분 복습]
		int korScore2 = 100;
		int mathScore2 = 90;
		int engScore2 = 80;
		int totalScore2 = korScore2 + mathScore2 + engScore2;
		double avgScore2 = totalScore2 / 3.0;
		System.out.println(totalScore2);
		System.out.println(avgScore2);
	}

}
