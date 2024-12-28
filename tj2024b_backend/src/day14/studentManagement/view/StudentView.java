package day14.studentManagement.view;

import java.util.ArrayList;
import java.util.Scanner;

import day14.studentManagement.controller.StudentController;
import day14.studentManagement.model.dto.StudentDto;

public class StudentView {
	
	// 싱글톤 s
	private StudentView() {}
	
	private static StudentView instance = new StudentView();
	
	public static StudentView getInstance() {
		return instance;
	}
	// 싱글톤 e
	
	Scanner scan = new Scanner(System.in);
	
	// main
	public void run() {
		System.out.println("====== 학생 등록 페이지 ======");
		while(true) {
			System.out.print(">> 1. 학생등록 2. 학생출력 3. 학생수정 4. 학생삭제 5. 종료 : ");
			int choose = scan.nextInt();
			
			if(choose == 1) {
				creatStudent();
			}else if(choose == 2) {
				readStudnet();
			}else if(choose == 3) {
				updateStudnet();
			}else if(choose == 4) {
				deleteStudent();
			}else if(choose == 5) {
				System.out.println("====== 메인 페이지 ======");
				break;
			}
		}
	}
	
	// 1. 학생 등록 메소드
	public void creatStudent() {
		System.out.println(">> 학생등록 선택");
		
		System.out.print("> 학생명 : ");
		String name = scan.next();
		System.out.print("> 전화번호 : ");
		String phone = scan.next();
		System.out.print("> 학생번호 : ");
		int code = scan.nextInt();
		
		// 객체화
		StudentDto studentDto = new StudentDto(name,phone,code);
		
		// 리턴값을 받을 변수 선언
		Boolean result = StudentController.getInstance().creatStudent(studentDto);
		
		// 리턴값에 따른 결과 출력
		if(result) {
			System.out.println("> 학생 등록 성공");
		}else {
			System.out.println("> 학생 등록 실패");
		}
		
	}
	
	// 2. 학생 출력 메소드
	public void readStudnet() {
		System.out.println(">> 학생출력 선택");		
		
		// 리턴값을 받을 변수 선언 -> ArrayList 를 리턴값을로 받아야함으로 ArrayList 타입으로 선언
		ArrayList<StudentDto> result = StudentController.getInstance().readStudnet();
		
		// 리턴값 출력
		for(int i = 0; i < result.size() ; i++) {
			StudentDto studnetDto = result.get(i);
			System.out.println("> 학생명 : " + studnetDto.getName());
			System.out.println("> 전화번호 : "+ studnetDto.getPhone());
			System.out.println("> 학생번호 : " + studnetDto.getCode());
		}
	}
	
	// 3. 학생 수정 메소드
	public void updateStudnet() {
		System.out.println(">> 학생수정 선택");
		
	
		System.out.print("> 수정할 학생번호 : ");
		int updateCode = scan.nextInt();
		
		System.out.print("> 수정할 학생명 : ");
		String name = scan.next();
		System.out.print("> 수정할 전화번호 : ");
		String phone = scan.next();
		System.out.print("> 수정할 학생번호 : ");
		int code = scan.nextInt();
	
		// 객체화
		StudentDto studentDto = new StudentDto(name, phone, code);
		
		// 리턴값을 받을 변수 선언 -> 인수값 : 식별할 updateCode / 수정한 정보를 담은 객체 
		boolean result = StudentController.getInstance().updateStudnet(studentDto, updateCode);
		
		// 리턴값에 따른 결과 출력
		if(result) {
			System.out.println(">> 수정완료");
		}else{
			System.out.println(">> 수정실패");
		}

	}
	
	// 4. 학생 삭제
	public void deleteStudent() {
		System.out.println(">> 학생삭제 선택");
		
		System.out.print("> 삭제할 학생번호 : ");
		int deleteCode = scan.nextInt();
		
		// 리턴값을 받을 변수 선언 -> 인수값 : 식별할 deleteCode
		boolean result = StudentController.getInstance().deleteStudent(deleteCode);
		
		// 리턴값에 따른 결과 출력
		if(result) {
			System.out.println(">> 삭제성공");
		}else {
			System.out.println(">> 삭제실패");
		}
	}
	
}
