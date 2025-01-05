package day18;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		int[][] position = new int[count][2];
		int[] area = new int[position.length];
		int width = 10; int height = 10;
		int total = 0;
		// position 2차원 배열에 값 넣기
		for(int index = 0; index < count; index++) {
			st = new StringTokenizer(br.readLine());
			position[index][0] = Integer.parseInt(st.nextToken());
			position[index][1] = Integer.parseInt(st.nextToken());
			if(index == 0) {
				area[index] = width * height;
			} else {
				for(int j = 0; j < index; j++) {
					if(position[index][0] > position[j][0]) {
						// 
						if(position[index][0] >= position[j][0] + width) {
							area[index] = width * height;
						} else {
							// 새로 놓은 색종이의 X좌표를 넘어설 경우 실행
							int overlapX = (position[j][0] + width) - position[index][0];
							// Y좌표가 겹치는지 확인
							if(position[index][1] >= position[j][1]) {
								// 새로운 색종이의 Y좌표가 이전 색종이의 Y좌표보다 크거나 같을때
								if(position[index][1] >= (position[j][1] + height)) {
									// Y좌표가 겹치지 않음으로써 X축도 겹치지 않음
									area[index] = width * height;
								} else {
									// Y좌표가 겹침
									int overlapY = (position[j][1] + height) - position[index][1];
									area[index] = (width * height) - (overlapX * overlapY);
								}
							} else {
								// 새로운 색종이의 Y좌표가 이전 색종이의 Y좌표보다 작을때
								if(position[index][1] + height <= position[j][1]) {
									// Y좌표가 겹치지 않음으로써 X축도 겹치지 않음
									area[index] = width * height;
								} else {
									int overlapY = (position[index][1] + height) - position[j][1];
									area[index] = (width * height) - (overlapX * overlapY);
								}
							}
						}
					} else {
						// 새로운 색종이의 X좌표가 이전 색종이의 X좌표보다 작거나 같을때 실행
						if(position[index][0] + width <= position[j][0]) {
							if(area[index] == 0) {
								area[index] = width * height;								
							}
						} else {
							if(position[index][0] + width <= position[j][0] + width) {
								//System.out.println("position[index][0] + width : " + (position[index][0] + width) + " / position[j][0] : " + position[j][0]);
								int overlapX = (position[index][0] + width) - position[j][0];
								if(position[index][1] >= position[j][1] + height) {
									area[index] = width * height;
								} else if(position[index][1] + height <= position[j][1]) {
									area[index] = width * height;
								} else if(position[index][1] >= position[j][1] && position[index][1] < position[j][1] + height) {
									int overlapY = (position[j][1] + height) - (position[index][1]);
									//System.out.println("overlapX : " + overlapX + " / overlapY : " + overlapY);
									area[index] = (width * height) - (overlapX * overlapY);
									//System.out.println(area[index]);
									//System.out.println(Arrays.toString(area));
								}
							}
						}
					}
				}
			}
			//System.out.println(Arrays.toString(area));
		}
		for(int index = 0; index < area.length; index++) {
			total += area[index];
		}
		System.out.println(total);
	}
}