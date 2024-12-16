// 현재 클래스가 위치한 패키지/폴더 명
package day06;
import java.util.Scanner;

/*
	실습1 : 게시판 프로그램
		- 제목, 내용, 작성자를 입력받아서 저장/출력/삭제/수정
		- 문법 : 변수, 입출력함수, 연산자, 제어문(조건문/반복문)
		- 게시물 3개를 저장하기 게시물 1개당 제목/내용/작성자가 필요
*/

// 자바의 모든 코드는 class안에 존재한다.
public class BoardProgram1 {

	// 자바의 모든 실행 코드는 main안에서 실행된다.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String title1 = null, content1 = null, writer1 = null;
		String title2 = null, content2 = null, writer2 = null;
		String title3 = null, content3 = null, writer3 = null;
		
		// 무한루프
		while(true) {
			System.out.println("===== 게시판 프로그램 =====");
			// Scanner scan = new Scanner(System.in);
			System.out.print("1.등록 2.출력 3.수정 4.삭제 : ");
			int selectMenu = scan.nextInt();
			if(selectMenu == 1) {
				System.out.println(">> 1. 등록 선택했습니다.");
				System.out.print("> 제목 : "); String title = scan.next();
				System.out.print("> 내용 : "); String content = scan.next();
				System.out.print("> 작성자 : "); String writer = scan.next();
				if(title1 == null) {					
					title1 = title; content1 = content; writer1 = writer;
				} else if(title2 == null) {
					title2 = title; content2 = content; writer2 = writer;
				} else if(title3 == null) {
					title3 = title; content3 = content; writer3 = writer;
				} else {
					System.out.println("\n** 등록 실패 : 게시물 작성공간이 부족합니다. **\n");
				}
				
			} else if(selectMenu == 2) {
				System.out.println(">> 2. 출력 선택했습니다.");
				if(title1 != null) {					
					System.out.printf("\n> 제목 : %s > 내용 : %s > 작성자 : %s\n",title1, content1, writer1);
				}
				if(title2 != null) {
					System.out.printf("> 제목 : %s > 내용 : %s > 작성자 : %s\n",title2, content2, writer2);
				}
				if(title3 != null) {
					System.out.printf("> 제목 : %s > 내용 : %s > 작성자 : %s\n\n",title3, content3, writer3);
				}
				
			} else if(selectMenu == 3) {
				System.out.println(">> 3. 수정 선택했습니다.");
				System.out.print("\n> 제목 : "); String title = scan.next();
				System.out.print("> 내용 : "); String content = scan.next();
				System.out.print("> 작성자 : "); String writer = scan.next();
				System.out.print("\n>> 수정할 게시물의 제목을 입력해주세요 : ");
				String str = scan.next();
				if(title1.equals(str)) {
					title1 = title; content1 = content; writer1 = writer;
					System.out.println("\n** 수정 성공 **\n");
				} else if(title2.equals(str)) {
					title2 = title; content2 = content; writer2 = writer;
					System.out.println("\n** 수정 성공 **\n");
				} else if(title3.equals(str)) {
					title3 = title; content3 = content; writer3 = writer;
					System.out.println("\n** 수정 성공 **\n");
				} else {
					System.out.println("\n** 수정 실패 : 없는 게시물입니다. **\n");
				}
				
			} else if(selectMenu == 4) {
				System.out.println(">> 4. 삭제 선택했습니다.\n");
				System.out.print("삭제할 게시물 제목을 입력해주세요 : ");
				String str = scan.next();
				if(title1.equals(str)) {					
					title1 = null; content1 = null; writer1 = null;
				} else if(title2.equals(str)) {
					title2 = null; content2 = null; writer1 = null;
				} else if(title3.equals(str)) {
					title3 = null; content3 = null; writer3 = null;
				} else {
					System.out.println("\n** 삭제 실패 : 없는 게시물입니다. **\n");
				}
				
			} else {
				scan.close();
				break;
			}
		}
		scan.close();
	}

}
