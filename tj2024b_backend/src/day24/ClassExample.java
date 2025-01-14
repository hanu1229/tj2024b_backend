package day24;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExample {

	public static void main(String[] args) {
		System.out.println("-----------------------------------------------------");
		// [1] .getClass()
		String s = new String();
		Class c = s.getClass();
		// class java.lang.String
		System.out.println(c);
		System.out.println("-----------------------------------------------------");
		Integer i = 3;
		Class c1 = i.getClass();
		// class java.lang.Integer
		System.out.println(c1);
		System.out.println("-----------------------------------------------------");
		// [2] .Class
		Class c2 = String.class;
		// class java.lang.String
		System.out.println(c2);
		System.out.println("-----------------------------------------------------");
		// [3] Class.forName("클래스이름")
		try { Class.forName("java.lang.String"); } catch(ClassNotFoundException e) { System.out.println(e); }
		// [-] 
		try { Class.forName("com.mysql.cj.jdbc.Driver"); }
		catch(ClassNotFoundException e) { System.out.println(e); }
		
		// 클래스 정보(클래스 멤버 = 멤버변수/생성자/메소드)를 반환하는 함수
		// 모든 멤버변수 확인
		Field[] fields = c.getFields();
		for(int index = 0; index < fields.length; index++) {
			System.out.print((index + 1) + ". ");
			System.out.println(fields[index]);
		}
		System.out.println("-----------------------------------------------------");
		// 모든 생성자 확인
		Constructor[] constructors = c.getConstructors();
		for(int index = 0; index < constructors.length; index++) {
			System.out.print((index + 1) + ". ");
			System.out.println(constructors[index]);
		}
		System.out.println("-----------------------------------------------------");
		// 모든 메소드 확인
		Method[] methods = c.getMethods();
		for(int index = 0; index < methods.length; index++) {
			System.out.print((index + 1) + ". ");
			System.out.println(methods[index]);
		}
		System.out.println("-----------------------------------------------------");
	}

}
