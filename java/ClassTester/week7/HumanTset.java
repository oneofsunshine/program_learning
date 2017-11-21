package week7;

public class HumanTset {

	public static void main(String[] args) {
		Human aPerson = new Human(168);
		System.out.println("你的身高是： "+aPerson.getHeight());
		aPerson.growHeight(50);
		System.out.println("增高后，你的身高是： "+aPerson.getHeight());
		aPerson.breath();
		aPerson.repeatBreath(5);
	}

}
