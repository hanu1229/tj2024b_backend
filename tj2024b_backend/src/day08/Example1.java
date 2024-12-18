package day08;
import java.util.Scanner;

/*
	과제 : 식당 대기번호 발행 프로그램
	- 문법 : 변수, 입출력함수, 연산자, 제어문(조건문/반복문), 클래스(멤버변수)/객체, 배열
	- 전화번호, 인원수를 입력받아서 저장, 출력 구현
	- 명단 클래스 설계
	- 총 대기명단은 100개까지 가능하다.
*/

public class Example1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Waiting[] waiting = new Waiting[100];
		while(true) {
			System.out.println("====== 대기번호 발행 ======");
			System.out.print(">> 1. 등록 2. 확인 3. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println(">> 등록을 선택했습니다.");
				Waiting newWaiting = new Waiting();
				System.out.print(">> 전화번호 : ");
				newWaiting.phoneNumber = scan.next();
				System.out.print(">> 인원수 : ");
				newWaiting.headCount = scan.nextInt();
				for(int index = 0; index < waiting.length; index++) {
					if(waiting[index] == null) {
						waiting[index] = newWaiting;
						System.out.println(">> 대기번호가 발행됐습니다. " + index+1 + "번째입니다.");
						break;
					}
				}
			} else if(choose == 2) {
				System.out.println(">> 확인을 선택했습니다.");
				for(int index = 0; index < waiting.length; index++) {
					if(waiting[index] != null) {
						System.out.printf(">> 순번 : %d / 전화번호 : %s / 인원수 : %d\n", index+1, waiting[index].phoneNumber, waiting[index].headCount);
					}
				}
			} else {
				break;
			}
		}
		scan.close();
	}

}
