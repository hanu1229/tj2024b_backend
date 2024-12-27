package day14.boardProgram9.model.dto;

public class BoardDto {
	private String title;
	private String content;
	private String writer;
	
	public BoardDto() { }
	public BoardDto(String title, String content, String writer) {
		this.title = title; 
		this.content = content; 
		this.writer = writer; 
	}
	
	// getter
	public String getTitle() { return this.title; }
	public String getContent() { return this.content; }
	public String getWriter() { return this.writer; }
	// setter
	public void setTitle(String title) { this.title = title; }
	public void setContent(String content) { this.content = content; }
	public void setWriter(String writer) { this.writer = writer; }
}
