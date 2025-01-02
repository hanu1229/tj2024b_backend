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
		ArrayList<String> strList = new ArrayList<>();
		for(int index = 0; index < N; index++) {
			st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			strList.add(S);
		}
		System.out.println(strList);
		// aaa
		for(int index = 0; index < strList.size(); index++) {
			String temp = strList.get(index);
			for(int count = 0; count < temp.length(); count++) {
				if(count < temp.length()) {
					if(temp.charAt(index) == temp.charAt(index+1)) {
						System.out.println("실행");
					}
				}
			}
		}
	}
}