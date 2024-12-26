package day13.boardProgram8.model.dto;

// 서로 다른 클래스간의 데이터 이동시 사용되는 클래스
// 싱글톤 패턴을 하지 않는 이유 
//		: 각 게시물 정보를 저장할 목적이므로 서로 고유한 객체가 필요하다.
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
