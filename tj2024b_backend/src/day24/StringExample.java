package day24;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StringExample {

	public static void main(String[] args) {
		
		// [1] 변수 2개, 자료(값) 1개
		// 리터럴 : 키보드로부터 입력받은 자료, 상수풀(이미 저장된 값)
		// 즉, 서로 다은 두 변수는 같은 자료를 참조한다.
		int a = 3;
		int b = 3;
		
		// [2] 변수 2개, 자료(값) 1개
		// 즉, c가 참조하는 5를 d에 대입했다. 그러므로 c와d는 같은 자료를 참조한다.
		int c = 5;
		int d = c;
		
		// [3] 변수 2개, 자료(값) 2개 : 순수한 자료 3, 포장된 인스턴스 3
		// 순수한 자료의 리터럴
		Integer value1 = 3;
		// 취소선 : 권장하지 않음을 뜻한다. (무시 가능)
		// 순수한 자료의 리터럴이 저장된 타입(포장/wrapper)
		Integer value2 = new Integer(3);
		// false / 단순히 리터럴값을 비교
		System.out.println(value1 == value2);
		// true / 인스턴스 안에 있는 값을 비교
		System.out.println(value1.equals(value2));
		System.out.println("-------------------------");
		// [4]
		// 1. 배열을 이용한 문자열 표현
		char[] str1 = new char[] {'유', '재', '석'};
		// 2. "" 리터럴을 이용한 문자열
		String str2 = "유재석";
		// 3. 생성자를 이용한 문자열
		String str3 = new String("유재석");
		System.out.println(str2 == str3);
		System.out.println(str2.equals(str3));
		String str4 = "유재석";
		System.out.println(str2 == str4);
		System.out.println(str2.equals(str4));
		System.out.println("-------------------------");
		
		// [5] String 주요 메소드
		// 1. "문자열1".concat("문자열2");
		String str5 = "자바".concat("프로그래밍");
		System.out.println("str5 : " + str5);
		// 2. StringBuilder 객체명 = new StringBuilder(); 객체명.append("문자열");
		StringBuilder builder = new StringBuilder();
		builder.append("자바");
		builder.append("프로그래밍");
		System.out.println("builder : " + builder);
		// String.format("형식문자", 값);
		String str6 = String.format("%s %s", "자바", "프로그래밍");
		System.out.println("str6 : " + str6);
		// String 변수명 = ""; 변수명 += "문자열";
		String str7 = "";
		str7 += "자바"; str7 += "프로그래밍";
		System.out.println("str7 : " + str7);
		// .charAt(인덱스);
		char gender = "012345-1230123".charAt(7);
		System.out.println("gender : " + gender);
		// [활용] .nextChar()가 없는 이유 : .next().charAt(0)을 사용하면 되기 때문이다.
		//Scanner scan = new Scanner(System.in);
		// 입력받은 문자열의 첫글자를 추출
		//char ch = scan.next().charAt(0);
		// .length();
		System.out.println("012345-1230123".length());
		
		// .replace(기존 문자열, 새로운 문자열);
		String str8 = "자바프로그래밍".replace("자바", "JAVA");
		System.out.println("str8 : " + str8);
		String htmlData = "유재석<br/>안녕하세요.";
		System.out.println("htmlData : " + htmlData);
		String javaData = htmlData.replace("<br/>", "\n");
		System.out.println("javaData : " + javaData);
		
		// .substring(시작인덱스, [끝인덱스])
		// 시작인덱스에서 끝인덱스까지만 추출
		String str9 = "012345-1230123".substring(0, 6);
		System.out.println("str9 : " + str9);
		// .substring(시작인덱스)
		// 시작인덱스만 작성하면 시작인덱스부터 끝까지 추출
		String str10 = "012345-1230123".substring(7);
		System.out.println("str10 : " + str10);
		
		// .split("구분문자") : 구분문자 기준으로 분해한 여러 문자열을 배열로 반환하는 함수
		// [활용] 공공데이터 SCV 파일을 다룰때 사용
		String[] str11 = "012345-1230123".split("-");
		System.out.println("str11[0] : " + str11[0]);
		System.out.println("str11[1] : " + str11[1]);
		
		// .indexOf("찾을문자열");
		int findIndex = "자바 프로그래밍 언어".indexOf("프로그래밍");
		System.out.println("findIndex : " + findIndex);
		
		// .contains("찾을문자열");
		boolean findBool = "자바 프로그래밍 언어".contains("자바");
		System.out.println("findBool : " + findBool);
		
		// .getBytes();
		byte[] str12 = "JAVA PROGRAM".getBytes();
		System.out.println(Arrays.toString(str12));
		// 영문/일부특수문자 : 문자1개당 1바이트(아스키코드)
		System.out.println("ab".getBytes().length);
		// 한글 : 문자1개당 2바이트(유니코드) + 1바이트(UTF-8 규칙정보) => 3바이트
		System.out.println("가나".getBytes().length);
		// char 2바이트 표현 short +-32,000개 --> short unsigned 65,536개
		// --> char 유니코드로 된 문자 1개 표현
		// [활용] : 인증코드만들기
		//int val1 = 65; int val2 = 66; int val3 = 67;
		//String code = ((char)val1) + ((char)val2) + ((char)val3);
		//System.out.println("code : " + code);
		String code = "";
		for(int index = 1; index <= 6; index++) {
			// 97을 더하는 이유 : 97이 아스키코드로 'a'
			// new Random(); : 랜덤(난수) 관련 클래스
			// new Random().nextInt(); : int타입의 난수를 반환
			// new Random().nextInt(26); : 0 ~ 25 사이의 난수를 반환하는 함수
			// new Random().nextInt(26) + 97; : 97 ~ 122 사이의 난수를 반환하는 함수
			// (char)(new Random().nextInt(26) + 97); : 
			System.out.println(new Random());
			System.out.println(new Random().nextInt());
			System.out.println(new Random().nextInt(26));
			System.out.println(new Random().nextInt(26) + 97);
			code += (char)(new Random().nextInt(26) + 97);
		}
		System.out.println(code);
		
		
		
	}

}
