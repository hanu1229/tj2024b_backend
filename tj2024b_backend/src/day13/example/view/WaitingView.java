package day13.example.view;
import day13.example.controller.WaitingController;
import day13.example.model.dto.WaitingDto;
import java.util.Scanner;

public class WaitingView {
	// singleton start
	private static WaitingView instance = new WaitingView();
	private WaitingView() { }
	public static WaitingView getInstance() { return instance; }
	// singleton end
	
	Scanner scan = new Scanner(System.in);
	
	// 화면 출력 함수
	public void index() {
		System.out.println("====== 대기번호 발행 프로그램 ======");
		while(true) {			
			System.out.print(">> 1. 등록 2. 확인 3. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				addWaiting();
			} else if(choose == 2) {
				printWaiting();
			} else if(choose == 3) {
				System.out.println(">> 프로그램 종료");
				break;
			}
		}
	}
	
	
	// 대기번호 등록 함수
	public void addWaiting() {
		System.out.println(">> 등록을 선택했습니다.");
		System.out.print(">> 전화번호 : "); String phoneNumber = scan.next();
		System.out.print(">> 인원수 : "); int headCount = scan.nextInt();
		WaitingDto waitingDto = new WaitingDto(phoneNumber, headCount);
		boolean result = WaitingController.getInstance().addWaiting(waitingDto);
		if(result == true) {
			System.out.println(">> 등록 성공");
		} else {
			System.out.println(">> 등록 실패");
		}
	}
	
	// 대기번호 출력 함수
	public void printWaiting() {
		System.out.println(">> 출력을 선택했습니다.");
		WaitingDto[] waitingDto = WaitingController.getInstance().printWaiting();
		for(int index = 0; index < waitingDto.length; index++) {
			if(waitingDto[index] != null) {				
				System.out.printf(">> 대기번호 : %d / 전화번호 : %s / 인원수 : %d\n",
						index + 1,
						waitingDto[index].getPhoneNumber(),
						waitingDto[index].getHeadCount()
						);
			}
		}
	}
}
