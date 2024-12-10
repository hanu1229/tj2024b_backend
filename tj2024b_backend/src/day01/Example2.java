package day01;

public class Example2 {

	public static void main(String[] args) {
		// 자료형/타입/분류 : 데이터를 나누는 방법
		/*
		 	- 자바 기본 타입
		 			  [키워드]		[용량]	[저장범위]
		 	[논리]	: boolean		1바이트	true 혹은 false
		 	
		 	[문자]	: char			2바이트	유니코드(UTF-16), '문자', ex) 'A'
		 	
		 	[문자열]	: String		N바이트	문자열클래스, "문자열", ex) "ABC"
		 	
		 	[정수]	: byte			1바이트	-128 ~ 128-1
		 			: short			2바이트	-32,768 ~ 32,768-1
		 			: int			4바이트	-2,147,483,648 ~ 2,147,483,648-1
		 			: long			8바이트	-2^63 ~ 2^63-1 / 숫자 뒤에 L
		 			
		 	[실수]	: float			4바이트	소수점 8자리 표현	/ 숫자 뒤에 F
		 			: double		8바이트	소수점 17자리 표현
		 	
		 	타입을 여러가지 구분해서 범위에 맞게 사용하라고 하는 이유?
		 		메모리를 효율적이고 적절하게 선택하여 사용하기 위해서
		 */
		
		// 1. [논리] : boolean타입은 true와 false만 저장할 수 있다.
		boolean bool1 = true;
		// Type mismatch: cannot convert from int to boolean
		// boolean bool2 = 3;
		boolean bool3 = false;
		System.out.println("bool1 : " + bool1);
		System.out.println("bool3 : " + bool3);
		
		// 2. [문자] : char타입은 작은따옴표를 이용한 문자1개만 저장할 수 있다.
		char ch1 = 'A';
		// Invalid character constant
		// char ch2 = 'ABC';
		// Type mismatch: cannot convert from String to char
		// char ch2 = "ABC";
		System.out.println("ch1 : " + ch1);
		
		// 3. [문자열] : String클래스타입은 큰따옴표를 이용하여 문자여러개를 저장할 수 있다.
		// 참고로 기본타입은 아니다.
		String str1 = "ABC";
		// Invalid character constant
		// String str2 = 'ABC';
		System.out.println("str1 : " + str1);
		
		// 4-1. [정수-byte] : byte타입은 -128 ~ 127까지 저장이 가능하다.
		byte b1 = 100;
		// Type mismatch: cannot convert from int to byte (저장 범위를 벗어남)
		// byte b2 = 300;
		System.out.println("b1 : " + b1);
		
		// 4-2. [정수-short] : stort타입은 -32,768 ~ 32,768-1까지 저장이 가능하다.
		short s1 = 32767;
		// Type mismatch: cannot convert from int to short (저장 범위를 벗어남)
		// short s2 = 32768;
		System.out.println("s1 : " + s1);

		// 4-3. [정수-int] : int타입은 -2,147,483,648 ~ 2,147,483,648-1까지 저장이 가능하다.
		int i1 = 2147483647;
		// The literal 2147483648 of type int is out of range (저장 범위를 벗어남)
		// int i2 = 2147483648;
		System.out.println("i1 : " + i1);
		
		// 4-4. [정수-long] : long타입은 -2^63 ~ 2^63-1까지 저장이 가능하다.
		long lo1 = 3000000000L;
		System.out.println("lo1 : " + lo1);
		
		// 5-1. [실수-float] : float타입은 소수점 8자리까지 저장이 가능하다.
		float f1 = 0.123456789123456789F;
		System.out.println("f1 : " + f1);
		
		// 5-2. [실수-double] : double타입은 소수점 17자리까지 저장이 가능하다.
		double d1 = 0.123456789123456789;
		System.out.println("d1 : " + d1);
	}
}
