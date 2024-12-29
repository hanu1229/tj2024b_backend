package day14.example2.model.dto;

public class ClassDto {
	
	// 1. 멤버변수
	private int code;
	private String name;
	private String teacher;
	
	// 2. 생성자
	public ClassDto() {}
	public ClassDto( int code, String name , String teacher ) {
		this.code = code;
		this.name = name;
		this.teacher = teacher;
	}
	
	// 3. 메소드
	public int getCode() { return this.code; }
	public String getName() { return this.name; }
	public String getTeacher() { return this.teacher; }
	public void setCode( int code ) { this.code = code; }
	public void setName( String name ) { this.name = name; }
	public void setTeacher( String teacher ) { this.teacher = teacher; }
	
} // c end
