package day02;

public class Example2 {

	public static void main(String[] args) {
		// 1. 자동형변환, 묵시적형변환
		// 메모리 크기가 작은크기에서부터 큰크기순으로 변환
		// 데이터 손실이 없음
		// byte -> short, char -> int -> long -> float -> double
		
		byte byteValue = 10;
		short shortValue = byteValue;
		int intValue = shortValue;
		long longValue = intValue;
		float floatValue = longValue;
		double doubleValue = floatValue;
		System.out.println("double Value : " + doubleValue);
		// + 연산중 묵시적 형변환
		// byte + byte => int
//		byte b1 = 10;
//		byte b2 = 20;
//		short s1 = 30;
//		int i1 = 40;
		float f1 = 3.14f;
		double d1 = 41.25;
//		int result1 = b1 + b2;
//		int result2 = b1 + s1;
//		float result3 = i1 + f1;
		double result4 = f1 + d1;
		System.out.println("result4 : " + result4);
		
		// 명시적 형변환
		// 메모리의 크기가 큰 순서부터 작은 순으로 변환
		// 데이터의 손실이 있을 수도 있다.
		// (변환할 타입)변수명
		double value1 = 3.14;
		float value2 = (float)value1;
		long value3 = (long)value2;
		int value4 = (int)value3;
		short value5 = (short)value4;
		byte value6 = (byte)value5;
		System.out.println("value6 : " + value6);
		
		char ch1 = 'A';
		int int1 = ch1;
		System.out.println(int1);
		System.out.println((int)ch1);
		int ch2 = 67;
		System.out.println((char)ch2);
		
		// 연산중에 강제 타입변환
		int result5 = (int)381.01 + 3;
		System.out.println(result5);
		
		// p.69 Q4
		byte v1 = 10;
		float v2 = 2.0f;
		int r1 = v1 + (int)v2;
		System.out.println("Q4 result : " + r1);
		
		// p.69 Q5
		char ch = 44544;
		System.out.println(ch);
		System.out.println((char)44545);
		System.out.println("" + (char)74 + (char)65 + (char)86 + (char)65);
		
	}
}
