package day13.example.model.dao;

import day13.example.model.dto.WaitingDto;

public class WaitingDao {
	// singleton start
	private static WaitingDao instance = new WaitingDao();
	private WaitingDao() { }
	public static WaitingDao getInstance() { return instance; }
	// singleton end
	
	private WaitingDto[] waitingDB = new WaitingDto[100];
	
	// 대기번호 처리(저장) 함수
	public boolean addWaiting(WaitingDto waitingDto) {
		for(int index = 0; index < waitingDB.length; index++) {
			if(waitingDB[index] == null) {
				waitingDB[index] = waitingDto;
				return true;
			}
		}
		return false;
	}
	
	// 대기번호 처리(출력) 함수
	public WaitingDto[] printWaiting() {
		return waitingDB;
	}
}
