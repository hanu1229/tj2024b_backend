package day14;
import java.util.ArrayList;

public class Example1 {

	public static void main(String[] args) {
		
		// [1] 배열은 고정길이
		String[] names = new String[3];
		// [2] 배열에 객체(요소) 대입
		names[0] = "유재석";
		names[1] = "강호동";
		names[2] = "신동엽";
		// [3] 배열내 요소 순회/조회
		for(int index = 0; index < names.length; index++) {
			System.out.println(">> " + names[index]);
		}
		// [4] 배열내 길이 이상의 요소 대입
		// 오류 : Index 3 out of bounds for length 3
		// names[3] = "하하";
		// [5] 배열내 중간 요소 삭제
		// 고정길이, 삭제 개념이 존재하지 않는다. null로 값을 비워두는 것일 뿐이다.
		// names[1] = null;
		
		// [1] ArrayList 클래스, 배열과 다르게 가변길이로 사용이 가능하다.
		ArrayList<String> nameList = new ArrayList<>();
		
		// [2] .add(요소) : 리스트에 요소 추가 함수.
		nameList.add("유재석");
		nameList.add("강호동");
		nameList.add("신동엽");
		
		// [3] .size() : 리스트의 요소의 총 개수
		// .get(인덱스) : 리스트에서 지정한 인덱스의 요소값을 반환하는 함수
		for(int index = 0; index < nameList.size(); index++) {
			System.out.println(nameList.get(index));
		}
		// [4] .add(요소)
		nameList.add("하하");
		// [5] .remove(인덱스) : 리스트에서 지정한 인덱스의 요소값을 삭제하는 함수
		nameList.remove(1);
		// [6] 확인
		System.out.println(nameList);
		
		// 실습 p.224
		ArrayList<Book> library = new ArrayList<>();
		
		library.add(new Book("태백산맥", "조정래"));
		library.add(new Book("데미안", "헤르만 헤세"));
		library.add(new Book("어떻게 살 것인가", "유시민"));
		library.add(new Book("토지", "박경리"));
		library.add(new Book("어린왕자", "생텍쥐페리"));
		
		for(int index = 0; index < library.size(); index++) {
			Book book = library.get(index);
			book.showBookInfo();
		}
		System.out.println();
		
		System.out.println("=== 향상된 for문 사용 ===");
		for(Book book : library) {
			book.showBookInfo();
		}
	}

}
