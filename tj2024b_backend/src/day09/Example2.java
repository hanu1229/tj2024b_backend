package day09;
import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberService ms = new MemberService();
		Member[] memberList = new Member[100];
		while(true) {
			System.out.println("====== 회원 서비스 ======");
			System.out.print(">> 1. 회원가입 2. 로그인 3. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				ms.addMember(scan, memberList);
			} else if(choose == 2) {
				ms.printMember(scan, memberList);
			} else {
				System.out.println(">> 프로그램을 종료합니다.");
				break;
			}
		}
		scan.close();
	}

}
