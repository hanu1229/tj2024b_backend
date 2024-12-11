package day02;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hour = scan.nextInt();
        int min = scan.nextInt() - 45;
        if(min < 0) {
        	if(hour == 0) {
        		hour = 23;
        	} else {        		
        		hour--;
        	}
        	min += 60;
        }
        System.out.println(hour + " " + min);
	}
}
