package day14.example2.view;

import java.util.ArrayList;
import java.util.Scanner;

import day14.example2.controller.ClassController;
import day14.example2.model.dto.ClassDto;

public class ClassView {
	
	// + 싱글톤
	private ClassView() {}
	private static ClassView instance = new ClassView();
	public static ClassView getInstance() {
		return instance;
	}
	// - 싱글톤
	private Scanner scan = new Scanner(System.in);
	
	// 1. 메인페이지 표현 함수
	public void run() {
			
		while( true ) {
			System.out.println("===== 수업 페이지 =====");
			System.out.println("1.등록 2.출력 3.수정 4.삭제 5.종료");
			int choose = scan.nextInt();
			if( choose == 1 ) { create(); }
			else if( choose == 2 ) { read(); }
			else if( choose == 3 ) { update(); }
			else if( choose == 4 ) { delete(); }
			else if( choose == 5 ) {
				System.out.println("===== 수업 페이지 =====");
				break;
			} // if end
		} // w end
	} // f end
	
	// 2. 수업 등록 페이지 함수
	public void create() { System.out.println("== 등록 ==");
		// [1] 저장할 게시물 정보를 입력
		System.out.println("수업번호 입력 : ");		int code = scan.nextInt();
		System.out.println("수업명 입력 : ");		String name = scan.next();
		System.out.println("강사명 입력 : ");	String teacher = scan.next();
		// [2] 게시물 정보를 하나의 객체로 만들기
		ClassDto classDto = new ClassDto( code , name , teacher ); 
		// [3] 객체를 컨트롤러에게 전달 후 쓰기 결과 받기
		boolean result = ClassController.getInstance().create( classDto );
		// [4] 받은 결과로 메시지 출력
		if( result ) { System.out.println(">>> 등록 성공 <<<"); }
		else { System.out.println(">>> 등록 실패 <<<"); }
	} // f end
	
	// 3. 수업 출력 페이지 함수
	public void read() { System.out.println("== 출력 ==");
		// [1] 컨트롤에게 모든 수업 정보 요청
		ArrayList<ClassDto> result = ClassController.getInstance().read();
		// [2] 요청받은 모든 수업 정보 출력
		System.out.println("수업번호\t수업명\t강사명");
		for( int i = 0; i <= result.size() -1; i++ ) {
			ClassDto classs = result.get(i);
			System.out.printf("%d \t %s \t %s \n ",
					classs.getCode() , classs.getName() , classs.getTeacher() );
		} // for end
	} // f end
	
	// 4. 수업 수정 페이지 함수
	public void update() { System.out.println("== 수정 ==");
		// 수정할 정보 입력 받기
		System.out.println("== 수업번호를 잘 적어주세요. ==");
		System.out.println("수업번호 입력 : "); 	int uCode = scan.nextInt();
		System.out.println("수업명 입력 : ");		String name = scan.next();
		System.out.println("강사명 입력 : ");		String teacher = scan.next();
		// 입력받은 정보들을 하나의 객체로 만들기
		ClassDto classDto = new ClassDto( uCode , name , teacher );
		// 컨트롤러에게 수정할 수업번호 전달 후 결과 받기
		boolean result = ClassController.getInstance().update( classDto );
		// 결과에 따른 메시지 출력
		if( result ) { System.out.println("수정 완료"); }
		else { System.out.println("수정 실패"); }
	} // f end
	
	// 5. 수업 삭제 페이지 함수
	public void delete() { System.out.println("== 삭제 ==");
		// [1] 삭제할 수업번호 입력받기
		System.out.println("삭제할 수업번호를 입력해주세요. : "); int dCode = scan.nextInt();
		// [2] 삭제할 수업번호를 컨트롤에게 전달하고 처리결과 받기
		boolean result = ClassController.getInstance().delete( dCode );
		// [3] 결과 메시지 출력
		if( result ) { System.out.println("삭제 성공"); }
		else { System.out.println("삭제 실패"); }
	} // f end
	
} // c end
