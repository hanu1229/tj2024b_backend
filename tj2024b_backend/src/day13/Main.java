package day13;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int high;
		double total = 0;
		st = new StringTokenizer(br.readLine());
		for(int index = 0; index < arr.length; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}
		// N = 3;
		for(int index = 1; index < N; index++) {
			if(arr[index-1] > arr[index]) {
				int temp = arr[index-1];
				arr[index-1] = arr[index];
				arr[index] = temp;
			}
		}
		high = arr[arr.length-1];
		for(int index = 0; index < arr.length; index++) {
			total += ((double)arr[index] / high) * 100;
		}
		System.out.println(total/N);
	}
}
