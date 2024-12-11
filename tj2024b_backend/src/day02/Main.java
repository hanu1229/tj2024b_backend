package day02;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        short N = scan.nextShort();
        String type = "";
        for(int index = 0; index < N/4; index++) {
        	type += "long ";
        }
        type += "int";
        System.out.println(type);
        scan.close();
	}
}