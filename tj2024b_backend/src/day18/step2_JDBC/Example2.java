package day18.step2_JDBC;

public class Example2 {

	public static void main(String[] args) {
		Dao.getInstance();
		
		// insert 확인
		Dao.getInstance().insert();
		
		// select 확인
		Dao.getInstance().select("user");
		
		// update 확인 uno = 2의 uname을 강호동으로 변경
		Dao.getInstance().update();
		
		// delete 확인 uno가 3인 레코드 삭제
		Dao.getInstance().delete();
	}

}
