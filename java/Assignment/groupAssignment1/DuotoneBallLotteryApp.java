package groupAssignment1;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * ·模拟双色球彩票;
 * 	• 双色球为红球和蓝球;
 * 	• 用户从1-33中自选6个数字（不能重复）代表红球（认真思考该采用何种数据结构存放红球）；从1-16中自选1个数字代表蓝球;
 * 	• 一等奖为中6个红球及蓝球，二等奖为仅中6个红球……
 * 	• 请自拟六个奖项对应的奖品;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
public class DuotoneBallLotteryApp {

	public static void main(String[] args) {
		
		int redRight;
		int blueInput;
		int blueRandom;
		int redGue;
		ArrayList<Integer> redGuess = new ArrayList<>();//代表用户输入的红球数字;
		
		RedBallCreater rbc = new RedBallCreater();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 6 numbers from 1 to 33 for red ball: ");
		
		/*
		 * 提示用户输入红球数字，如果输入数字大于33或者小于1，提示用户重新输入;
		 * 如果输入数字和之前输入的数字重复，提示用户重新输入;
		 * 将用户输入的红球数字储存;
		 * */
		System.out.print("Enter red ball number(1-33): ");
		redGue = Integer.parseInt(sc.nextLine());
		
		while(redGue < 1||redGue > 33)
		{
		System.out.print("Input error, please enter red ball number(1-33): ");
		redGue = Integer.parseInt(sc.nextLine());
		}//如果输入数字大于33或者小于1，提示用户重新输入;
		
		redGuess.add(redGue);
		
		for(int i = 0; i < 5; i++)
		{
			System.out.print("Enter red ball number(1-33): ");
			redGue = Integer.parseInt(sc.nextLine());
			
			while(redGue < 1||redGue > 33)
			{
			System.out.print("Input error, please enter red ball number(1-33): ");
			redGue = Integer.parseInt(sc.nextLine());
			}
			
			while(redGuess.indexOf(redGue) != -1)
			{
				System.out.print("This number has entered, please enter another number: ");
				redGue = Integer.parseInt(sc.nextLine());
			}//如果输入数字和之前输入的数字重复，提示用户重新输入;
			
			redGuess.add(redGue);
				
		}
		/*
		 * 提示用户输入蓝球数字，如果输入数字大于16或者小于1，提示用户重新输入;
		 * */
		System.out.print("\nEnter a number from 1 to 16 for blue ball: ");
		blueInput = Integer.parseInt(sc.nextLine());
		
		while(blueInput < 1||blueInput > 16)
		{
		System.out.print("Input error, please enter blue ball number(1-16): ");
		blueInput = Integer.parseInt(sc.nextLine());
		}
		
		blueRandom = (int)(Math.random()*16+1);//生成蓝球获奖数字;
		
		redRight = rbc.redRightNum(redGuess);//判断红球猜中个数;
		
		/*
		 * 输出红球和蓝球中奖数字及用户输入的数字;
		 * */
		System.out.println("\n"+rbc+"\nRight blue ball number is: "+blueRandom+"\n");
		System.out.println("Your input red ball numbers are: "+redGuess);
		System.out.println("Your input blue ball number is: "+blueInput+"\n");
		
		/*
		 * 输出用户获奖情况;
		 * */
		if(blueInput == blueRandom)
			switch(redRight)
			{
			case 6:System.out.println("一等奖，奖金100，000，000元");;break;
			case 5:System.out.println("三等奖，奖金500，000元");break;
			case 4:System.out.println("四等奖，奖金10，000元");break;
			case 3:System.out.println("五等奖，奖金5，000元");break;
			case 2:;
			case 1:;
			case 0:System.out.println("六等奖，奖金100元");break;
			default:System.out.println("未中奖");
			}
		else
			switch(redRight)
			{
			case 6:System.out.println("二等奖，奖金5，000，000元");break;
			case 5:System.out.println("四等奖，奖金10，000");break;
			case 4:System.out.println("五等奖，奖金5，000");break;
			default:System.out.println("未中奖");
			}
		
	}

}
