package day10;

public class BoardDTO {
	//DTO(DataTransferObjcet) : 데이터 이동 객체
	// 목적 : 여러 사람들이 작업할때 클래스명에 공통적으로 DTO를 명시함으로써 클래스의 사용처를 파악하기 쉽다.
	// 추후 : DTO, VO, DAO, controller, service, view, entity
	// DTO : 데이터베이스(DB)에 저장된 자료들을 자바로 이동할때 사용되는 객체
	// 관례적으로 모든 멤버변수는 private, 디폴트 생성자 + 풀매개변수 생성자, setter/getter메소드, 
	// toString메소드 : 객체주소값 대신 객체멤버변수를 반환하는 함수 
	
	// 멤버변수 private
	private String title;
	private String content;
	private String writer;
	// 생성자 : 디폴트, 풀매개변수
	BoardDTO() {}
	BoardDTO(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	// 메소드 : 멤버변수마다 getter/setter, toString
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "BoardDTO [title = " + title + ", content = " + content + ", writer = " + writer + "]";
	}
}
