package day02;

public class Example3 {

	public static void main(String[] args) {
		// [콘솔출력]
		/*
		 * System : 시스템에 관련된 기능을 제공하는 클래스
		 * out : 출력에 관련된 객체를 반환 VS in : 입력에 관련된 객체를 반환
		 * print() : 출력함수 / println() : 함수 끝에 개행문자추가
		 * .(접근 연산자) : 객체 또는 클래스내 속성/필드에 접근하는 연산자
		 */
		// 형식문자 : 주로 printf( )함수에서 사용되는 특별한 문자
		/*
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열
		 * [자릿수 맞추기]
		 * 	%+자릿수d : 자릿수만큼 차지, 만일 비어 있으면 공백처리, 오른쪽 정렬
		 *  %-자릿수d : 자릿수만큼 차지, 만일 비어 있으면 공백처리, 왼쪽 정렬
		 *  %0자릿수d : 자릿수만큼 차지, 공백 부분을 0으로 출력
		 * [소수점 자릿수 맞추기]
		 * %전체자리수.소수점자리수f : 전체자리수(소수점포함전체)만큼 자리수 차지,
		 * 						 소수점은 소수점자리까지 출력
		 */
		
		// 제어문자(이스케이프 문자) : 의미가 이미 부여된 문자
		/*
		 * \n : 줄바꿈
		 * \t : 들여쓰기
		 * \" : ", \' : '
		 * \\ : \
		 */
		// 1. println( ) : 인수값을 console에 출력 후 줄바꿈 처리하는 함수
		System.out.println("JAVA1");
		System.out.println("JAVA2");
		
		// 2. print( ) : 인수값을 console에 출력하는 함수
		System.out.print("JAVA3");
		System.out.print("JAVA4");
		
		// 3. printf("형식문자", 값1) : 인수값에 형식문자를 이용하여 수식을 출력하는 함수
		System.out.printf("\n%s\n", "JAVA5");
		String name = "유재석";
		int age = 40;
		System.out.printf("저는 %s이고 나이는 %d입니다.\n", name, age);
		System.out.println("저는 " + name + "이고 나이는 " + age + "입니다.");
		System.out.printf("저는 %s이고 나이는 %6d입니다.\n", name, age);
		System.out.printf("저는 %s이고 나이는 %-6d입니다.\n", name, age);
		System.out.printf("저는 %s이고 나이는 %06d입니다.\n", name, age);
		System.out.printf("저는 %s이고 신장은 %5.2f입니다.\n", name, 188.257);
		
		// 실습1 : 아래와같이 이스케이프를 이용하여 콘솔에 출력하시오.
		/*
		 
		 
		 
		 */
		System.out.println("|\\_/|");
		System.out.println("|q p|\t/}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"\t |");
		System.out.println("||_/=\\\\__|");
	}

}
