package day17;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N*2][M];
		int[][] result = new int[N][M];
		for(int index = 0; index < N*2; index++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				arr[index][j] = Integer.parseInt(temp[j]);
			}
		}
		for(int index = 0; index < N; index++) {
			for(int j = 0; j < M; j++) {
				if(index + N < N * 2 && index < N) {					
					result[index][j] = arr[index][j] + arr[index+N][j];
					if(j == M-1) {
						if(index == N-1) {
							System.out.print(result[index][j]);
						} else {							
							System.out.print(result[index][j] + "\n");
						}
					} else {
						System.out.print(result[index][j] + " ");
					}
				}
			}
		}
	}
}