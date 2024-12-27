package day14.example2.view;
import day14.example2.view.AcceptView;
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
			System.out.print(">> 1. 학생 2. 수업 3. 신청 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				
			} else if(choose == 2) {
				
			} else if(choose == 3) {
				AcceptView.getInstance().acceptPage();
			}
		}
	}
}
