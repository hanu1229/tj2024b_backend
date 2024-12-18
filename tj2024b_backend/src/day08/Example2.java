package day08;

public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10, num2 = 20;
		int sum = add(num1, num2);
		System.out.println(num1 + " + " + num2 + " = " + sum + "입니다.");
	}
	
	private static int add(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}
}
