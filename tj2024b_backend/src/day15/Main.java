package day15;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
		int total = 0;
		String[] arr = new String[count];
		arr = N.split("");
		for(int index = 0; index < arr.length; index++) {
			total += Integer.parseInt(arr[index]);
		}
		System.out.println(total);
	}
}
