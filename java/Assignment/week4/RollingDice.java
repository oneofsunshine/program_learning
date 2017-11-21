package week4;

public class RollingDice {

	public static void main(String[] args) {
		/*
		 * Assignment5: 模拟掷骰子
		 * @Author YuanHao
		 * */
		
		Die die1;
		Die die2;
		int sum;
		
		die1 = new Die();
		die2 = new Die();
		
		die1.roll();
		die2.roll();
		
		System.out.println("die1: "+die1+"\t"+"die2: "+die2);
		
		int i=die1.roll();
		die2.setFaceValue(4);
		
		System.out.println("die1: "+die1+"\t"+"die2: "+die2);
		
		sum = die1.getFaceValue()+die2.getFaceValue();
		
		System.out.println("sum1: "+sum);
		
		sum = die1.roll()+die2.roll();
		
		System.out.println("die1: "+die1+"\t"+"die2: "+die2);
		System.out.println("sum1: "+sum);
	}

}
