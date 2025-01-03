package day18;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		int[][] position = new int[count][2];
		int[] area = new int[position.length-1];		
		// position 2차원 배열에 값 넣기
		for(int index = 0; index < count; index++) {
			st = new StringTokenizer(br.readLine());
			position[index][0] = Integer.parseInt(st.nextToken());
			position[index][1] = Integer.parseInt(st.nextToken());
		}
		// 겹치는 부분 찾기 position.length : 3
		for(int index = 0; index < position.length; index++) {
			if(index + 1 < position.length) {
				if(position[index][0] > position[index+1][0]) {
					
				} else if(position[index][0] < position[index+1][0]) {
					int width = position[index][0] + 10;
					if(width < position[index+1][0]) {
						
					}
				}
			}
		}
		
	}
}