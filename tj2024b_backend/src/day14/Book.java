package day14;

public class Book {
	private String bookName;
	private String author;
	
	public Book() { }
	public Book(String bookName, String author) { 
		this.bookName = bookName;
		this.author = author;
	}
	
	// getter
	public String getBookName() { return this.bookName; }
	public String getAuthor() { return this.author; }
	
	// setter
	public void setBookName(String bookName) { this.bookName = bookName; }
	public void setAuthor(String author) { this.author = author; }
	
	public void showBookInfo() {
		System.out.println(bookName + ", " + author);
	}
}
