package day18.step1;

import java.io.IOException;

public class Example1 {

	public static void main(String[] args) {
		// [1] 일반 예외 : 컴파일러 예외처리 검사, 자동으로 에디터에서 예외처리 하라고 경고가 뜸
		// Class.forName("패키지경로.클래스명") : 지정한 클래스를 로드 
		try {			
			Class.forName("java.lang.String");
			Class.forName("java.lang.String2");
		} catch(ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		// [2] 일반 예외
		// System.in.read() : 시스템으로부터 읽기 함수
		try {
			System.in.read();			
		} catch(IOException e) {
			System.out.println(e);
		}
	}
}
