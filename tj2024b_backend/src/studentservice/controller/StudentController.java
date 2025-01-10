package studentservice.controller;

import java.util.ArrayList;

import studentservice.model.dao.StudentDao;
import studentservice.model.dto.StudentDto;

public class StudentController {
	// singleton start
	private static StudentController instance = new StudentController();
	private StudentController() {}
	public static StudentController getInstance() { return instance; }
	// singleton end
	
	/** 점수등록 페이지 제어 메소드 */
	public boolean register(StudentDto sd) {
		boolean result = StudentDao.getInstance().register(sd);
		return result;
	}
	
	/** 전체점수조회 페이지 제어 메소드 */
	public ArrayList<StudentDto> readAll() {
		ArrayList<StudentDto> result = StudentDao.getInstance().readAll();
		return result;
	}
	
	/** 점수수정 페이지 제어 메소드 */
	public boolean update(StudentDto sd) {
		boolean result = StudentDao.getInstance().update(sd);
		return result;
	}
	
	/** 점수삭제 페이지 제어 메소드*/
	public boolean delete(int sno) {
		boolean result = StudentDao.getInstance().delete(sno);
		return result;
	}
	
}
