package day17.step2;

public class HuntingGame implements Keyboard {
	@Override
	/** 공격 버튼 */
	public void aKey() {
		System.out.println("[공격]");
	}
	@Override
	/** 방어 버튼 */
	public void bKey() {
		System.out.println("[방어]");
	}
}
