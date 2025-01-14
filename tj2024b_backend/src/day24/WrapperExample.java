package day24;

public class WrapperExample {

	public static void main(String[] args) {
		
		// [1] 숫자 100을 저장하는 방법
		int value1 = 100;
		Integer value2 = 100;
		// [2] 3.14를 저장하는 방법
		double value3 = 3.14;
		Double value4 = 3.14;
		// 차이점 : 기본 VS 참조(멤버변수/생성자/메소드로 구성)
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		
		// [3] 오토박싱, 언박싱
		// 오토박싱 : 기본타입을 참조타입으로 변환
		// Integer = int
		Integer value5 = value1;
		// 언박싱 : 참조타입을 기본타입으로 변환
		// int = Integer
		int value6 = value2;
		System.out.println(value5);
		System.out.println(value6);
		
		// [4] 문자열 타입 --> 기본타입 변환
		int val1 = Integer.parseInt("100");
		double val2 = Double.parseDouble("3.14");
		float val3 = Float.parseFloat("3.14");
		byte val4 = Byte.parseByte("100");
		short val5 = Short.parseShort("100");
		long val6 = Long.parseLong("100");
		boolean val7 = Boolean.parseBoolean("true");
				
		// [5] 기본 타입 --> 문자열 변환
		String str1 = 100 + "";
		String str2 = String.valueOf(100);
		
		}
}
