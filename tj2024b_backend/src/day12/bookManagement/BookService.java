package day12.bookManagement;
import java.util.Scanner;

public class BookService {

	// 도서등록 함수
	public void addBook(Scanner scan, BookDto[] books) {
		boolean addState = false;
		System.out.println(">> 도서등록을 선택했습니다.");
		System.out.println(">> 도서 이름 : "); String BookName = scan.next();
		System.out.println(">> 도서 줄거리 : "); String BookSummary = scan.next();
		BookDto book = new BookDto(BookName, BookSummary);
		for(int index = 0; index < books.length; index++) {
			if(books[index] == null) {
				books[index] = book;
				addState = true;
				break;
			}
		}
		if(addState) {
			System.out.println(">> 도서등록 완료");
		} else {
			System.out.println(">> 도서등록 실패");
		}
	}
	
	// 도서목록 함수
	
	
	// 도서대여 함수
	public void hireBook(Scanner scan, BookDto[] books) {
		System.out.println(">> 도서대여를 선택하셨습니다.");
		
	}
}
