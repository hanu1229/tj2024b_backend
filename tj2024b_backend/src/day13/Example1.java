package day13;

public class Example1 {

	public static void main(String[] args) {
		Company myCompany1 = Company.getInstance();
		Company myCompany2 = Company.getInstance();
		System.out.println(myCompany1 == myCompany2);
		
		
		myCompany1.method();
		Company.getInstance().method();
	}

}
