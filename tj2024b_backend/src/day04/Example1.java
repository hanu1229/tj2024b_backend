package day04;

public class Example1 {

	public static void main(String[] args) {
		// p.102 switch
		int ranking = 1;
		char medalColor;
		
		switch(ranking) {
			case 1:
				medalColor = 'G';
				break;
			case 2:
				medalColor = 'S';
				break;
			case 3:
				medalColor = 'B';
				break;
			default:
				medalColor = 'A';
				break;
		}
		System.out.println("메달의 색깔은 : " + medalColor);
		
		// [2]
		int month = 10;
		int day = 0;
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day = 30;
				break;
			case 2:
				day = 28;
				break;
		}
		System.out.println(day);
		
		// [3]
		String medal = "Gold";
		switch(medal) {
			case "Gold":
				System.out.println("금메달입니다.");
				break;
			case "silver":
				System.out.println("은메달입니다.");
				break;
			case "bronze":
				System.out.println("동메달입니다.");
				break;
			default:
				System.out.println("메달이 없습니다.");
				break;
		}
		
		// [나 혼자 코딩]
		int floor = 3;
		switch(floor) {
			case 1:
				System.out.printf("%d층 약국입니다.\n", floor);
				break;
			case 2:
				System.out.printf("%d층 정형외과입니다.\n", floor);
				break;
			case 3:
				System.out.printf("%d층 피부과입니다.\n", floor);
				break;
			case 4:
				System.out.printf("%d층 치과입니다.\n", floor);
				break;
			case 5:
				System.out.printf("%d층 헬스 클럽입니다.\n", floor);
				break;
		}
	}

}
