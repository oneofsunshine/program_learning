package week7;

public class HumanTset {

	public static void main(String[] args) {
		Human aPerson = new Human(168);
		System.out.println("�������ǣ� "+aPerson.getHeight());
		aPerson.growHeight(50);
		System.out.println("���ߺ��������ǣ� "+aPerson.getHeight());
		aPerson.breath();
		aPerson.repeatBreath(5);
	}

}
