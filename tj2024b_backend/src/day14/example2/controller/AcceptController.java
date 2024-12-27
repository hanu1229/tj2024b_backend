package day14.example2.controller;

import java.util.ArrayList;

import day14.example2.model.dao.AcceptDao;
import day14.example2.model.dto.AcceptDto;

public class AcceptController {
	// singleton start
	private static AcceptController instance = new AcceptController();
	private AcceptController () { }
	public static AcceptController getInstance() { return instance; }
	// singleton end
	
	
	// 수강등록 제어 함수
	public boolean createAccept(AcceptDto acceptDto) {
		boolean result = AcceptDao.getInstance().createAccept(acceptDto);
		return result;
	}
	// 수강출력 제어 함수
	public ArrayList<AcceptDto> readAccept() {
		ArrayList<AcceptDto> result = AcceptDao.getInstance().readAccept();
		return result;
	}
	
	// 수강수정 제어 함수
	public boolean updateAccept(int acceptIndex, int classCode) {
		boolean result = AcceptDao.getInstance().updateAccept(acceptIndex, classCode);
		return result;
	}
	
	// 수강삭제 제어 함수
	public boolean deleteAccept(int classCode, int studentCode) {
		boolean result = AcceptDao.getInstance().deleteAccept(classCode, studentCode);
		return result;
	}
	
}
