package day14.studentManagement.view;

//import day14.studentManagement.view.AcceptView;
import java.util.Scanner;

public class MainView {
	// singleton start
	private static MainView instance = new MainView();
	private MainView() { }
	public static MainView getInstance() { return instance; }
	// singleton end
	
	Scanner scan = new Scanner(System.in);
	
	// 메인페이지 함수
	public void run() {
		System.out.println("====== 메인 페이지 ======");
		while(true) {
			System.out.print(">> 1. 학생 2. 수업 3. 신청 4. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				StudentView.getInstance().run();
			} else if(choose == 2) {
				 ClassView.getInstance().run();
			} else if(choose == 3) {
				AcceptView.getInstance().acceptPage();
			} else if(choose == 4) {
				System.out.println(">> 프로그램 종료");
				break;
			}
		}
	}
}
