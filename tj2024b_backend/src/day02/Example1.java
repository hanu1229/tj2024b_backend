// 현재 클래스가 위치한 패키지/폴더명
package day02;
/*
	1. .java파일 : 자바 코드를 작성할수 있는 확장자명
	2. .class파일 : 자바가 .java파일을 컴파일해서 만들어진 파일
		- 워크스페이스내 프로젝트내 bin폴더내 컴파일된 .class파일 확인
		- 개발자가(.java파일에서 class문번 작성)--> 컴파일 --> .class파일 생성
	3. main함수 : 쓰레드가 내장된 함수(진입점EntryPoint)
		- 쓰레드 : 번역된 코드를 읽어드리기 위한 실행 흐름
*/
public class Example1 {

	public static void main(String[] args) {
		final int MAX_NUM = 100;
		final int MIN_NUM;
		System.out.println("MAX_NUM : " + MAX_NUM);
		MIN_NUM = 0;
		System.out.println("MIN_NUM : " + MIN_NUM);
	}

}

