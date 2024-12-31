package day16;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = new StringTokenizer(br.readLine()).nextToken();
		str = str.toUpperCase();
		System.out.println(str);
		System.out.println((int)str.charAt(0));
		
		for(int index = 0; index < str.length(); index++) {
			
		}
	}
}