package day04;

import java.util.Scanner;

public class Example3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum2 = 0;
		for(int i = 0; i <= 10; i++) {
			sum2 += i;
		}
		//System.out.println("1부터 10까지 합 : " + sum2);
		
		// p.114 [나 혼자 코딩]
		for(int i = 1; i <= 10; i++) {
			//System.out.println("안녕하세요" + i);
		}
		
		// [3] 구구단
		for(int i = 2; i <= 9; i++) { 
			for(int j = 1; j <= 9; j++) {
				//System.out.printf("%d X %d = %d\n", i, j, i * j);
			}
		}
		
		// [4] 1분 복습
		for(int i = 3; i <= 7; i++) {
			for(int j = 1; j <= 9; j ++) {
				//System.out.printf("%d X %d = %d\n", i, j, i * j);
			}
		}
		
		// [5] continue문
		int total = 0;
		for(int num = 1; num <= 100; num++) {
			if(num % 2 == 0) {
				continue;
			}
			total += num;
		}
		//System.out.println("1부터 100까지 홀수의 합 : " + total);
		
		// [6] p.120 1분 복습
		// [7] break문
		int sum3 = 0;
		for(int num = 0; ; num++) {
			sum3 += num;
			if(sum3 >= 0) {
				break;
			}
		}
		
		// [8] p.122 1분복습
		// [9] 연습문제
		// 1.
//		int num1 = 10;
//		int num2 = 2;
//		char operator = '*';
//		switch(operator) {
//			case '+':
//				System.out.println("+ : " + (num1 + num2));
//				break;
//			case '-':
//				System.out.println("- : " + (num1 - num2));
//				break;
//			case '*':
//				System.out.println("* : " + (num1 * num2));
//				break;
//			case '/':
//				System.out.println("/ : " + (num1 / num2));
//				break;
//		}
		// 2.
//		for(int i = 2; i <= 9; i++) {
//			for(int j = 1; j <= 9; j++) {
//				if(i % 2 != 0) {
//					continue;
//				}
//				System.out.printf("%d X %d = %d\n", i, j, i * j);
//			}
//		}
		// 3.
//		for(int i = 2; i <= 9; i++) {
//			for(int j = 1; j <= 9; j++) {
//				if(i < j) {
//					break;
//				}
//				System.out.printf("%d X %d = %d\n", i, j, i * j);
//			}
//		}
		// 4.
		//int value = sc.nextInt();
		int value = 4;
		for(int i = 0; i < value; i++) {
			
		}
		// 5.
	}
}
