package day14.studentManagement.model.dao;

import java.awt.Checkbox;
import java.util.ArrayList;

import day14.studentManagement.controller.StudentController;
import day14.studentManagement.model.dto.StudentDto;

public class StudentDao {

	// 싱글톤 s
	private StudentDao() {}
	
	private static StudentDao instance = new StudentDao();
	
	public static StudentDao getInstance() {
		return instance;
	}
	// 싱글톤 e
	
	// ArrayList
	ArrayList<StudentDto> studentList = new ArrayList<StudentDto>();
	
	// 1. 학생 등록 처리 메소드
	public Boolean creatStudent(StudentDto studentDto) {
		studentList.add(studentDto);
		
		return true;
	}
	
	// 2. 학생 출력 처리 메소드
	public ArrayList<StudentDto> readStudnet() {
		return studentList;
	}
	
	// 3. 학생 수정 처리 메소드
	public Boolean updateStudnet(StudentDto studentDto, int updateCode) {
		
		for(int i = 0; i < studentList.size(); i++) {
			
			if(studentList.get(i).getCode() == updateCode) {
				studentList.set(i, studentDto);
				return true;
			}
		}
		return false;
	}
	
	// 4. 학생 삭제 처리 메소드
	public Boolean deleteStudent(int deleteCode) {
		
		for(int i = 0; i < studentList.size(); i++) {
		
			if(studentList.get(i).getCode() == deleteCode) {
				studentList.remove(i);
			
				return true;
			}
		}
		return false;
	}
	
	
	// 5. 중복검사 -> 학생번호 중복 시 학생 등록 불가 StudentController creatStudent() 메소드와 연동
	public Boolean check(StudentDto studnetDto){
		
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getCode() == studnetDto.getCode()) {
				return false;
			}
		}
		return true;
	}
	
}
