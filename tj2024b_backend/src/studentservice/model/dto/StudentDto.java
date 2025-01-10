package studentservice.model.dto;

public class StudentDto {
	private int sno;
	private String sname;
	private int kscore;
	private int escore;
	private int mscore;
	
	public StudentDto() {}
	public StudentDto(String sname, int kscore, int escore, int mscore) {
		this.sname = sname; this.kscore = kscore; this.escore = escore; this.mscore = mscore;
	}
	
	// getter
	public int getSno() { return this.sno; }
	public String getSname() { return this.sname; }
	public int getKscore() { return this.kscore; }
	public int getEscore() { return this.escore; }
	public int getMscore() { return this.mscore; }
	
	// setter
	public void setSno(int sno) { this.sno = sno; }
	public void setSname(String sname) { this.sname = sname; }
	public void setKscore(int kscore) { this.kscore = kscore; }
	public void setEscore(int escore) { this.escore = escore; }
	public void setMscore(int mscore) { this.mscore = mscore; }
	
	@Override
	public String toString() {
		return "StudentDto [sno=" + sno + ", sname=" + sname + ", kscore=" + kscore + 
				", escore=" + escore + ", mscore=" + mscore + "]";
	}
	
}
