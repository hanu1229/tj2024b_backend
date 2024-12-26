package day13.example.model.dto;

public class WaitingDto {
	private String phoneNumber;
	private int headCount;
	
	public WaitingDto() { }
	public WaitingDto(String phoneNumber, int headCount) { 
		this.phoneNumber = phoneNumber;
		this.headCount = headCount;
	}
	
	// getter
	public String getPhoneNumber() { return this.phoneNumber; }
	public int getHeadCount() {return this.headCount; }
	
	// setter
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public void setHeadCount(int headCount) { this.headCount = headCount; }
}
