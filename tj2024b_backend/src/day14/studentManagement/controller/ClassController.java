package day14.example2.controller;

import java.util.ArrayList;

import day14.example2.model.dao.ClassDao;
import day14.example2.model.dto.ClassDto;

public class ClassController {
	
	// + 싱글톤
	private ClassController() {}
	private static ClassController instance = new ClassController();
	public static ClassController getInstance() {
		return instance;
	}
	// - 싱글톤
	
	// 1. 수업 등록 제어 함수
	public boolean create( ClassDto classDto ) {
		boolean result = ClassDao.getInstance().create( classDto );
		return result;
	} // f end
	
	// 2. 수업 출력 제어 함수
	public ArrayList<ClassDto> read(){
		// [1] DAO에게 처리결과 요청하고 받기
		ArrayList<ClassDto> result =  ClassDao.getInstance().read();
		// [2] 처리 결과를 VIEW에게 반환
		return result;
	} // f end
	
	// 3. 수업 수정 제어 함수
	public boolean update( ClassDto classDto ) {
		// 매개변수 받은 값을 DAO에게 전달 후 처리 결과 받기
		boolean result = ClassDao.getInstance().update( classDto );
		// VIEW에게 결과 반환
		return result;
	}
	
	// 4. 수업 삭제 제어 함수
	public boolean delete( int dCode ) {
		// [1] 매개변수 받은 값들을 DAO에게 전달하고 처리결과 받기
		boolean result = ClassDao.getInstance().delete( dCode );
		// [2] VIEW에게 결과 반환
		return result;
	} // f end
	
} // c end
