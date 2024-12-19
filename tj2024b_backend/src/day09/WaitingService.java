package day09;
import java.util.Scanner;

public class WaitingService {
	
	void addWaiting(Scanner scan, Waiting[] waitingList) {
		Waiting waiting = new Waiting();
		boolean saveState = false;
		System.out.println(">> 등록을 선택했습니다.");
		System.out.print(">> 전화번호(- 포함) : ");
		waiting.phoneNumber = scan.next();
		System.out.print(">> 인원수 : ");
		waiting.headCount = scan.nextInt();
		for(int index = 0; index < waitingList.length; index++) {
			if(waitingList[index] == null) {
				waitingList[index] = waiting;
				System.out.println(">> 등록이 완료 되었습니다. 순서는 " + (index+1) +"번입니다.");
				saveState = true;
				break;
			}
		}
		if(!saveState) {
			System.out.println(">> 등록에 실패했습니다.");
		}
	}
	
	void printWaiting(Scanner scan, Waiting[] waitingList) {
		boolean printState = false;
		System.out.println(">> 출력을 선택했습니다.");
		System.out.print(">> 전화번호(- 포함) : ");
		String phoneNumber = scan.next();
		for(int index = 0; index < waitingList.length; index++) {
			if(waitingList[index] != null && waitingList[index].phoneNumber.equals(phoneNumber)) {
				System.out.printf(">> %d번째 입니다.\n", index+1);
				printState = true;
				break;
			}
		}
		if(!printState) {
			System.out.println(">> 등록되지 않은 전화번호입니다.");
		}
	}
}
