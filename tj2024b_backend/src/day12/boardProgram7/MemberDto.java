package day12.boardProgram7;

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	
	public MemberDto() { }
	public MemberDto(String id, String pw, String name) {
		this.id = id; this.pw = pw; this.name = name;
	}
	
	public String getId() { return this.id; }
	public String getPw() { return this.pw; }
	public String getName() { return this.name; }
	public void setId(String id) { this.id = id; }
	public void setPw(String pw) { this.pw = pw; }
	public void setName(String name) { this.name = name; }
}
