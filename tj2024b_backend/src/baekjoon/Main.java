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
		int count = 0;
		//System.out.println(B);
		for(int index = B.length()-1; index >= 0; index--) {
			char temp = B.charAt(count);
			//System.out.println(">> temp : " + temp);
			if(temp - 'A' >= 0 && temp - 'A' < N) {
				int num = 1;
				for(int j = 0; j < index; j++) {
					num = num * N;
				}
				result = result + ((temp -'A' + 10) * num);
				count++;
				//System.out.println("result : " + result);
			} else if(temp -'0' >= 0 && temp - '0' < 10) {
				int num = 1;
				for(int j = 0; j < index; j++) {
					num = num * N;
				}
				result = result + ((temp - '0') * num);
				count++;
			}
		}
		
		// 테스트
		System.out.println(result);
	}
}
