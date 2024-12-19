package day09;
import java.util.Scanner;
/*
과제 : 식당 대기번호 발행 프로그램
- 문법 : 변수, 입출력함수, 연산자, 제어문(조건문/반복문), 클래스(멤버변수, 메소드)/객체, 배열
- 전화번호, 인원수를 입력받아서 저장, 출력 구현
- 명단 클래스 설계
- 총 대기명단은 100개까지 가능하다.
*/
public class Example1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		WaitingService ws = new WaitingService();
		Waiting[] waitingList = new Waiting[100];
		while(true) {
			System.out.println("====== 대기번호 ======");
			System.out.print(">> 1. 등록 2. 출력 3. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				ws.addWaiting(scan, waitingList);
			} else if(choose == 2) {
				ws.printWaiting(scan, waitingList);
			} else {
				System.out.print(">> 시스템을 종료합니다.");
				break;
			}
		}

	}

}
