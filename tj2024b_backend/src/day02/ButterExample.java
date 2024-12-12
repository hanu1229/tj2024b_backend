package day02;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
public class ButterExample {
	public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        String[] arr = null;
        int count = Integer.parseInt(br.readLine());
        for(int index = 0; index < count; index++) {
        	str = br.readLine();
        	arr = str.split(" ");
        	//System.out.println("arr[0] : " + arr[0] + " / " + "arr[1] : " + arr[1]);
        	int num = (Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
        	//System.out.println(Integer.parseInt(arr[0]) + " / " + Integer.parseInt(arr[1]));
        	str = Integer.toString(num);
        	//System.out.println(str);
        	bw.write(str);
        }
        bw.flush();
        //scan.close();
	}
}


/*
    Scanner scan = new Scanner(System.in);
	while(scan.hasNextInt()) {
		int A = scan.nextInt(), B = scan.nextInt();
		System.out.println(A+B);
	}
	scan.close();
*/