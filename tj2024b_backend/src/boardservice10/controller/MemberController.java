package boardservice10.controller;

public class MemberController {
	// singleton start
	private static MemberController instance = new MemberController();
	private MemberController() {}
	public static MemberController getInstance() { return instance; }
	// singleton end
}
