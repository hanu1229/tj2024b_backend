package day14.studentManagement.model.dto;

public class AcceptDto {
	private int classCode;
	private int studentCode;
	
	public AcceptDto() { }
	public AcceptDto(int classCode, int studentCode) {
		this.classCode = classCode;
		this.studentCode = studentCode;
	}
	
	// getter
	public int getClassCode() { return this.classCode; }
	public int getStudentCode() { return this.studentCode; }
	
	// setter
	public void setClassCode(int classCode) { this.classCode = classCode; }
	public void setStudentCode(int studentCode) { this.studentCode = studentCode; }
}
