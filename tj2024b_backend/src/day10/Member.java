package day10;

public class Member {
	private String name;
	private String id;
	private String pw;
	
	public Member() { }
	public Member(String name, String id, String pw) {
		this.name = name; this.id = id; this.pw = pw;
		}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return this.id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getPW() {
		return this.pw;
	}
	public void setPW(String pw) {
		this.pw = pw;
	}
	
}
