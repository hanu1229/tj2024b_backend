package day03;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int v = 0;
		int count = 0;
		sc.nextLine();
		String str = sc.nextLine();
		String[] strArr = str.split(" ");
		v = sc.nextInt();
		for(int index = 0; index < strArr.length; index++) {
			if(v == Integer.parseInt(strArr[index])) {
				count++;
			}
		}
		System.out.println(count);
	}
}
