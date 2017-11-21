package week5;

public class UserInfoDrive {

	public static void main(String[] args) {
		/*
		 * Assignment1:创建两个对象，测试UserInfo；
		 * 调用setLocation,setAge,logOn,toString方法；
		 * @Author YuanHao
		 * */
		UserInfo user1 = new UserInfo("Jane","Lane");
		System.out.println(user1.toString());
		user1.setLocation("Auburn");
		user1.setAge(18);
		user1.logOn();
		System.out.println(user1.toString());
		
		UserInfo user2 = new UserInfo("Raby", "White");
		System.out.println(user2.toString());
		user2.setLocation("Qingdao");
		user2.setAge(19);
		user2.logOn();
		System.out.println(user2.toString());
	}

}
