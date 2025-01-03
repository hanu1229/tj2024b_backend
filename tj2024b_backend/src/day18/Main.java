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
		
		for(int index = 0; index < count; index++) {
			st = new StringTokenizer(br.readLine());
			position[index][0] = Integer.parseInt(st.nextToken());
			position[index][1] = Integer.parseInt(st.nextToken());
		}
	}
}