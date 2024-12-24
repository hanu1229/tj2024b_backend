package day12.bookManagement;

public class BookDto {
	private static int code = 0;
	private int bookCode;
	private String bookName;
	private String bookSummary;
	
	public BookDto() { }
	public BookDto(String bookName, String bookSummary) {
		this.bookCode = ++code; this.bookName = bookName; this.bookSummary = bookSummary;
	}
	
	// getter
	public int getBookCode() { return this.bookCode; }
	public String getBookName() { return this.bookName; }
	public String getBookSummary() {return this.bookSummary; }
	
	// setter
	public void setBookCode(int bookCode) { this.bookCode = bookCode; }
	public void setBookName(String bookName) { this.bookName = bookName; }
	public void setBookSummary(String bookSummary) { this.bookSummary = bookSummary; }
	
}
