package day17.step2;

public interface Keyboard {
	// 1. 상수 : 수정이 불가능한 변수
	/** maker : 제조사 */
	public static final String maker = "HP";
	/** MFG : 제조일 */
	public static final String MFG = "2025-01-02";
		
	// 2. 추상메소드 : 메소드를 구현하지 않고 선언만 한다.
	/** A Button Click */
	public abstract void aKey();
	/** B Button Click */
	public abstract void bKey();
}
