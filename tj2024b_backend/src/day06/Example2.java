package day06;
import java.util.Scanner;
/*
	자바 과제4 : 키오스크 프로그램(배열, 객체 사용X)
	- 문법 : 변수, 입출력함수, 연산자, 제어문(조건문/반복문)
	- 제품은 콜라, 사이다, 환타 3개가 존재합니다.
	- 각 제품의 재고는 초기에 10개씩 존재한다.
	- 각 제품의 가격은 콜라 1000원, 사이다 1500, 환타 2000원으로 가정한다.
	- 제품을 선택시 선택한 제품 재고를 1차감하고 장바구니에 담는다.
	- 메뉴] 1. 콜라, 2. 사이다, 3. 환타, 4. 결제
		1 선택시 : 콜라 선택시 콜라 재고 1차감하고 장바구니에 담는다.
		2 선택시 : 사이다 선택시 사이다 재고 1차감하고 장바구니에 담는다.
		3 선택시 : 환타 선택시 환타 재고 1차감하고 장바구니에 담는다.
		4 선택시 : 핸재 장바구니에 담긴 모든 현황을 보여주고 금액을 합산하여 출력한다.
			예] 콜라 1개, 사이다 2개, 환타 0개 총금액 : 4000원 
		* 추가 유효성검사 : 만일 재고가 부족하면 "재고가 부족합니다"라고 출력하시오.
*/

public class Example2 {
	// basket
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int coke = 10, cider = 10, fanta = 10;
		int cokePrice = 1000, ciderPrice = 1500, fantaPrice = 2000;
		int cokeBasket = 0, ciderBasket = 0, fantaBasket = 0;
		
		while(true) {
			System.out.println("===== 키오스크 =====");
			System.out.print(">> 1. 콜라 2. 사이다 3. 환타 4. 결제 : ");
			int count = scan.nextInt();
			if(count == 1) {
				System.out.printf(">> 콜라를 선택하셨습니다.\n>> 재고 : %d\n>> 몇개를 구매하시겠습니까? : ", coke);
				int number = scan.nextInt();
				if(coke - number > 0) {					
					coke -= number;
					cokeBasket += number;
					System.out.println("남은 콜라의 개수 : " + coke);
				} else {
					System.out.println("콜라 재고가 부족합니다.\n");
				}
			} else if(count == 2) {
				System.out.printf(">> 사이다를 선택하셨습니다.\n>> 재고 : %d\n>> 몇개를 구매하시겠습니까? : ", cider);
				int number = scan.nextInt();
				if(cider - number > 0) {					
					cider -= number;
					ciderBasket += number;
					System.out.println("남은 사이다의 개수 : " + cider);
				} else {
					System.out.println("사이다 재고가 부족합니다..\n");
				}
			} else if(count == 3) {
				System.out.printf(">> 환타를 선택하셨습니다.\n>> 재고 : %d\n>> 몇개를 구매하시겠습니까? : ", fanta);
				int number = scan.nextInt();
				if(fanta - number > 0) {					
					fanta -= number;
					fantaBasket += number;
					System.out.println("남은 환타의 개수 : " + fanta);
				} else {
					System.out.println("환타 재고가 부족합니다..\n");
				}
			} else if(count == 4) {
				System.out.printf("콜라 : %d, 사이다 : %d, 환타 : %d개 담았습니다.\n", cokeBasket, ciderBasket, fantaBasket);
				System.out.printf("총금액은 %d입니다.\n", (cokePrice*cokeBasket) + (ciderPrice*ciderBasket) + (fantaPrice*fantaBasket));
				cokeBasket = 0; ciderBasket = 0; fantaBasket = 0;
			} else {
				break;
			}
		}
		scan.close();
	}

}
