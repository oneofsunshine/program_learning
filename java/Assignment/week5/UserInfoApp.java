package week5;

public class UserInfoApp {

	public static void main(String[] args) {
		/*
		 * Assignment1:测试UserInfo
		 * @Author YuanHao;
		 * */
		UserInfo u = new UserInfo("Linda","Jiang");
		
		System.out.println(u);
		System.out.println();
		
		u.setAge(23);
		u.setLocation("Auburn");
		u.logOn();
		System.out.println(u);
		
	}

}
