package day04;

public class Example2 {

	public static void main(String[] args) {
		
		// [1] while
		int num = 1;
		int sum = 0;
		while(num <= 10) {
			sum += num;
			num++;
		}
		System.out.println("1부터 10까지의 함은 " + sum + "입니다.");
		
		// [2] while 무한루프
//		while(true) {
//			System.out.println("쇼핑몰 24시간 실행중!!!");
//		}
		
		// [3] do ~ while
		int num3 = 1;
		int sum3 = 0;
		do {
			sum3 += num3++;
		} while(num3 <= 10);
		System.out.println("1부터 10까지의 합 : " + sum3);
		
		// [4] 구구단중에서 2단만 출력
		int num1 = 2;
		int num2 = 1;
		// while문
		while(num2 < 10) {
			System.out.printf("%d X %d = %d\n", num1, num2, num1*num2);
			num2++;
		}
		// do ~ while문
		num2 = 1;
		do {
			System.out.printf("%d X %d = %d\n", num1, num2, num1*num2);
			num2++;
		} while(num2 < 10);
	}

}
