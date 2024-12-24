package day12.boardProgram7;
import java.util.Scanner;

public class BoardProgram7 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// 공통으로 사용되는 저장소 변수
		MemberService ms = new MemberService();
		MemberDto[] members = new MemberDto[100];
		BoardService bs = new BoardService();
		BoardDto[] boards = new BoardDto[100];
		// 로그인 상태 확인
		String loginId = null;
		
		
		while(true) {
			System.out.println("====== 로그인 페이지 ======");
			System.out.print(">> 1. 회원가입 2. 로그인 3. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				ms.signUp(scan, members);
			} else if(choose == 2) {
				loginId = ms.login(scan, members);
				
				if(loginId != null) {
					while(true) {
						System.out.println("====== 게시물 페이지 ======");
						System.out.println(">> 1. 등록 2. 출력 3. 로그아웃 : ");
						int choose2 = scan.nextInt();
						if(choose2 == 1) {
							bs.boardAdd(scan, boards, loginId);
						} else if(choose2 == 2) {
							bs.boardPrint(boards);
						} else if(choose2 == 3) {
							loginId = null;
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
