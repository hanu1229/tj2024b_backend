package day14.studentManagement.controller;

import java.util.ArrayList;

import day14.studentManagement.model.dto.StudentDto;
import day14.studentManagement.model.dao.StudentDao;
import day14.studentManagement.view.StudentView;

public class StudentController {

	// 싱글톤 s
	private StudentController() {}
	private static StudentController instance = new StudentController();
	
	public static StudentController getInstance() {
		return instance;
	}
	// 싱글톤 e
	
	// 1. 학생 등록 제어 메소드
	public Boolean creatStudent(StudentDto studentDto) {
		
		// StudentDao 중복검사 메소드의 리턴값을 받을 변수
		boolean check = StudentDao.getInstance().check(studentDto);
		boolean result = false;
		
		// 중복검사 통과 시 StudentDao 학생등록 메소드와 연동
		if(check == true) {
			result = StudentDao.getInstance().creatStudent(studentDto);
		}
		// 중복검사에서 걸리면 false 리턴
		return result;
	}
	
	// 2. 학생 출력 메소드
	public ArrayList<StudentDto> readStudnet() {
		
		ArrayList<StudentDto> result = StudentDao.getInstance().readStudnet();
		
		return result;
	}
	
	// 3. 학생 수정 메소드
	public Boolean updateStudnet(StudentDto studentDto , int updateCode) {
		boolean result = StudentDao.getInstance().updateStudnet(studentDto , updateCode);
		
		return result;
	}
	
	// 4. 학생 삭제 메소드
	public Boolean deleteStudent(int deleteCode) {
		
		boolean result = StudentDao.getInstance().deleteStudent(deleteCode);
		
		return result;
	}
	
}
