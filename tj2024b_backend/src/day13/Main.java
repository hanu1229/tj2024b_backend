package day13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int number = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		int[] N = new int[number];
		for(int index = 0; index < N.length; index++) {
			N[index] = index+1;
		}
		for(int index = 0; index < count; index++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			for(int k = i; k <= j; k++, j--) {
				int temp = N[k];
				N[k] = N[j];
				N[j] = temp;
			}
		}
		for(int index = 0; index < N.length; index++) {
			System.out.print(N[index] + " ");
		}
	}
}
