package day16;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		for(int i = 1; i <= number; i++) {
			for(int j = 1; j <= number - i; j++) {			
				System.out.print(" ");
			}
			for(int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = number - 1; i >= 1; i--) {
			for(int j = 1; j <= number - i; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scan.close();
	}
}