package day07;
import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		Waiting waiting1 = null, waiting2 = null, waiting3 = null;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("====== 대기 번호 ======");
			System.out.print(">> 1. 대기번호 출력 2. 대기번호 확인 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println(">> 대기번호 출력을 선택했습니다.");
				System.out.print(">> 전화번호 : ");
				String phoneNumber = scan.next();
				System.out.print(">> 인원수 : ");
				int headCount = scan.nextInt();
				Waiting waiting = new Waiting();
				waiting.PhoneNumber = phoneNumber;
				waiting.headCount = headCount;
				if(waiting1 == null) {
					waiting1 = waiting;
					waiting1.number = ++count;
				} else if(waiting2 == null) {
					waiting2 = waiting;
					waiting2.number = ++count;
				} else if(waiting3 == null) {
					waiting3 = waiting;
					waiting3.number = ++count;
				} else {
					System.out.println(">> 더이상 대기가 불가능합니다.\n");
				}
			} else if(choose == 2) {
				System.out.println(">> 대기번호 확인을 선택했습니다.");
				if(waiting1 != null) {
					System.out.println();
					System.out.printf(">> 순번 : %d / 전화번호 : %s / 인원수 : %d\n", waiting1.number, waiting1.PhoneNumber, waiting1.headCount);
				}
				if(waiting2 != null) {
					System.out.printf(">> 순번 : %d / 전화번호 : %s / 인원수 : %d\n", waiting2.number, waiting2.PhoneNumber, waiting2.headCount);
				}
				if(waiting3 != null) {
					System.out.printf(">> 순번 : %d / 전화번호 : %s / 인원수 : %d\n", waiting3.number, waiting3.PhoneNumber, waiting3.headCount);
				}
				System.out.println();
			} else {
				break;
			}
		}
		scan.close();
	}
}
