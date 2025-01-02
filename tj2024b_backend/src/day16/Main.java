package day16;
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
		int N = Integer.parseInt(st.nextToken());
		int count = 0;
		
		for(int index = 0; index < N; index++) {
			String S = br.readLine();
			boolean[] visit = new boolean[26];
			boolean group = true;
			for(int j = 0; j < S.length(); j++) {
				char current = S.charAt(j);
				if(j > 0 && current != S.charAt(j - 1) && visit[current - 'a']) {
					group = false;
					break;
				}
				visit[current - 'a'] = true;
			}			
			if(group) {
				count++;
			}
		}
		System.out.println(count);
	}
}