package day12;

class Student {
	public static int serialNum = 1000;
	private int studentID;
	private String studentName;
	private int grade;
	private String address;
	
	// getter
	public int getStudentID() { return studentID; }
	public String getStudentName() { return studentName; }
	public int getGrade() { return grade; }
	public String getAddress() { return address; }
	
	// setter
	public void setStudentID(int studentID) { this.studentID = studentID; }
	public void setStudentName(String studentName) { this.studentName = studentName; }
	public void setGrade(int grade) { this.grade = grade; }
	public void setAddress(String address) { this.address = address; }
	
}

class Student1 {
	private static int serialNum = 1000;
	private int studentID;
	private String studentName;
	private int grade;
	private String address;
	
	public Student1() {
		serialNum++;
		this.studentID = serialNum;
	}
	
	// getter
	public int getStudentID() { return studentID; }
	public String getStudentName() { return studentName; }
	public int getGrade() { return grade; }
	public String getAddress() { return address; }
	
	// setter
	public void setStudentID(int studentID) { this.studentID = studentID; }
	public void setStudentName(String studentName) { this.studentName = studentName; }
	public void setGrade(int grade) { this.grade = grade; }
	public void setAddress(String address) { this.address = address; }
	
}

class Student2 {
	private static int serialNum = 1000;
	private int studentID;
	private String studentName;
	private int grade;
	private String address;
	
	public Student2() {
		serialNum++;
		this.studentID = serialNum;
	}
	
	public static int getSerialNum() { return serialNum; }
	public static void setSerialNum(int serialNum) {
		Student2.serialNum = serialNum;
	}
	
	// getter
	public int getStudentID() { return studentID; }
	public String getStudentName() { return studentName; }
	public int getGrade() { return grade; }
	public String getAddress() { return address; }
	
	// setter
	public void setStudentID(int studentID) { this.studentID = studentID; }
	public void setStudentName(String studentName) { this.studentName = studentName; }
	public void setGrade(int grade) { this.grade = grade; }
	public void setAddress(String address) { this.address = address; }
}

public class Example3 {

	public static void main(String[] args) {
		Student studentLee = new Student();
		studentLee.setStudentName("이지원");
		System.out.println(Student.serialNum);
		Student.serialNum++;
		
		Student studentSon = new Student();
		studentSon.setStudentName("손수경");
		System.out.println(Student.serialNum);
		System.out.println(Student.serialNum);
		
		System.out.println(studentLee.getStudentName());
		System.out.println(studentSon.getStudentName());
		
		Student1 studentLee1 = new Student1();
		studentLee1.setStudentName("이지원");
		System.out.println(studentLee1.getStudentID());
		
		Student1 studentSon1 = new Student1();
		studentSon1.setStudentName("손수경");
		System.out.println(studentSon1.getStudentID());
		
		System.out.println(studentLee1.getStudentName() + " 학번 : " + studentLee1.getStudentID());
		System.out.println(studentSon1.getStudentName() + " 학번 : " + studentSon1.getStudentID());
		
		System.out.println(Student2.getSerialNum());
	}
}
