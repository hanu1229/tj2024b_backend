package day11;

// 게시물의 정보를 갖는 객체의 설계 클래스
public class BoardDto {
	private String title;
	private String content;
	private String writer;
	
	public BoardDto() { }
	public BoardDto(String title, String content, String writer) {
		this.title = title; this.content = content; this.writer = writer;
	}
	
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	public String getContent() { return this.content; }
	public void setContent(String content) { this.content = content; }
	public String getWriter() { return this.writer; }
	public void setWriter(String writer) { this.writer = writer; }
	
}
