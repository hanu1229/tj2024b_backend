package day19;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String N = st.nextToken().toUpperCase();
		long B = Integer.parseInt(st.nextToken());
		long result = 1;
		for(int index = N.length() - 1 ; index >= 0 ; index--) {
			char temp = N.charAt(0);
			if('A' <= temp && 'Z' >= temp) {
				result = (temp - 'A' + 11) * result;
			} else {
				result = (temp -'0') * result;
			}
		}
		result = result - 1;
		System.out.println(result);
	}
}