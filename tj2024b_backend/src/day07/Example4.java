package day07;
import java.lang.Object;
import java.util.Arrays;
public class Example4 {

	public static void main(String[] args) {
		// [0] 배열 사용하기 전
		int studentID1; int studentID2; int studentID3; int studentID4; int studentID5;
		int studentID6; int studentID7; int studentID8; int studentID9; int studentID10;
		
		// [1] 배열 사용
		int[] studentIDs1 = new int[10];
		int[] studentIDs2 = new int[] {101, 102, 103}; 
		// 오류
		// int[] studentIDs3 = new int[3] {101, 102, 103};
		int[] studentIDs4 = {101, 102, 103};
		int[] studentIDs5;
		studentIDs5 = new int[] {101, 102, 103};
		
		// [3] 배열 사용하시
		int[] num = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int sum = 0;
		System.out.println(num);
		System.out.println(Arrays.toString(num));
		System.out.println(num[0]);
		System.out.println(num[3]);
		for(int index = 0; index < num.length; index++) {
			sum += num[index];
		}
		System.out.println(sum);
		// [4] 전체 배열길아와 유요한 요소 값
		double[] data = new double[5];
		data[0] = 10.0;
		data[1] = 20.0;
		data[2] = 30.0;
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

}