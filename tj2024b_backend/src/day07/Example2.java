package day07;
import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		Product cola = new Product(), cider = new Product(), fanta = new Product();
		cola.name = "cola"; cola.price = 1000; cola.stock = 10;
		cider.name = "cider"; cider.price = 1500; cider.stock = 10;
		fanta.name = "fanta"; fanta.price = 2000; fanta.stock = 10;
		int colaBasket = 0, ciderBasket = 0, fantaBasket = 0;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("====== 키오스크 ======");
			System.out.print("1. 콜라 2. 사이다 3. 환타 4. 결재 : ");
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.print(">> 콜라를 선택했습니다.\n>> 몇개 구매하시겠습니까? : ");
				int count = scan.nextInt();
				if(cola.stock - count >= 0) {
					cola.stock -= count;
					colaBasket += count;
					System.out.println("남은 콜라 재고 : " + cola.stock);
				} else {
					System.out.println("콜라 재고가 모자랍니다. 총 재고량 : " + cola.stock);
				}
			} else if(choose == 2) {
				System.out.print(">> 사이다를 선택했습니다.\n>> 몇개 구매하시겠습니까? : ");
				int count = scan.nextInt();
				if(cider.stock - count >= 0) {
					cider.stock -= count;
					ciderBasket += count;
					System.out.println("남은 사이다 재고 : " + cider.stock);
				} else {
					System.out.println("사이다 재고가 모자랍니다. 총 재고량 : " + cider.stock);
				}
			} else if(choose == 3) {
				System.out.print(">> 환타를 선택했습니다.\n>> 몇개 구매하시겠습니까? : ");
				int count = scan.nextInt();
				if(fanta.stock - count >= 0) {
					fanta.stock -= count;
					fantaBasket += count;
					System.out.println("남은 환타 재고 : " + fanta.stock);
				} else {
					System.out.println("환타 재고가 모자랍니다. 총 재고량 : " + fanta.stock);
				}
			} else if(choose == 4) {
				System.out.println(">> 결재를 선택했습니다.");
				int total = (colaBasket * cola.price) + (ciderBasket * cider.price) + (fantaBasket * fanta.price);
				System.out.printf(">> 콜라 : %d개 사이다 : %d개 환타 : %d개\n>> 총 결제금액 : %d\n", colaBasket, ciderBasket, fantaBasket, total);
				colaBasket = 0; ciderBasket = 0; fantaBasket = 0;
			} else {
				break;
			}
		}
		scan.close();
	}

}
