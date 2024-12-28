package day14.studentManagement.model.dto;

public class StudentDto {
	// 멤버변수
	private String name;
	private String phone;
	private int code;
	
	// 생성자
	public StudentDto() {}
	public StudentDto(String name, String phone, int code) {
		this.name = name;
		this.phone = phone;
		this.code = code;
	}
	
	
	// getter / setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
