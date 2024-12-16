package day06;

import java.util.Scanner;

public class test {
	/*
	실습 2 : (식당)대기번호 발행 프로그램
		- 문법  : 변수 / 입출력함수 / 연산자 / 제어문(조건문 / 반복문)
		- 전화번호 / 인원수 를 입력받아 저장/출력 구성
		- 총 대기명단 : 3개
		- 대기명단 1개당 전화번호 / 인원수 저장소 2개 필요
	*/
	public static void main(String[] args) {
		String 전화번호1 = null;
		String 인원수1 = null;
		String 전화번호2 = null;
		String 인원수2 = null;
		String 전화번호3 = null;
		String 인원수3 = null;
		
		int 대기번호 = 0;
		
		while(true) {
			System.out.println("===대기명단===");
			System.out.println(">> 1. 대기등록 2. 대기번호");
			
			Scanner scan = new Scanner(System.in);
			int 선택 = scan.nextInt();
			if(선택 == 1) {
				System.out.println("대기등록을 선택하셨습니다.");
				
				System.out.println("전화번호를 입력하시오.");
				String tel = scan.next();
				
				System.out.println("인원수를 입력하시오.");
				String people = scan.next();
				
				인원수1 = people;
				if(전화번호1 == null) {
					전화번호1 = tel;
					인원수1 = people;
				}else if(전화번호2 == null) {
					전화번호2 = tel;
					인원수2 = people;
				}else if(전화번호3 == null) {
					전화번호3 = tel;
					인원수3 = people;
				}else {
					System.out.println("대기자리가 없습니다.");
				}

			}else if(선택 == 2) {
				System.out.println("대기번호를 선택하셨습니다.");
				if(전화번호1 != null) {
					System.out.println(전화번호1 + "님의 대기번호 : " + ++대기번호 );
				}else if(전화번호2 != null) {
					System.out.println(전화번호2 + "님의 대기번호 : " + ++대기번호  );
				}else if(전화번호3 != null) {
					System.out.println(전화번호3 + " 님의 대기번호 : " + ++대기번호  );
				}
			}
			scan.close();
		}
	}
}
