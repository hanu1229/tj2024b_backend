package day07;

public class Example5 {

	public static void main(String[] args) {
		int[] scores = new int[] {50, 70, 60, 90, 100};
		int total = 0;
		for(int index = 0; index < scores.length; index++) {
			total += scores[index];
		}
		System.out.println("총점 : " + total + " 평균 : " + total/scores.length);
	}

}
