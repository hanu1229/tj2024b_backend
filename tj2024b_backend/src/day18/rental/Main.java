package day18.rental;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("====== OO 렌트카 ======");
		while(true) {
			System.out.print("1. 회원가입 2. 로그인 3. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				
			} else if(choose == 2) {
				
			} else if(choose == 3) {
				System.out.println(">> 종료");
				break;
			}
		}
	}

}
