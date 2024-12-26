package day13.example.controller;

import day13.example.model.dao.WaitingDao;
import day13.example.model.dto.WaitingDto;

public class WaitingController {
	// singleton start
	private static WaitingController instance = new WaitingController();
	private WaitingController() { }
	public static WaitingController getInstance() { return instance; }
	// singleton end
	
	// 대기번호 등록 제어 함수
	public boolean addWaiting(WaitingDto waitingDto) {
		boolean result = WaitingDao.getInstance().addWaiting(waitingDto);
		return result;
	}
	
	// 대기번호 출력 제어 함수
	public WaitingDto[] printWaiting() {
		WaitingDto[] result = WaitingDao.getInstance().printWaiting();
		return result;
	}
}
