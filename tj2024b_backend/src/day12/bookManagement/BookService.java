package day12.bookManagement;
import java.util.Scanner;

public class BookService {

	// 도서등록 함수
	public void addBook(Scanner scan, BookDto[] books) {
		boolean addState = false;
		System.out.println(">> 도서등록을 선택했습니다.");
		System.out.print(">> 도서 이름 : "); String bookName = scan.next();
		System.out.print(">> 도서 줄거리 : "); String bookSummary = scan.next();
		BookDto book = new BookDto(bookName, bookSummary);
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
	public void printBook(BookDto[] books) {
		System.out.println(">> 도서 목록을 선택했습니다.");
		System.out.println("====== 도서 목록 ======");
		for(int index = 0; index < books.length; index++) {
			if(books[index] != null) {
				System.out.printf(">> %s\n", books[index].getBookName());
			}
		}
		System.out.println("====== 도서 목록 ======");
	}
 	
	// 도서대여 함수
	public void rentalBook(Scanner scan, BookDto[] books, MemberDto member) {
		boolean rentalState = false;
		System.out.println(">> 도서대여를 선택하셨습니다.");
		System.out.print(">> 도서 번호 : "); int bookCode = scan.nextInt();
		for(int index = 0; index < books.length; index++) {
			if(books[index] != null && bookCode == books[index].getBookCode() && books[index].getBookCount() == 1) {
				int[] rentalList = member.getRentalList();
				for(int j = 0; j < rentalList.length; j++) {
					if(rentalList[index] == 0) {
						books[index].setBookCount(0);
						rentalList[index] = bookCode;
						rentalState = true;
						member.setRentalList(rentalList);
						break;
					}
				}
			}
		}
		if(rentalState) {
			System.out.println(">> 도서 대여 성공");
		} else {
			System.out.println(">> 도서 대여 실패");
		}
	}
	
	// 대여현황 함수
	public void rentalConfirm(MemberDto member, BookDto[] books) {
		int[] rentalList = member.getRentalList();
		int count = 1;
		System.out.println("====== 대여 현황 ======");
		for(int index = 0; index < rentalList.length; index++) {
			if(rentalList[index] != 0) {
				for(int j = 0; j < books.length; j++) {
					if(books[j] != null && books[j].getBookCode() == rentalList[index]) {						
						System.out.printf(">> %d. 도서번호 : %s / 도서이름 : %s\n", count, rentalList[index], books[j].getBookName());
						count++;
					}
				}
			}
		}
		System.out.println("====== 대여 현황 ======");
	}
	
	// 도서반납 함수
	public void returningBook(Scanner scan, MemberDto member, BookDto[] books) {
		boolean returnState = false;
		System.out.println(">> 도서반납을 선택했습니다.");
		System.out.println(">> 반납할 도서번호를 입력해주세요.");
		System.out.print(">> 도서번호 : "); int bookCode = scan.nextInt();
		int[] rentalList = member.getRentalList();
		for(int index = 0; index < rentalList.length; index++) {
			if(rentalList[index] == bookCode) {
				for(int j = 0; j < books.length; j++) {
					if(bookCode == books[j].getBookCode() && books[j].getBookCount() == 0) {						
						rentalList[index] = 0;
						books[j].setBookCount(1);
						returnState = true;
						break;
					}
				}
			}
		}
		if(returnState) {
			System.out.println(">> 반납 성공");
		} else {
			System.out.println(">> 반납 실패");
		}
	}
}
