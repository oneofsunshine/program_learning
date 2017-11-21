package week4;

import java.util.Scanner;

/*
 * Assignment4 创建 Dog 项目，在其下生成两个类 ,对GoodDog类的不同if分支进行测试
 * @author YuanHao
 */

public class GoodDogTestDrive {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		System.out.println("请输入三个数字（以空格隔开）： ");
		
		GoodDog one =new GoodDog(0);
		one.setSize(input.nextInt());
		one.bark();
		
		GoodDog two=new GoodDog(0);
		two.setSize(input.nextInt());
		two.bark();
		
		GoodDog three =new GoodDog(0);
		three.setSize(input.nextInt());
		three.bark();

	}

}
