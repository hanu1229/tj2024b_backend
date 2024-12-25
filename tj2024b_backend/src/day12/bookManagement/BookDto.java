package day12.bookManagement;

public class BookDto {
	private static int code = 0;
	private int bookCode;
	private String bookName;
	private String bookSummary;
	private int bookCount;
	
	public BookDto() { }
	public BookDto(String bookName, String bookSummary) {
		this.bookCode = ++code; this.bookName = bookName; this.bookSummary = bookSummary; this.bookCount = 1;
	}
	
	// getter
	public int getBookCode() { return this.bookCode; }
	public String getBookName() { return this.bookName; }
	public String getBookSummary() { return this.bookSummary; }
	public int getBookCount() { return this.bookCount; }
	
	// setter
	public void setBookCode(int bookCode) { this.bookCode = bookCode; }
	public void setBookName(String bookName) { this.bookName = bookName; }
	public void setBookSummary(String bookSummary) { this.bookSummary = bookSummary; }
	public void setBookCount(int bookCount) { this.bookCount = bookCount; }
	
}
