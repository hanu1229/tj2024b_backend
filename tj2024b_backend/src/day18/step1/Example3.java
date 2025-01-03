package day18.step1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Example3 {
	
	// [1] 메소드 내부의 예외를 호출했던 곳으로 예외 떠넘기기
	public static Class loadClass(String fileName, String className)
	throws FileNotFoundException, ClassNotFoundException {
		// 예외 처리 방법 2가지 : 1. try ~ catch 2. throws
		FileInputStream fis = new FileInputStream(fileName);
		Class c = Class.forName(className);
		return c;
	}
	// [2] 메소드 내부 예외 던지기
	public static void method() {
		String str = null;		
		System.out.println(str.length());
	}
	
	
	// static : 프로그램이 실행될때 static 키워드가 존재하는 변수와 메소드는 메모리에 우선 할당되고 프로그램이 종료되면 사라진다.
	public static void main(String[] args) {
		// 1. 메소드 호출, 예외 처리 발생
		try {			
			loadClass("a.txt", "java.lang.String");
		}
		catch(ClassNotFoundException e) { System.out.println(e); }
		catch(FileNotFoundException e) { System.out.println(e); }
		catch(Exception e) { System.out.println(e); } 
		
		// 2. 메소드 호출
		try {			
			method();
		} catch(NullPointerException e) { System.out.println(e); }
	}
}
