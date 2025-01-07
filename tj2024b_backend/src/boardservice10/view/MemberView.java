package boardservice10.view;

public class MemberView {
	// singleton start
	private static MemberView instance = new MemberView();
	private MemberView() {}
	public static MemberView getInstance() { return instance; }
	// singleton end
}
