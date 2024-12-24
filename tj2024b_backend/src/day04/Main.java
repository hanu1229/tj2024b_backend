package day04;
import java.util.Arrays;
//import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		int count = 0;
		// 39, 40, 41, 0, 1, 2, 40, 41, 0, 1
		for(int index = 0; index < 10; index++) {
			st = new StringTokenizer(br.readLine());
			arr1[index] = Integer.parseInt(st.nextToken());
			arr2[index] = arr1[index] % 42;
			for(int j = 0; j < 10; j++) {
				if(arr2[index] == arr2[j]) {
					count++;
					break;
				}
			}
		}
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr2));
		System.out.println("count : " + count);
	}
}