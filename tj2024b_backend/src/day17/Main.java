package day17;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[9][9];
		int row = 0;
		int column = 0;
		int max = 0;
		// 입력받은 값을 배열에 저장
		for(int index = 0; index < 9; index++) {
			String str = br.readLine();
			String[] arr = str.split(" ");
			for(int j = 0; j < 9; j++) {
				board[index][j] = Integer.parseInt(arr[j]);
			}
		}
		// 최댓값 및 위치 구하기
		for(int index = 0; index < 9; index++) {
			int[] tempC = board[index];			
			for(int j = 0; j < 9; j++) {
				int tempR = tempC[j];
				if(tempR >= max) {
					max = tempR;
					column = index+1;
					row = j+1;
				}
			}
		}
		System.out.println(max);
		System.out.printf("%d %d", column, row);
	}
}