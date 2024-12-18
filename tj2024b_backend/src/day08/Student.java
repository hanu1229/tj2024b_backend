package day08;

public class Student {
	int studentID;
	String studentName;
	int grade;
	String address;
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public static void main(String[] args) {
		Student student = new Student();
		student.studentName = "안연수";
		Student student2 = new Student();
		student2.setStudentName("안승연");
		
		System.out.println(student.getStudentName());
		System.out.println(student2.getStudentName());
	}
}
