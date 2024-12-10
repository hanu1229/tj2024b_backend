package day02;
import java.util.Scanner;

public class Example4 {

	public static void main(String[] args) {
		// [콘솔입력]
		// Scanner
		
		// 1. 입력 객체 만들기, 객체 생성방법 : new 클래스명(), 클래스명은 첫긍자를 대문자로 시작
		// Scanner클래스
		// new Scanner();
		// System.in 입력객체, Scanner객체를 생성시 입력객체를 인수로 전달한다.
		// new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		// 2. 입력 객체로부터 콘솔에서 키보드로부터 입력받은 데이터값을 가져오기 함수를 제공한다.
		
		// 2-1. 변수명.nextXXX();
		System.out.print(".next() 문자열 입력 : ");
		String str1 = scan.next();
		System.out.println("입력값 : " + str1 + "\n");
		
		// 2-2. 변수명.nextLine();
		// 주의할점 : 다른 nextXXX()를 사용한 후 남아있는 엔터값을 인식하여 출력한다.
		// 해결방안 : 의미없는 nextLine()을 사용하여 엔터값을 처리한다.
		scan.nextLine();
		System.out.print(".nextLine() 문자열 입력 : ");
		String str2 = scan.nextLine();
		System.out.println("입력값 : " + str2 + "\n");
		
		// 2-3. 변수명.nextInt();
		System.out.print("int 입력 값 : ");
		int intValue = scan.nextInt();
		System.out.println("int 출력 값 : " + intValue + "\n");
		
		// 2-4. 변수명.nextByte();
		System.out.print("byte 입력 값 : ");
		byte byteValue = scan.nextByte();
		System.out.println("byte 출력 값 : " + byteValue + "\n");
		
		// 2-5. 변수명.nextShort();
		System.out.print("short 입력 값 : ");
		short shortValue = scan.nextShort();
		System.out.println("short 출력 값 : " + shortValue + "\n");
		
		// 2-6. 변수명.nextLong();
		System.out.print("long 입력 값 : ");
		long longValue = scan.nextLong();
		System.out.println("long 출력 값 : " + longValue + "\n");
		
		// 2-7. 변수명.nextFloat();
		System.out.print("float 입력 값 : ");
		float floatValue = scan.nextFloat();
		System.out.println("float 출력 값 : " + floatValue + "\n");
		
		// 2-8. 변수명.nextDouble();
		System.out.print("double 입력 값 : ");
		double doubleValue = scan.nextDouble();
		System.out.println("double 출력 값 : " + doubleValue + "\n");
		
		// 2-9. 변수명.nextBoolean();
		System.out.print("boolean 입력 값 : ");
		boolean boolValue = scan.nextBoolean();
		System.out.println("boolean 출력 값 : " + boolValue + "\n");

		scan.close();
	}

}
