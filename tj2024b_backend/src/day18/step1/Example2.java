package day18.step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		
		// [1] 실행 예외 : 프로그램 실행 도중에 발생하는 예외
		try {			
			String str1 = "강호동";
			System.out.println(str1.length());
			String str2 = null;
			System.out.println(str2.length());
		} catch(NullPointerException e) {
			System.out.println("인스턴스가 존재하지 않습니다.");
			System.out.println(e);
		}
		
		// [2] 실행 예외
		try {
			String str3 = "100";
			String str4 = "1aa";
			int value1 = Integer.parseInt(str3);
			int value2 = Integer.parseInt(str4);			
		} catch(NumberFormatException e) {
			System.out.println("int타입으로 변환이 불가능합니다.");
			System.out.println(e);
		}
		
		// [3] 실행 예외
		try {			
			int[] intArray = {1, 2, 3};
			System.out.println(intArray[0]);
			System.out.println(intArray[3]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("존재하지 않는 인덱스입니다.");
			System.out.println(e);
		}
		
		// [4] 실행 예외
		Scanner scan = new Scanner(System.in);
		try {			
			System.out.print("정수 입력 : ");
			int value3 = scan.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("정수를 입력해주세요.");
			System.out.println(e);
		}
		
		// [5] 다중 try ~ catch
		try {
			Integer.parseInt("1aa");
			
			int[] intArray = {1, 2, 3};
			System.out.println(intArray[3]);
			
			String str = null;
			System.out.println(str.length());
			
		} catch(NumberFormatException e) {
			System.out.println(e);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch(NullPointerException e) {
			System.out.println(e);
		} finally {
			// 주로 안전하게 메모리를 초기화, 연결해제할 코드를 작성
			System.out.println("예외 여부 상관없이 무조선 실행되는 부분");
		}
		
	}

}
