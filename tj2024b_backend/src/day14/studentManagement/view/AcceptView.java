package day14.studentManagement.view;

import day14.studentManagement.controller.AcceptController;
import day14.studentManagement.controller.StudentController;
import day14.studentManagement.model.dto.AcceptDto;
import day14.studentManagement.model.dto.StudentDto;

import java.util.ArrayList;
import java.util.Scanner;


public class AcceptView {
	// singleton start
	private static AcceptView instance = new AcceptView();
	private AcceptView() { }
	public static AcceptView getInstance() { return instance; }
	// singleton end
	
	Scanner scan = new Scanner(System.in);
	
	// 수강신청 페이지 출력 함수
	public void acceptPage() {
		System.out.println("====== 수강 등록 페이지 ======");
		while(true) {
			System.out.print(">> 1. 등록 2. 출력 3. 수정 4. 삭제 5. 종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) { createAccept(); }
			else if(choose == 2) { readAccept(); }
			else if(choose == 3) { updateAccept(); }
			else if(choose == 4) { deleteAccept(); }
			else if(choose == 5) {
				System.out.println("====== 메인 페이지 ======");
				break;
			}
		}
	}
	
	// 수강등록 함수
	public void createAccept() {
		System.out.print(">> 수업번호 : "); int classCode = scan.nextInt();
		System.out.print(">> 학생번호 : "); int studentCode = scan.nextInt();
		AcceptDto acceptDto = new AcceptDto(classCode, studentCode);
		boolean result = AcceptController.getInstance().createAccept(acceptDto);
		if(result) {
			System.out.println(">> 등록 성공");
		} else {
			System.out.println(">> 등록 실패");
		}
	}
	
	// 수강출력 함수
	public void readAccept() {
		ArrayList<AcceptDto> result = AcceptController.getInstance().readAccept();
		for(int index = 0; index < result.size(); index++) {
			AcceptDto acceptDto = result.get(index);
			System.out.printf(">> %d번째 : 수업번호 : %d 학생번호 : %d\n", index, acceptDto.getClassCode(), acceptDto.getStudentCode());
		}
	}
	
	// 수강수정 함수
	public void updateAccept() {
		System.out.print(">> 수정할 과목 인덱스 : "); int acceptIndex = scan.nextInt();
		System.out.print(">> 수정할 수업번호 : "); int classCode = scan.nextInt();
		boolean result = AcceptController.getInstance().updateAccept(acceptIndex, classCode);
		if(result) {
			System.out.println(">> 수정 성공");
		} else {
			System.out.println(">> 수정 실패");
		}
	}
	
	// 수강삭제 함수
	public void deleteAccept() {
		System.out.print(">> 수업번호 : "); int classCode = scan.nextInt();
		System.out.print(">> 학생번호 : "); int studentCode = scan.nextInt();
		boolean result = AcceptController.getInstance().deleteAccept(classCode, studentCode);
		if(result) {
			System.out.println(">> 삭제 성공");
		} else {
			System.out.println(">> 삭제 실패");
		}
	}
	
}
