package boardservice10.model.dto;

// Dto : 서로 다른 레이어(MVC패턴)들 간의 데이터를 이동하는 객체
// 주로 데이터베이스 테이블의 속성과 동일하다. + 커스텀 가능
// getter/setter 메소드 : private멤버변수를 다른 클래스에서 간접접근하기 위해서
// toString() 메소드 : 객체 호출시 
public class MemberDto {
	/** 회원번호 */
	private int mno;
	/** 아이디 */
	private String mid;
	/** 비밀번호 */
	private String mpwd;
	/** 이름 */
	private String mname;
	/** 전화번호 */
	private String mphone;
	/** 가입일 */
	private String mdate;
	
	/** 기본 생성자 (로그인, 아이디찾기, 비밀번호찾기) */
	public MemberDto() {}
	/** 생성자 */
	public MemberDto(int mno, String mid, String mpwd, 
			String mname, String mphone, String mdate) {
		super();
		this.mno = mno; this.mid = mid; this.mpwd = mpwd; 
		this.mphone = mphone; this.mdate = mdate;	
	}
	/** 회원가입 생성자 */
	public MemberDto(String mid, String mpwd, String mname, String mphone) {
		super();
		this.mid = mid; this.mpwd = mpwd; this.mname = mname; this.mphone = mphone;
	}
	
	// getter
	public int getMno() { return this.mno; }
	public String getMid() { return this.mid; }
	public String getMpwd() { return this.mpwd; }
	public String getMname() { return this.mname; }
	public String getMphone() { return this.mphone; }
	public String getMdate() { return this.mdate; }
	
	// setter
	public void setMno(int mno) { this.mno = mno; }
	public void setMid(String mid) { this.mid = mid; }
	public void setMpwd(String mpwd) { this.mpwd = mpwd; }
	public void setMname(String mname) { this.mname = mname; }
	public void setMphone(String mphone) { this.mphone = mphone; }
	public void setMdate(String mdate) { this.mdate = mdate; }
	
	// toString
	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + 
				", mname=" + mname + ", mphone=" + mphone + ", mdate=" + mdate + "]";
	}
	
}
