package week2;

import java.util.Scanner;
public class Score {

	public static void main(String[] args) {
		float activity,homework,exam,homeworkPercent,examPercent,finalScore;
		float activityPercent;
		activityPercent= (float) 1.3;
		homeworkPercent = (float) 0.3;
		examPercent = (float) 0.4;
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入课堂活跃度成绩：");
		activity = scan.nextFloat();
		System.out.print("请输入作业成绩：");
		homework = (float) scan.nextDouble();
		System.out.print("请输入考试成绩：");
		exam = (float) scan.nextDouble();
		finalScore = activity * activityPercent + homework * homeworkPercent + exam * examPercent;
		System.out.print("最终成绩=" + finalScore);
	}
	
}
