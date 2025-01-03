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
		String[][] result = new String[5][];
		String S = "";
		int count = 0;
		for(int index = 0; index < 5; index++) {
			String str = br.readLine();
			String[] arr = str.split("");
			result[index] = new String[arr.length];
			if(arr.length > count) { count = arr.length; }
			for(int j = 0; j < arr.length; j++) {
				result[index][j] = arr[j];
			}
		}
		// 단순히 result배열에 값이 잘 들어갔는지 확인
		for(int index = 0; index < result.length; index++) {			
			System.out.println(Arrays.toString(result[index]));
		}
		System.out.println("count : " + count);
		for(int index = 0; index < count; index++) {
			for(int j = 0; j < result.length; j++) {
				String[] temp = result[j];
				// if
				S += result[j][index];
			}
			System.out.println(S);
		}
		System.out.println(S);	
	}
}
