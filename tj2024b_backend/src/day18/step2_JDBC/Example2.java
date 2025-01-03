package day18.step2_JDBC;

public class Example2 {

	public static void main(String[] args) {
		Dao.getInstance();
		
		// insert 확인
		Dao.getInstance().insert();
		
		// select 확인
		Dao.getInstance().select("user");
	}

}
