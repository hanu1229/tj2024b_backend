package boardservice10.model.dto;

public class BoardDto {
	private int bno;
	private String btitle;
	private String bcontent;
	private int bview;
	private String bdate;
	private int mno;
	private int cno;
	// 작성자 회원번호가 아닌 작성자의 아이디		FK값을 이용하여 PK레코드의 정보를 얻기
	private String mid;
	// 카테고리 번호가 아닌 카테고리의 이름
	private String cname;
	
	public BoardDto() {}
	public BoardDto(int bno, String btitle, String bcontent, int bview, String bdate, int mno, int cno) {
		this.bno = bno;	this.btitle = btitle; this.bcontent = bcontent;
		this.bview = bview; this.bdate = bdate; this.mno = mno; this.cno = cno;
	}
	
	// getter
	public int getBno() {
		return bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public int getBview() {
		return bview;
	}
	public String getBdate() {
		return bdate;
	}
	public int getMno() {
		return mno;
	}
	public int getCno() {
		return cno;
	}
	public String getMid() {
		return mid;
	}
	public String getCname() {
		return cname;
	}
	
	// setter
	public void setBno(int bno) {
		this.bno = bno;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bview=" + bview
				+ ", bdate=" + bdate + ", mno=" + mno + ", cno=" + cno + "]";
	}
	
}
