package day06;
import java.util.Scanner;
/*
	자바 과제3 : (식당)대기번호 발행 프로그램
		- 문법 : 변수, 입출력함수, 연산자, 제어문(조건문/반복문)
		- 전화번호, 인원수를 입력받아서 저장/출력 구현
		- 총 대기명단은 3개까지 가능하다.
		- 대기명단 1개당 전화번호, 인원수 저장소(변수) 2개 필요, 대기명단3 --> 변수 6개 필요
*/

public class Example1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String pNumber1 = null, people1 = null;
		String pNumber2 = null, people2 = null;
		String pNumber3 = null, people3 = null;
		
		while(true) {
			System.out.println("===== 대기번호 =====");
			System.out.print("1(대기번호 저장), 2(대기번호 출력) : ");
			int number = scan.nextInt();
			if(number == 1) {
				System.out.println("=== 대기번호 저장 ===");
				System.out.print("> 전화번호 : "); String pNumber = scan.next();
				System.out.print("> 인원수 : "); String people = scan.next();
				if(pNumber1 == null) {
					pNumber1 = pNumber; people1 = people;
				} else if(pNumber2 == null) {
					pNumber2 = pNumber; people2 = people;
				} else if(pNumber3 == null) {
					pNumber3 = pNumber; people3 = people;
				} else {
					System.out.println("대기인원이 꽉찼습니다.\n");
				}
			} else if(number == 2) {
				System.out.println("=== 대기번호 출력 ===");
				if(pNumber1 != null) {
					System.out.printf("\n> 전화번호 : %s / 인원수 : %s\n", pNumber1, people1);
				}
				if(pNumber2 != null) {
					System.out.printf("> 전화번호 : %s / 인원수 : %s\n", pNumber2, people2);
				}
				if(pNumber3 != null) {
					System.out.printf("> 전화번호 : %s / 인원수 : %s\n\n", pNumber3, people3);
				}
			} else {
				break;
			}
		}
		scan.close();
	}
}
