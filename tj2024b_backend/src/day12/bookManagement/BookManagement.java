package day12.bookManagement;
import java.util.Scanner;

public class BookManagement {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BookService bs = new BookService();
		BookDto[] books = new BookDto[100];
		MemberService ms = new MemberService();
		MemberDto[] members = new MemberDto[100];
		MemberDto member = null;
		
		System.out.println("====== 도서관리 프로그램 ======");
		while(true) {
			System.out.print(">> 1. 회원가입 2. 로그인 3. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				ms.addMember(scan, members);
			} else if(choose == 2) {
				member = ms.login(scan, members);
				if(member != null && member.getAdmin() == true) {
					System.out.println("====== 대여 프로그램 ======");
					while(true) {
						System.out.print(">> 1. 도서등록 2. 도서목록 3. 로그아웃 : ");
						int choose2 = scan.nextInt();
						if(choose2 == 1) {
							
						} else if(choose2 == 2) {
							
						} else if(choose2 == 3) {
							System.out.println(">> 로그아웃합니다.");
							System.out.println("====== 도서관리 프로그램 ======");
							break;
						}
					}
				} else if(member != null && member.getAdmin() == false) {
					System.out.println("====== 대여 프로그램 ======");
					while(true) {
						System.out.print(">> 1. 도서대여 2. 도서반납 3. 대여현황 4. 로그아웃 : ");
						int choose3 = scan.nextInt();
						if(choose3 == 1) {
							
						} else if(choose3 == 2) {
							
						} else if(choose3 == 3) {
							
						} else if(choose3 == 4) {
							System.out.println(">> 로그아웃합니다.");
							System.out.println("====== 도서관리 프로그램 ======");
							break;
						}
					}
				}
			} else {
				System.out.println(">> 프로그램을 종료합니다.");
				break;
			}
		}
		scan.close();
	}

}
