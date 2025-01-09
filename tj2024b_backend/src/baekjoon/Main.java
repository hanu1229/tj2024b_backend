package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		String B = arr[0];
		int N = Integer.parseInt(arr[1]);
		long result = 0;
		for(int index = B.length()-1; index >= 0; index--) {
			char temp = B.charAt(index);
			if(temp - 'A' > 0 && temp - 'A' < N) {
				result = result + ((temp -'A' + 10) * (N));
			}
		}
	}

}
