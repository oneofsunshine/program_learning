package finalExam;
/*
 * 2 :测试类，测试Species 类中的多个方法;
 * @ Author: YuanHao;
 * Sno: 15130041045;
 * */
public class SpeciesTest {

	public static void main(String[] args) {
		Species s1 = new Species();
		Species s2 = new Species();
		Species s3 = new Species();
		
		/*
		Scanner sc = new Scanner(System.in);
		Species[] s = new Species[3];
		String name;
		int population;
		double growthRate;
		for(int i = 0; i < 3; i++)
		{
			s[i] = new Species();
			System.out.println("请输入姓名，数量（整数），增长率：");
			name = sc.next();
			population = sc.nextInt();
			growthRate = sc.nextDouble();
			s[i].readInput(name, population, growthRate);
		}
		*/
		
		s1.readInput("Dog", 0, 0);
		s2.readInput("Cat", 0, 0);
		s3.readInput("Pig", 0, 0);
		
		s1.setPopulation(20);
		s1.setGrowthRate(0.1);
		
		s2.setPopulation(30);
		s2.setGrowthRate(0.3);
		
		s3.setPopulation(50);
		s3.setGrowthRate(0.5);
		
		if(s1.equals(s2))
			System.out.println(s1.getName() + " == " + s2.getName());
		else
			System.out.println(s1.getName() + " != " + s2.getName());
		
		System.out.println(s3.getName() + " has " + s3.predictPopulation(3) + " population after 3 years");
	}

}
