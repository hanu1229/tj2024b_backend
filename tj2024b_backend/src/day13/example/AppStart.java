package day13.example;
import day13.example.view.WaitingView;

/*
	자바 과제12 : (식당) 대기번호 발행 프로그램
		1. MVC패턴으로 패키지와 클래스를 구성
		2. AppStart 클래스, WaitingView 클래스, WaitingController 클래스, WaitingDao 클래스, WaitingDto 클래스
		3. 전화번호와 인원수를 입력받아 대기등록 기능 구축하기
		4. 현재 모든 대기명단을 출력하는 기능 구축하기
		
		제출 : 카카오톡방에 과제 코드가 존재하는 본인 git 상세주소 제출
*/

public class AppStart {

	public static void main(String[] args) {
		WaitingView.getInstance().index();
	}

}
