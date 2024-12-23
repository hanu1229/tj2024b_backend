package day11;

public class MemberDto {
	private int code;
	private String id;
	private String pw;
	private String name;
	
	public MemberDto() { }
	public MemberDto(int code, String id, String pw, String name) {
		this.id = id; this.pw = pw; this.name = name;
	}
	
	
	public int getCode() { return this.code; }
	public void setCode(int code) { this.code = code; }
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	public String getPw() { return this.pw; }
	public void setPw(String pw) { this.pw = pw; }
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
}
