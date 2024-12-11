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
		
		// [4] 증감연산자
		int num2 = 10;
		int value2;
		value2 = ++num2;
		System.out.println(value2);
		value2 = num2++;
		System.out.println(value2);
		value2 = --num2;
		System.out.println(value2);
		value2 = num2--;
		System.out.println(value2);
		
		int gameScore = 150;
		int lastScore = gameScore++;
		System.out.println(lastScore);
		
		int lastScore2 = gameScore--;
		System.out.println(lastScore2);
		
		int result1 = 3 + 3 * 2;
		System.out.println(result1);
		int x = 10; int y = x-- + 5 + --x;
		System.out.println(x);
		System.out.println(y);
		
		// [5] 비교연산자
		int myAge = 27;
		boolean value = (myAge > 25);
		System.out.println(value);
		
		// [6] 논리연산자
		int num1 = 10;
		int i = 2;
		boolean value3 = ((num1 = num1 + 10) < 10) && ((i = i + 2) < 10);
		System.out.println(value3);
		System.out.println(num1);
		System.out.println(i);
		
		value3 = ((num1 = num1 + 10) < 10) || ((i = i + 2) < 10);
		System.out.println(value3);
		System.out.println(num1);
		System.out.println(i);
		
		// [7] 대입연산자
		// 1분 복습
		// num += 1;
		// num1 *= num2'
		
		// [8] 조선 연산자
		int num3 = 5 > 3 ? 10 : 20;
		int fatherAge = 45;
		int motherAge = 47;
		
		char ch;
		ch = (fatherAge > motherAge) ? 'T' : 'F';
		System.out.println(ch);
	}

}
