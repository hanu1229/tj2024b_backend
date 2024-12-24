package day12.bookManagement;

public class MemberDto {
	private static int code = 0;
	private int memberCode;
	private String name;
	private String id;
	private String pw;
	private boolean admin = false;
	
	MemberDto() { }
	MemberDto(String name, String id, String pw) {
		this.memberCode = ++code; this.name = name; this.id = id; this.pw = pw;
		if(this.id.equals("admin") && this.name.equals("admin")) {
			admin = true;
			System.out.println("====== 관리자 아이디 생성 완료 ======");
		}
	}
	
	// getter
	public int getMemberCode() { return this.memberCode; }
	public String getName() { return this.name; }
	public String getId() { return this.id; }
	public String getPw() { return this.pw; }
	public boolean getAdmin() { return this.admin; }
	
	// setter
	public void setMemberCode(int memberCode) { this.memberCode = memberCode; }
	public void setName(String name) { this.name = name; }
	public void setId(String id) { this.id = id; }
	public void setPw(String pw) { this.pw = pw; }

}
