package day14.studentManagement.model.dao;

import day14.studentManagement.model.dto.AcceptDto;

import java.util.ArrayList;


public class AcceptDao {
	// singleton start
	private static AcceptDao instance = new AcceptDao();
	private AcceptDao () { }
	public static AcceptDao getInstance() { return instance; }
	
	private ArrayList<AcceptDto> acceptDB = new ArrayList<>();
	
	// 수강등록 처리 함수
	public boolean createAccept(AcceptDto acceptDto) {
		if(acceptDto != null) {
			acceptDB.add(acceptDto);
			return true;
		} else {
			return false;
		}
	}
	// 수강출력 처리 함수
	public ArrayList<AcceptDto> readAccept() {
		return acceptDB;
	}
	
	// 수강수정 처리 함수
	public boolean updateAccept(int acceptIndex, int classCode) {
		if(acceptIndex > acceptDB.size()-1) {
			return false;
		} else {
			AcceptDto acceptDto = acceptDB.get(acceptIndex);
			acceptDto.setClassCode(classCode);
			for(int index = 0; index < acceptDB.size()-1; index++) {
				if(acceptDB.get(index).getClassCode() > acceptDB.get(index+1).getClassCode()) {
					AcceptDto temp = acceptDB.get(index);
					acceptDB.set(index, acceptDB.get(index+1));
					acceptDB.set(index+1, temp);
				}
			}
			return true;
		}
	}
	
	// 수강삭제 처리 함수
	public boolean deleteAccept(int classCode, int studentCode) {
		for(int index = 0; index < acceptDB.size(); index++) {
			AcceptDto acceptDto = acceptDB.get(index);
			if(acceptDto.getClassCode() == classCode &&
					acceptDto.getStudentCode() == studentCode) {
				acceptDB.remove(index);
				return true;
			}
		}
		return false;
	}
	
}
