package week13;

interface CanFight
{
	void fight();
}
interface CanSwin
{
	void swim();
}
interface CanFly
{
	void fly();
}
class ActionCharacter
{
	public void fight()
	{
		System.out.println("can fight");
	}
}
class Hero extends ActionCharacter implements CanFight,CanFly,CanSwin
{
	public void swim() {
		System.out.println("can swim");
	}

	@Override
	public void fly() {
		System.out.println("can fly");
		// TODO Auto-generated method stub
		
	}
	
}
public class HeroTest {

	public static void main(String[] args) {
		Hero superman = new Hero();
		superman.fight();
		superman.fly();
		superman.swim();
	}

}
