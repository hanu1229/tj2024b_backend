package studentservice.view;

import java.util.ArrayList;
import java.util.Scanner;

import studentservice.controller.StudentController;
import studentservice.model.dto.StudentDto;

public class StudentView {
	// singleton start
	private static StudentView instance = new StudentView();
	private StudentView() {}
	public static StudentView getInstance() { return instance; }
	// singleton end
	
	private Scanner scan = new Scanner(System.in);
	
	/** 메인페이지 */
	public void run() {
		System.out.println("======== 메인 페이지 ========");
		while(true) {			
			System.out.print(">> 1.점수등록 2.전체점수조회 3.점수수정 4.점수삭제 5.종료 : ");
			int choose = scan.nextInt();
			if(choose == 1) { register(); }
			else if(choose == 2) { readAll(); }
			else if(choose == 3) { update(); }
			else if(choose == 4) { delete(); }
			else if(choose == 5) { System.out.println(">> 종료"); break; }
		}
	}
	
	/** 점수등록 페이지 */
	public void register() {
		System.out.println("======== 점수등록 페이지 ========");
		System.out.print(">> 학생이름 : "); String sname = scan.next();
		System.out.print(">> 국어점수 : "); int kscore = scan.nextInt();
		System.out.print(">> 영어점수 : "); int escore = scan.nextInt();
		System.out.print(">> 수학점수 : "); int mscore = scan.nextInt();
		StudentDto sd = new StudentDto(sname, kscore, escore, mscore);
		boolean result = StudentController.getInstance().register(sd);
		if(result) { System.out.println(">> 점수등록 성공"); }
		else { System.out.println(">> 점수등록 실패"); }
	}
	
	/** 전체점수조회 페이지 */
	public void readAll() {
		System.out.println("======== 전체점수조회 ========");
		ArrayList<StudentDto> result = StudentController.getInstance().readAll();
		System.out.println(">> 번호\t이름\t국어점수\t영어점수\t수학점수");
		for(int index = 0; index < result.size(); index++) {
			StudentDto sd = result.get(index);
			System.out.printf(">> %d\t%s\t%d\t%d\t%d\n",
					sd.getSno() ,sd.getSname(), sd.getKscore(), sd.getEscore(), sd.getMscore());
		}
		System.out.println("======== 전체점수조회 ========");
	}
	
	/** 점수수정 페이지 */
	public void update() {
		System.out.println("======== 점수수정 ========");
		System.out.print(">> 번호 : "); int sno = scan.nextInt();
		System.out.print(">> 국어점수 : "); int kscore = scan.nextInt();
		System.out.print(">> 영어점수 : "); int escore = scan.nextInt();
		System.out.print(">> 수학점수 : "); int mscore = scan.nextInt();
		StudentDto sd = new StudentDto();
		sd.setSno(sno); sd.setKscore(kscore); sd.setEscore(escore); sd.setMscore(mscore);
		boolean result = StudentController.getInstance().update(sd);
		if(result) { System.out.println(">> 수정 완료"); }
		else { System.out.println(">> 수정 실패"); }
	}
	
	/** 점수삭제 페이지 */
	public void delete() {
		System.out.println("======== 점수삭제 ========");
		System.out.print(">> 번호 : "); int sno = scan.nextInt();
		boolean result = StudentController.getInstance().delete(sno);
		if(result) { System.out.println(">> 삭제 성공"); }
		else { System.out.println(">> 삭제 실패"); }
	}
	
}
